package com.ing.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.productapp.dto.CategoryInterfaceResponseDto;
import com.ing.productapp.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findAll();

}
