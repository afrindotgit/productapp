package com.ing.productapp.dto;

import java.util.List;

import com.ing.productapp.entity.Category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryResponseDto {
	private String message;
	private Integer statusCode;
	private List<Category> data;
	
}
