package com.ing.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ing.product.dto.CategoryInterfaceResponseDto;
import com.ing.productapp.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<CategoryInterfaceResponseDto> viewCategories(@PathVariable("category_id") Long category_id) {
		List<CategoryInterfaceResponseDto> listCategory = categoryService.viewCategories();
		return listCategory;
	}
	
	
	
	
	

}
