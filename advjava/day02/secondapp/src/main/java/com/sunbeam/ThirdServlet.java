package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/third")
public class ThirdServlet extends HttpServlet {
	// user-defined method
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Third</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Third Servlet</h2>");
		out.println("<h4>" + req.getMethod() + " Request</h4>");
		String value = req.getParameter("fruit");
			// useful - text, password, textarea, radio, dropdown, single-selection list
		//String[] values = req.getParameterValues("control-name");
			// useful - checkboxes, multi-selection listbox
		out.println("<h4> Sweet " + value + "</h4>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}



