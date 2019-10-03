package com.ing.productapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ing.product.dto.CategoryInterfaceResponseDto;
import com.ing.product.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryInterfaceResponseDto> viewCategories() {
			List<CategoryInterfaceResponseDto> listCategory=categoryRepository.findByAll();	
			
	    return listCategory;
	}

	
}
