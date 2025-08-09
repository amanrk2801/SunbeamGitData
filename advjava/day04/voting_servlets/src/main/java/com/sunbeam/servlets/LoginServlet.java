package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String passwd = req.getParameter("passwd");
		
		try(UserDao userDao = new UserDaoImpl()) {
			User dbUser = userDao.findByEmail(email);
			if(dbUser != null && dbUser.getPasswd().equals(passwd)) {
				// login successful
				System.out.println("Login Successful!!");
				// create cookie for user name and send to client
				String userName = dbUser.getFirstName() + dbUser.getLastName();
				Cookie c = new Cookie("uname", userName);
				c.setMaxAge(3600); // seconds
				resp.addCookie(c);
				// store user in session
				HttpSession session = req.getSession();
				session.setAttribute("user", dbUser);
				
				if(dbUser.getRole().equals("voter")) {
					// go to CandidateListServlet
					resp.sendRedirect("candlist");
				}
				else if(dbUser.getRole().equals("admin")) {
					// go to ResultServlet
					resp.sendRedirect("result");
					// forward to ResultServlet
					//RequestDispatcher rd = req.getRequestDispatcher("result");
					//rd.forward(req, resp);
				}
			}
			else {
				// login failed
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Login</title>");
				out.println("</head>");
				out.println("<body>");
				
				ServletContext app = req.getServletContext();
				String title = app.getInitParameter("appTitle");
				out.println("<h1>" + title + "</h1> <hr/>");

				out.println("<h2>Login Failed</h2>");
				out.println("<a href='index.html'>Login Again</a>");
				out.println("</body>");
				out.println("</html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
