package com.ing.productapp.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ing.productapp.service.CategoryService;

@RunWith(MockitoJUnitRunner.class)
public class CategoryControllerTest {


	@InjectMocks
	CategoryController categoryController;
	
	@Mock
	CategoryService categoryService;
	
	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();

	}

	@Test
	public void testViewCategories() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/categories", 19L)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	
	
}