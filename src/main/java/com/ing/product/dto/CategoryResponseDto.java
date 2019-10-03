package com.ing.product.dto;

public class CategoryResponseDto {
	private Integer statusCode;
	private String message;
	public Integer getStatusCode() {
		return statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
