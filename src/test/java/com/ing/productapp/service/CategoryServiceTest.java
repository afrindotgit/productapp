package com.ing.productapp.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import com.ing.productapp.dto.CategoryResponseDto;
import com.ing.productapp.entity.Category;
import com.ing.productapp.repository.CategoryRepository;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {
	
	@Mock
	CategoryRepository categoryRepository;
	
	@InjectMocks
	CategoryServiceImpl categoryServiceImpl;
	
	@Mock
	Category category;
	
	CategoryResponseDto categoryResponseDto;
	
	@Before
	public void setup() {
		category = new Category();
		category.setCategoryId(1L);
		category.setCategoryName("footwear");
		
		categoryResponseDto=new CategoryResponseDto();
		categoryResponseDto.setMessage("success");
		categoryResponseDto.setStatusCode(201);
		List<Category> category = new ArrayList<Category>();
		
		categoryResponseDto.setCategory(category);
	}
		


		@Test
		public void testViewCategories() {
			
			CategoryResponseDto categoryResponseDto = categoryServiceImpl.viewCategories();
			
			
	}
}
