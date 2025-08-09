package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunbeam.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	//depcy
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list")
	public String listCategories(Model map) {
		System.out.println("in list "+map);
		//call service layer method , add result to model map
		map.addAttribute("category_list", categoryService.getCategories());
		return "categories/list";
	}
	/*
	 * 
	 * Desc - get category and product details
	 * URL - http://host:port/category/details?categoryId=....
	 * Method GET
	 * payload - none 
	 * Resp - render view  (with data : category + product list) 
	 */
	@GetMapping("/details")
	public String getCategoryAndProductDetails(@RequestParam 
			Long categoryId,Model map)
	{
		System.out.println("in category details "+categoryId);
		
		map.addAttribute("category_details", categoryService.
				getCompleteDetails(categoryId));
		return "categories/details";
	}
	 

}
