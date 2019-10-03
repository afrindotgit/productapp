package com.ing.productapp.service;

import com.ing.productapp.dto.ProductDetailResponseDTO;
import com.ing.productapp.dto.ProductResponseDTO;

public interface ProductService {
	
	public ProductResponseDTO upload();
	
	public ProductResponseDTO viewProducts(Long categoryId);
	
	public ProductDetailResponseDTO viewDetails(Long productId);
}
