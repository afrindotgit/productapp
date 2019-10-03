package com.ing.productapp.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.ing.productapp.dto.ProductDetailResponseDTO;

import com.ing.productapp.dto.ProductResponseDTO;

public interface ProductService {
	
	public ProductResponseDTO upload(MultipartFile inputFile) throws IOException;
	
	public ProductResponseDTO viewProducts(Long categoryId);
	
	public ProductDetailResponseDTO viewDetails(Long productId);
}
