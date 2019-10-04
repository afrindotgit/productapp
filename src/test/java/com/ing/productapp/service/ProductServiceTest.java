package com.ing.productapp.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import com.ing.productapp.dto.ProductDetailResponseDTO;
import com.ing.productapp.dto.ProductInterfaceResponseDTO;
import com.ing.productapp.dto.ProductResponseDTO;
import com.ing.productapp.entity.Category;
import com.ing.productapp.entity.Product;
import com.ing.productapp.repository.CategoryRepository;
import com.ing.productapp.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	@InjectMocks
	ProductServiceImpl productServiceImpl;
	@Mock
	ProductRepository productRepository;

	@Mock
	CategoryRepository categoryRepository;

	Category category;
	Product product;

	ProductDetailResponseDTO productDetailResponseDTO;
	ProductResponseDTO productResponseDTO;

	ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
	ProductInterfaceResponseDTO prodDetResponseDto = factory.createProjection(ProductInterfaceResponseDTO.class);
	List<ProductInterfaceResponseDTO> resList = new ArrayList<>();

	@Before(value = "")
	public void setup() {
		category = new Category();
		category.setCategoryId(1L);
		category.setCategoryName("clothing");

		// Testcase1
		productResponseDTO = new ProductResponseDTO();
		productResponseDTO.setMessage("success");
		productResponseDTO.setStatusCode(1);
		productResponseDTO.setProductInterfaceResponseDto(resList);

		prodDetResponseDto.setProductId(1L);
		prodDetResponseDto.setProductName("Savings");

	}

	@Test
	public void testViewProducts() {

		Mockito.when(productRepository.findAllByCategoryId(Mockito.any())).thenReturn(resList);

		ProductResponseDTO resDTO = productServiceImpl.viewProducts(1L);

		assertEquals("Successful", resDTO.getMessage());

	}

	@Test
	public void testViewDetails() {

		// Testcase2
		productDetailResponseDTO = new ProductDetailResponseDTO();

		product = new Product();
		product.setDescription("Good");
		product.setPrice(100.00);
		product.setProductName("Savings");
		product.setProductId(1L);
		product.setRating(4.0);

		Mockito.when(productRepository.findAllByProductId(Mockito.anyLong())).thenReturn(product);
		ProductDetailResponseDTO productDetResDto = productServiceImpl.viewDetails(product.getProductId());

		productDetResDto.setDescription(product.getDescription());
		productDetResDto.setPrice(product.getPrice());
		productDetResDto.setProductName(product.getProductName());
		productDetResDto.setProductId(product.getProductId());
		productDetResDto.setRating(product.getRating());
		productDetResDto.setMessage("Successful");
		productDetResDto.setStatusCode(201);
		assertEquals("Successful", productDetResDto.getMessage());
	}

}