package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/fruitdb", initParams={
		@WebInitParam(name="db.driver", value="com.mysql.cj.jdbc.Driver"),
		@WebInitParam(name="db.url", value="jdbc:mysql://localhost:3306/dacdb"),
		@WebInitParam(name="db.user", value="nilesh"),
		@WebInitParam(name="db.passwd", value="nilesh"),
		@WebInitParam(name="theme", value="pink") 
	},
	loadOnStartup=1
)
public class FruitDbServlet extends HttpServlet {
	private Connection con;
	private PreparedStatement stmt;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("FruitDbServlet.init() called.");
		String DB_DRIVER = config.getInitParameter("db.driver");
		String DB_URL = config.getInitParameter("db.url");
		String DB_USER = config.getInitParameter("db.user");
		String DB_PASSWD = config.getInitParameter("db.passwd");
		try {
			// load and register driver
			Class.forName(DB_DRIVER);
			// create connection
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
			// prepare statement
			String sql = "INSERT INTO fruits(fruit) VALUES(?)";
			stmt = con.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e); // exception chaining
		}
	}
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("FruitDbServlet.destroy() called.");
		try {
			// close statement
			stmt.close();
			// close connection
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FruitDbServlet.processRequest() called.");
		int count = 0;
		String fruit = req.getParameter("fruit");
		try {
			// set param and execute query
			stmt.setString(1, fruit);
			count = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Fruit Db</title>");
		out.println("</head>");
		String theme = this.getInitParameter("theme");
		out.printf("<body bgcolor='%s'>\n", theme);
		out.println("<h2>FruitDb Servlet</h2>");
		out.println("Fruits inserted in db: " + count);
		out.println("</body>");
		out.println("</html>");
	}
}
