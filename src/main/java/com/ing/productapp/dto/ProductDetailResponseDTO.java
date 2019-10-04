package com.ing.productapp.dto;

import com.ing.productapp.entity.Category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDetailResponseDTO {
	
	private Long productId;
	private String productName;
	private Double price;
	private Double rating;
	private String description;
	private String message;
	private Integer statusCode;
	private Category category;

}
