package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.pojos.Candidate;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editcand")
public class EditCandidateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get candidate id (from query string)
		String candId = req.getParameter("candid");
		int id = Integer.parseInt(candId);
		// find candidate in database
		Candidate cand = null;
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			cand = candDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit</title>");
		out.println("</head>");
		out.println("<body>");
		
		ServletContext app = req.getServletContext();
		String title = app.getInitParameter("appTitle");
		out.println("<h1>" + title + "</h1> <hr/>");

		out.println("<h2>Edit Candidate</h2>");

		// get username from cookie and display it
		String userName = "";
		Cookie[] arr = req.getCookies();
		if(arr != null) {
			for (Cookie c : arr) {
				if(c.getName().equals("uname"))
					userName = c.getValue();
			}
		}
		out.println("Hello, " + userName + "<hr/>");

		// show candidate info in html form
		out.println("<form method='post' action='editcand'>");
		out.printf("<input type='hidden' name='id' value='%d' readonly/> <br/>\n", cand.getId());
		out.printf("Name: <input type='text' name='name' value='%s'/> <br/>\n", cand.getName());
		out.printf("Party: <input type='text' name='party' value='%s'/> <br/>\n", cand.getParty());
		out.printf("Votes: <input type='text' name='votes' value='%d' readonly/> <br/>\n", cand.getVotes());
		out.println("<input type='submit' value='Update Candidate'/>");
		out.println("</form>");
		
		out.println("<a href='result'>Back</a>");
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get candidate details from submitted form - req params
		int candId = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String party = req.getParameter("party");
		int votes = Integer.parseInt(req.getParameter("votes"));
		// update candidate in database
		int count = 0;
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			Candidate c = new Candidate(candId, name, party, votes);
			count = candDao.update(c);
			System.out.println("Candidates Updated: " + count);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		// go to result servlet
		String msg = "Candidates Updated: " + count;
		req.setAttribute("msg", msg);
		ServletContext ctx = req.getServletContext();
		RequestDispatcher rd = ctx.getRequestDispatcher("/result");
		rd.forward(req, resp);
	}
}
