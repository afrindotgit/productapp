package com.ing.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.product.dto.CategoryInterfaceResponseDto;
import com.ing.productapp.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	List<CategoryInterfaceResponseDto> findByAll();

	
	

}
