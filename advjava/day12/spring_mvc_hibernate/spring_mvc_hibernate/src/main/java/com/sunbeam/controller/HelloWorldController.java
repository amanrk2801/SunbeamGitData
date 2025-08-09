package com.sunbeam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandatory class level annotation to declare spring bean
//containing req handling logic(P.L)
public class HelloWorldController {

	public HelloWorldController() {
		System.out.println("in ctor of "+getClass());
	}
	/*
	 * Add req handling method to render index page
	 * URL - http://host:port/ctx_path/
	 * Method - GET
	 * Payload - none
	 * Resp - index.jsp
	 * Entry will be added under HandlerMapping
	 * key - /
	 * value - com.sunbeam.controller.
	 * HelloWorldController.renderIndexPage
	 */
	@RequestMapping("/")
	public String renderIndexPage() {
		System.out.println("in render index page ....");
		//return Logical (forward) view name to the caller
		return "index";
	}
	

}
