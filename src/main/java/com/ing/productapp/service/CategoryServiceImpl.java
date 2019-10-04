package com.ing.productapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.productapp.dto.CategoryResponseDto;
import com.ing.productapp.entity.Category;
import com.ing.productapp.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public CategoryResponseDto viewCategories() {
		
			List<Category> categories=categoryRepository.findAll();
			
			CategoryResponseDto categoryResponseDto=new CategoryResponseDto();
			categoryResponseDto.setCategory(categories);
			categoryResponseDto.setMessage("Successfull");
			categoryResponseDto.setStatusCode(201);
			
	    return categoryResponseDto;
	}

	
}
