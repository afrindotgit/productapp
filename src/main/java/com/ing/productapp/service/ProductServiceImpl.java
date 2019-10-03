package com.ing.productapp.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ing.productapp.dto.ProductResponseDTO;
import com.ing.productapp.entity.Category;
import com.ing.productapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	

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
}
