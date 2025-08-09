package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get current user from session
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		// if user status == true, show message "already voted".
		if(user.isStatus() == true) {
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Vote</title>");
			out.println("</head>");
			out.println("<body>");
			
			ServletContext app = req.getServletContext();
			String title = app.getInitParameter("appTitle");
			out.println("<h1>" + title + "</h1> <hr/>");

			out.println("<h2>Already Voted.</h2>");
			out.println("<a href='logout'>Sign Out</a>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		// change user status = true in database
		user.setStatus(true);
		try(UserDao userDao = new UserDaoImpl()) {
			int count = userDao.update(user);
			System.out.println("User status updated: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// get candidate id from prev page
		String candId = req.getParameter("candidate");
		int id = Integer.parseInt(candId);
		// increment candidate votes
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			int count = candDao.incrVote(id);
			System.out.println("Candidate votes incremented: " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// show message to user
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Vote</title>");
		out.println("</head>");
		out.println("<body>");

		ServletContext app = req.getServletContext();
		String title = app.getInitParameter("appTitle");
		out.println("<h1>" + title + "</h1> <hr/>");

		out.println("<h2>Congratulations!</h2>");
		out.println("Your vote registered successfully.<br/><br/>\n");
		out.println("<a href='logout'>Sign Out</a>");
		out.println("</body>");
		out.println("</html>");
	}
}
