package com.sunbeam.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // mandatory
@RequestMapping("/test")//to specify class level base url pattern
public class TestController {
	public TestController() {
		System.out.println("in ctor "+getClass());
	}
	/*
	 * Desc - add new method for rendering 
	 * dynamic response(eg time stamp)
	 * URL - http://host:port/ctx/test/test1 test2 test3.....
	 * Method - GET
	 * Payload - none
	 * Resp - render dyn resp
	 * Handler Mapping
	 * key - /test/test1
	 * value - F.Q class name .methodName
	 */
	@GetMapping("/test1") //=@RequestMapping(method=GET)
	public ModelAndView testModelAnView() {
		System.out.println("in test 1");
		/*
		 * o.s.w.s.ModelAndView - class which holds 
		 *  - model attributes => data | results
		 *  - LVN (logical view name)
		 *  Constructor 
		 *  public ModelAndView(String LVN , 
		 *  String modelAttributeName,
		 *  Object modelAttributeValue)
		 */
		return new ModelAndView("test/display", "time_stamp", 
				LocalDateTime.now());
		/*
		 * Handler rets -> ModelAndView -> D.S (DispatcherServlet)
		 * D.S sends -> LVN -> V.R(ViewResolver)
		 * V.R rets -> AVN : /WEB-INF/views/test/display.jsp -> D.S
		 * D.S checks for model attributes -> yes 
		 * -> D.S adds model attribute -> under request scope
		 * -> D.S forwards request -> view (JSP)
		 * 
		 */
	}
}
