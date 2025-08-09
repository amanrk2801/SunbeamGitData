package com.sunbeam.controller;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public ModelAndView testModelAndView() {
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
	}
		/*
		 * Handler rets -> ModelAndView -> D.S (DispatcherServlet)
		 * D.S sends -> LVN -> V.R(ViewResolver)
		 * V.R rets -> AVN : /WEB-INF/views/test/display.jsp -> D.S
		 * D.S checks for model attributes -> yes 
		 * -> D.S adds model attribute -> under request scope
		 * -> D.S forwards request -> view (JSP)
		 * 
		 */
		/*
		 * Desc - add new method for rendering 
		 * dynamic response(eg time stamp n list of numbers)
		 * URL - http://host:port/ctx/test/test2 
		 * Method -Get
		 * Payload - none
		 * Resp - render dyn resp (time stamp n list of numbers)
		 * Handler Mapping
		 * key - /test/test2
		 * value - TestController.testModelMap
		 */
		@GetMapping("/test2")
		public String testModelMap(Model modelMap)
		{
			System.out.println("in test model map "+modelMap);//{}
			//add results in model map
			modelMap.addAttribute("server_time", LocalTime.now())
			.addAttribute("number_list", List.of(10, 20, 30));
			return "test/display2";//AVN - /WEB-INF/views/test/display2.jsp
		}
		

}
