package com.ing.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.productapp.dto.ProductInterfaceResponseDTO;
import com.ing.productapp.entity.Category;
import com.ing.productapp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<ProductInterfaceResponseDTO> findAllByCategoryId(Category categoryId);
	
	Product findAllByProductId(Long productId);
}
