package com.ing.productapp.service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.productapp.dto.ProductDetailResponseDTO;
import com.ing.productapp.dto.ProductResponseDTO;
import com.ing.productapp.entity.Category;
import com.ing.productapp.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	@Mock
	ProductRepository productRepository;
	
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Mock
	ProductResponseDTO productResponseDTO;
	
	Category category;
	
	ProductDetailResponseDTO productDetailResponseDTO;
	
	@Before(value = "")
	public void setup() {
		category=new Category();
		category.setCategoryId(1L);
		category.setCategoryName("clothing");
		
		productResponseDTO=new ProductResponseDTO();
		productResponseDTO.setMessage("success");
		productResponseDTO.setStatusCode(1);
		//List<ProductInterfaceResponseDto> productInterfaceResponseDto=new ArrayList<productInterfaceResponseDto>();
		//productResponseDTO.setProductInterfaceResponseDto(productInterfaceResponseDto);
		
		productDetailResponseDTO=new ProductDetailResponseDTO();
		productDetailResponseDTO.setProductId(1L);
		productDetailResponseDTO.setDescription("good");
		productDetailResponseDTO.setMessage("success");
		productDetailResponseDTO.setPrice(2598.00);
		productDetailResponseDTO.setProductName("clothing");
		productDetailResponseDTO.setRating(5.0);
		productDetailResponseDTO.setStatusCode(1);
		
		}
	
	@Test
	public void TestUpload()
	{
		//Mockito.when(productRepository(Mockito.anyDouble())).thenReturn(null);
		//Mockito.when(ViewProducts.findByEmail(Mockito.anyString())).thenReturn(null);


	}
	
	
	
	
	

}
