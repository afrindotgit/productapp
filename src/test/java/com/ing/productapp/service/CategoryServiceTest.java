package com.ing.productapp.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
	
	List<Category> categoryList = new ArrayList<Category>();
	
	@Before
	public void setup() {
		category = new Category();
		category.setCategoryId(1L);
		category.setCategoryName("footwear");
		categoryList.add(category);
		
	}
		


		@Test
		public void testViewCategories() {
			
			Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
			CategoryResponseDto categoryResponseDto=categoryServiceImpl.viewCategories();
			
			
	}
}
