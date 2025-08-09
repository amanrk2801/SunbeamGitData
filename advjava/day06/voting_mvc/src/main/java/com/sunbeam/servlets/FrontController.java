package com.sunbeam.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ctl")
public class FrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String dest = "/index.jsp";
		if(page.equals("index"))
			dest = "/index.jsp";
		else if(page.equals("newuser"))
			dest = "/newuser.jsp";
		else if(page.equals("login"))
			dest = "/WEB-INF/views/login.jsp";
		else if(page.equals("register"))
			dest = "/WEB-INF/views/register.jsp";
		else if(page.equals("result"))
			dest = "/WEB-INF/views/result.jsp";
		else if(page.equals("candlist"))
			dest = "/WEB-INF/views/candlist.jsp";
	
		// forward req to destination page
		ServletContext ctx = req.getServletContext();
		RequestDispatcher rd = ctx.getRequestDispatcher(dest);
		rd.forward(req, resp);
	}
}
