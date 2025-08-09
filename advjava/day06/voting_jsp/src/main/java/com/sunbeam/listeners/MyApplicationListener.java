package com.sunbeam.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyApplicationListener implements ServletContextListener {
	@Override // application start event - when app deployed & new servlet ctx created.
	public void contextInitialized(ServletContextEvent sce) {
		// ServletContextEvent obj contains info about the event i.e. servlet ctx object
		ServletContext ctx = sce.getServletContext();
		System.out.println("Application Started...");
	}
	
	@Override // application end event - when app undeployed & the servlet ctx to destroyed.
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Application Ended...");
	}
}
