package com.ing.productapp.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ing.productapp.dto.ProductResponseDTO;
import com.ing.productapp.service.ProductService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<ProductResponseDTO> upload(@RequestParam("file") MultipartFile inputFile) throws IOException {
		LOGGER.info("Inside Method upload");

		ProductResponseDTO customerResponseDTO = productService.upload(inputFile);
		return new ResponseEntity<>(customerResponseDTO, HttpStatus.CREATED);
	}
}
