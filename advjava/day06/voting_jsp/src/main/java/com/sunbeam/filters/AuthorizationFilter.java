package com.sunbeam.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sunbeam.beans.LoginBean;
import com.sunbeam.pojos.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthorizationFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		List<String> voterUrls = new ArrayList<>();
		Collections.addAll(voterUrls, "/voting_jsp/candlist.jsp", "/voting_jsp/vote.jsp", "/voting_jsp/logout.jsp");
		List<String> adminUrls = new ArrayList<>();
		Collections.addAll(adminUrls, "/voting_jsp/result.jsp", "/voting_jsp/newcand.jsp", "/voting_jsp/editcand.jsp", "/voting_jsp/logout.jsp");
		
		HttpServletRequest rq = (HttpServletRequest) req;
		HttpServletResponse rs = (HttpServletResponse) resp;
		String uri = rq.getRequestURI();
		boolean authorized = false;
		
		HttpSession session = rq.getSession(false);
		LoginBean lb = (LoginBean) session.getAttribute("lb");
		User curUser = lb.getUser();
		String role = curUser.getRole();
		
		if(role.equals("admin"))
			authorized = adminUrls.contains(uri);
		else if(role.equals("voter"))
			authorized = voterUrls.contains(uri);
		
		if(authorized)
			chain.doFilter(req, resp);
		else
			//rs.sendError(403);
			rs.sendRedirect("index.jsp");
	}
}
