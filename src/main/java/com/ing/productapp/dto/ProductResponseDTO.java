package com.ing.productapp.dto;

import java.util.List;

public class ProductResponseDTO {
	 
	private String message;
	
	private Integer statusCode;
	
	private List<ProductInterfaceResponseDTO> productInterfaceResponseDto;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public List<ProductInterfaceResponseDTO> getProductInterfaceResponseDto() {
		return productInterfaceResponseDto;
	}

	public void setProductInterfaceResponseDto(List<ProductInterfaceResponseDTO> productInterfaceResponseDto) {
		this.productInterfaceResponseDto = productInterfaceResponseDto;
	}

	@Override
	public String toString() {
		return "ProductResponseDTO [message=" + message + ", statusCode=" + statusCode
				+ ", productInterfaceResponseDto=" + productInterfaceResponseDto + "]";
	}

}
