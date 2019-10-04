package com.ing.productapp.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductResponseDTO {
	 
	private String message;
	
	private Integer statusCode;
	
	private List<ProductInterfaceResponseDTO> productInterfaceResponseDto;

}
