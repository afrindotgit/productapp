package com.ing.productapp.repository;

import java.util.List;

import com.ing.productapp.entity.Category;

public interface CategoryRepository {

	List<Category> findAll();

}
