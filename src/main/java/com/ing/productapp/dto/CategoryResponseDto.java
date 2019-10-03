package com.ing.productapp.dto;

import java.util.List;

import com.ing.productapp.entity.Category;

public class CategoryResponseDto {
	private String message;
	private Integer statusCode;
	private List<Category> data;
	public String getMessage() {
		return message;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public List<Category> getCategory() {
		return data;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public void setCategory(List<Category> category) {
		this.data = category;
	}
	@Override
	public String toString() {
		return "CategoryResponseDto [message=" + message + ", statusCode=" + statusCode + ", category=" + data
				+ "]";
	}
	
}
