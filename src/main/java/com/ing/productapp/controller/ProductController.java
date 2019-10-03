package com.ing.productapp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ing.productapp.dto.ProductDetailResponseDTO;
import com.ing.productapp.dto.ProductRequestDTO;
import com.ing.productapp.dto.ProductResponseDTO;
import com.ing.productapp.service.ProductService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	@PostMapping("/registration")
	public ResponseEntity<ProductResponseDTO> upload(@RequestBody ProductRequestDTO productRequestDTO) {
		LOGGER.info("Inside Method upload");

		ProductResponseDTO customerResponseDTO = productService.upload();
		return new ResponseEntity<>(customerResponseDTO, HttpStatus.CREATED);
	}
	
	@GetMapping("/categories/{categoryId}/products")
	public ProductResponseDTO viewProducts(@Valid @PathVariable Long categoryId) {
		return productService.viewProducts(categoryId);
		
	}
	
	@GetMapping("/products/{productId}")
	public ProductDetailResponseDTO viewDetails(@Valid @PathVariable Long productId) {
		return productService.viewDetails(productId);
		
	}
	
}
