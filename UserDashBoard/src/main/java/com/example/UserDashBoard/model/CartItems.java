package com.example.UserDashBoard.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class CartItems {

	private int cartItemId;
	private int cartId;
	private int productId;
	private int productTypeId;
	private int productCategoryId;
	private String skuId;
	private int quantity;
	private float price;
	private Date dateCreated;
	private Date dateUpdated;
	private String status;

	public int getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CartItems [cartItemId=" + cartItemId + ", cartId=" + cartId + ", productId=" + productId
				+ ", productTypeId=" + productTypeId + ", productCategoryId=" + productCategoryId + ", skuId=" + skuId
				+ ", quantity=" + quantity + ", price=" + price + ", dateCreated=" + dateCreated + ", dateUpdated="
				+ dateUpdated + ", status=" + status + "]";
	}

}
