package com.ing.productapp.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.productapp.dto.ProductDetailResponseDTO;
import com.ing.productapp.dto.ProductInterfaceResponseDTO;
import com.ing.productapp.dto.ProductResponseDTO;
import com.ing.productapp.entity.Category;
import com.ing.productapp.entity.Product;
import com.ing.productapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ProductResponseDTO upload() {

		return null;
	}

	@Override
	public ProductResponseDTO viewProducts(Long categoryId) {
		Category category=new Category();
		ProductResponseDTO productResponseDto=new ProductResponseDTO();
		category.setCategoryId(categoryId);
		List<ProductInterfaceResponseDTO> productInterfaceResponseDto=productRepository.findAllByCategoryId(category);
		productResponseDto.setMessage("Successful");
		productResponseDto.setStatusCode(201);
		productResponseDto.setProductInterfaceResponseDto(productInterfaceResponseDto);
		return productResponseDto;
	}

	@Override
	public ProductDetailResponseDTO viewDetails(Long productId) {
		
		Product product=productRepository.findAllByProductId(productId);
		
		ProductDetailResponseDTO productDetailResponseDTO=new ProductDetailResponseDTO();
		
		org.springframework.beans.BeanUtils.copyProperties(product, productDetailResponseDTO);
		
		productDetailResponseDTO.setProductId(product.getProductId());
		productDetailResponseDTO.setProductName(product.getProductName());
		productDetailResponseDTO.setRating(product.getRating());
		productDetailResponseDTO.setPrice(product.getPrice());
		productDetailResponseDTO.setDescription(product.getDescription());
		productDetailResponseDTO.setMessage("Successful");
		productDetailResponseDTO.setStatusCode(201);
		
		return productDetailResponseDTO;
	}
}
