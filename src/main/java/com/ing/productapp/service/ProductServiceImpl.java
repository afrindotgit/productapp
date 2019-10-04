package com.ing.productapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;
import com.ing.productapp.controller.ProductController;
import com.ing.productapp.dto.CommonResponseDTO;
import com.ing.productapp.dto.ProductDetailResponseDTO;
import com.ing.productapp.dto.ProductInterfaceResponseDTO;
import com.ing.productapp.dto.ProductResponseDTO;
import com.ing.productapp.entity.Category;
import com.ing.productapp.entity.Product;
import com.ing.productapp.repository.CategoryRepository;
import com.ing.productapp.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public CommonResponseDTO upload(MultipartFile inputFile) throws IOException {
		
		CommonResponseDTO response = new CommonResponseDTO();
        XSSFSheet sheet = null;
        XSSFWorkbook workbook = null;
        
        try {
        	List<Product> productList = new ArrayList<>();
        	workbook = new XSSFWorkbook(inputFile.getInputStream());
        	sheet = workbook.getSheetAt(0);
        	Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();
        	
        	while (rowIterator.hasNext()) {
        		Row row = rowIterator.next();
        		Iterator<Cell> cellIterator = row.cellIterator();
        		String productName = "";
        		String description = "";
        		Double rating = 0.0;
        		Double price = 0.0 ;
        		
        		Cell cell = cellIterator.next();
                Product product = new Product();
                
                String categoryName = cell.getStringCellValue();
                
                if (cellIterator.hasNext()) {
                	Cell cell1 = cellIterator.next();
                    productName = cell1.getStringCellValue();
                }
                if (cellIterator.hasNext()) {
                    Cell cell2 = cellIterator.next();
                    description = cell2.getStringCellValue();
                }
                if (cellIterator.hasNext()) {
                    Cell cell3 = cellIterator.next();
                    price = cell3.getNumericCellValue();
                }
                if (cellIterator.hasNext()) {
                    Cell cell4 = cellIterator.next();
                    rating = cell4.getNumericCellValue();
                }
                
  
                Category categoryResponse=isCategory(categoryName);
                
                Product isproduct=productRepository.findByProductName(productName);
                //update
                if(isproduct != null) {
                	if (isproduct.getDescription().compareToIgnoreCase(description) != 0) {
                		isproduct.setDescription(description);
                		productList.add(isproduct);
                	}
                }
                //create
                else {
                	product.setCategoryId(categoryResponse);
                    product.setDescription(description);
                    product.setProductName(productName);
                    product.setPrice(price);
                    product.setRating(rating);
                    productList.add(product);
                }

                response.setMessage("success");
                response.setStatusCode(200);
        	}
        	 productRepository.saveAll(productList);
                
        	}
        	catch (Exception e) {
        		
        		LOGGER.error(this.getClass().getName(), e.getMessage());
        		response.setMessage("Failed");
                response.setStatusCode(404);

        	}

		return response;
	}
	
	public Category isCategory(String categoryName) {
		
		Category categoryResponse;
		Category category = new Category();
		Category isCategory=categoryRepository.findByCategoryName(categoryName);
		
        if(isCategory == null) {
        	category.setCategoryName(categoryName);
        	categoryResponse=categoryRepository.save(category);
        }
        else {
        	categoryResponse=isCategory;
        }
        
        return categoryResponse;
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

		productDetailResponseDTO.setCategory(product.getCategoryId());
		productDetailResponseDTO.setMessage("Successful");
		productDetailResponseDTO.setStatusCode(201);

		return productDetailResponseDTO;
	}
}
