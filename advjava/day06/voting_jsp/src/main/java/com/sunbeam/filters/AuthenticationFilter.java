package com.sunbeam.filters;

import java.io.IOException;

import com.sunbeam.beans.LoginBean;
import com.sunbeam.pojos.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//@WebFilter({"/candlist.jsp", "/result.jsp", "/vote.jsp", "/logout.jsp", "/newcand.jsp", "/editcand.jsp"})
public class AuthenticationFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// check if user is already logged in i.e. session -> lb -> user?
		HttpServletRequest rq = (HttpServletRequest) req;
		HttpSession session = rq.getSession(false);
			// if session exists, access it; but if not exists get null (no new session created)
		boolean auth = false;
		if(session != null) {
			LoginBean lb = (LoginBean) session.getAttribute("lb");
			if(lb != null) {
				User curUser = lb.getUser();
				if(curUser != null)
					auth = true;
			}
		}
		if(auth)
			chain.doFilter(req, resp);
		else {
			HttpServletResponse rs = (HttpServletResponse) resp;
			rs.sendRedirect("index.jsp");
		}
	}
}
