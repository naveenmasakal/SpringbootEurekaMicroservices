package com.example.UserDashBoard.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CartDetails {

  private int cartId;
  private int userId;
  private String userSNo;
  private Date dateCreated ;
  private Date dateUpdated;
  private String checkedOut;
  private String status;
  private String session;
  private String agent;
  private List<CartItems> cartItemList =new ArrayList<CartItems>();

	  
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserSNo() {
		return userSNo;
	}
	public void setUserSNo(String userSNo) {
		this.userSNo = userSNo;
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
	public String getCheckedOut() {
		return checkedOut;
	}
	public void setCheckedOut(String checkedOut) {
		this.checkedOut = checkedOut;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public List<CartItems> getCartItemList() {
		return cartItemList;
	}
	public void setCartItemList(List<CartItems> cartItemList) {
		this.cartItemList = cartItemList;
	}
	@Override
	public String toString() {
		return "CartDetails [cartId=" + cartId + ", userId=" + userId + ", userSNo=" + userSNo + ", dateCreated="
				+ dateCreated + ", dateUpdated=" + dateUpdated + ", checkedOut=" + checkedOut + ", status=" + status
				+ ", session=" + session + ", agent=" + agent + ", cartItemList=" + cartItemList + "]";
	}
	
	  
		

}
