package com.ing.productapp.dto;

public class ProductDetailResponseDTO {
	
	private Long productId;
	private String productName;
	private Double price;
	private Double rating;
	private String description;
	private String message;
	private Integer statusCode;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
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
	
	@Override
	public String toString() {
		return "ProductDetailResponseDTO [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", rating=" + rating + ", description=" + description + ", message=" + message + ", statusCode="
				+ statusCode + "]";
	}


}
