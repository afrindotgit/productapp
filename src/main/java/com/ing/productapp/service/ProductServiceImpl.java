package com.ing.productapp.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ing.productapp.dto.ProductDetailResponseDTO;
import com.ing.productapp.dto.ProductInterfaceResponseDTO;
import com.ing.productapp.dto.ProductResponseDTO;
import com.ing.productapp.entity.Category;
import com.ing.productapp.entity.Product;
import com.ing.productapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductResponseDTO upload(MultipartFile inputFile) throws IOException {
		Category category = new Category();
		Set<String> set = new HashSet<>();

		if (!inputFile.isEmpty()) {
			byte[] bytes = inputFile.getBytes();
			String completeData = new String(bytes);
			String[] rows = completeData.split("\r\n");

			for (String row : rows) {
				String[] columns = row.split(",");
				String cat = columns[0].toString();
				if (!cat.equalsIgnoreCase("Category"))
					set.add(columns[0].toString());
			}

			/*
			 * set.forEach(s->s);
			 * 
			 * productRepository.save(category);
			 */

			System.out.println(set);
			/*
			 * for (String cat : columns) {
			 * 
			 * }
			 */

		}

		return null;
	}

	@Override
	public ProductResponseDTO viewProducts(Long categoryId) {
		Category category = new Category();
		ProductResponseDTO productResponseDto = new ProductResponseDTO();
		category.setCategoryId(categoryId);
		List<ProductInterfaceResponseDTO> productInterfaceResponseDto = productRepository.findAllByCategoryId(category);
		productResponseDto.setMessage("Successful");
		productResponseDto.setStatusCode(201);
		productResponseDto.setProductInterfaceResponseDto(productInterfaceResponseDto);
		return productResponseDto;
	}

	@Override
	public ProductDetailResponseDTO viewDetails(Long productId) {

		Product product = productRepository.findAllByProductId(productId);

		ProductDetailResponseDTO productDetailResponseDTO = new ProductDetailResponseDTO();

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
