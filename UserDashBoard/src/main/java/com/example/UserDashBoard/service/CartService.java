package com.example.UserDashBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.UserDashBoard.dao.CartDAO;
import com.example.UserDashBoard.model.CartItems;
import com.example.UserDashBoard.model.CartDetails;

@Component
public class CartService {
	
		
	@Autowired
	private CartDAO cartDAO;

	public List<CartDetails> getAllCartDetails() {
		return cartDAO.getAllCartDetails();
	}
	
	public CartItems getCartItemsByCartdId(String id) {
		return cartDAO.getCartItemsByCartdId(id);
	}

	public CartDetails createCart(CartDetails cartResponse) {
		return cartDAO.createCart(cartResponse);
	}
	
	public CartItems createCartItems(CartItems cartItems) {
		return cartDAO.createCartItems(cartItems);
	}
	
	public CartDetails updateOrcreateCartItems(CartDetails cartDetails) {
		return cartDAO.updateOrcreateCartItems(cartDetails);
	}
	
}
