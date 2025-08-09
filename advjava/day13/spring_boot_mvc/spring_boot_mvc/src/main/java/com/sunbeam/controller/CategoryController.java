package com.sunbeam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
