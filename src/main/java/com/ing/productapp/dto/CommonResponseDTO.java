package com.ing.productapp.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonResponseDTO {

	private String message;
	private Integer statusCode;
	
}
