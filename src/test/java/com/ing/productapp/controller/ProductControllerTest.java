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

import com.ing.productapp.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	@Mock
	ProductService productService;

	@InjectMocks
	ProductController productController;

	MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

	}

	@Test
	public void testView() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/products/{productId}", 19L)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	/*
	 * @Test public void testUpload() throws IOException {
	 * mockMvc.perform(MockMvcRequestBuilders.get("/products"))
	 * 
	 * ProductResponseDTO customerResponseDTO = productService.upload(inputFile);
	 * return new ResponseEntity<>(customerResponseDTO, HttpStatus.CREATED); }
	 */

	@Test
	public void testViewProducts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/categories/{categoryId}/products", 1)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
}
