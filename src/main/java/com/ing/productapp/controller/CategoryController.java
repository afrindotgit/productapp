package com.ing.productapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.productapp.dto.CategoryResponseDto;
import com.ing.productapp.service.CategoryService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public CategoryResponseDto viewCategories() {
		return categoryService.viewCategories();
	}
	
	
	
	
	

}
