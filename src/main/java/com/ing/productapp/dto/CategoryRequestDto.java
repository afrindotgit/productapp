package com.ing.productapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CategoryRequestDto {
	
	private Long categoryId;
	private String categoryName;

}
