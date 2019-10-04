package com.ing.productapp.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

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

	@Test
	public void testViewProducts() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/categories/{categoryId}/products", 1)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

	}
	
	@Test
	public void testUpload() throws Exception {
		Resource resource = new ClassPathResource("ingprd_data.xlsx");
		File file = resource.getFile();
		MockMultipartFile mockMultipartFile = new MockMultipartFile("file", new FileInputStream(file));
		mockMvc.perform(MockMvcRequestBuilders.multipart("/products").file(mockMultipartFile)).andExpect(status().isOk());

	}
}
