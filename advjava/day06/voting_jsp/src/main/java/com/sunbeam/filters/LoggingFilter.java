package com.sunbeam.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class LoggingFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		System.out.println("LoggingFilter.init() called...");
	}
	@Override
	public void destroy() {
		Filter.super.destroy();
		System.out.println("LoggingFilter.destroy() called...");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest rq = (HttpServletRequest) req;
		System.out.println("Request Recieved..." + rq.getMethod() + "->" + rq.getRequestURI());
		// execute next component in chain
		chain.doFilter(req, resp);
		System.out.println("Request Handled...");
	}
}
