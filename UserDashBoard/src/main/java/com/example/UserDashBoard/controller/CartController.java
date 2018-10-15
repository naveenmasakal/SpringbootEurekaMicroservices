
package com.example.UserDashBoard.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserDashBoard.model.CartItems;
import com.example.UserDashBoard.model.CartDetails;
import com.example.UserDashBoard.service.CartService;

@RestController
@RequestMapping("cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value ="/getAllCartDetails" , method = RequestMethod.GET, produces = "application/json")
	public List<CartDetails> getAllCartDetails() {
		return cartService.getAllCartDetails();

	}

	@RequestMapping(value ="/cartItemId/{cartItemId}", method = RequestMethod.GET, produces = "application/json")
	public CartItems getCartItemsByCartdId(@PathVariable String cartItemId) {
		
		return cartService.getCartItemsByCartdId(cartItemId);

	}
	

	@RequestMapping(value = "/createCart",    method = RequestMethod.POST, produces = "application/json")
	public CartDetails createCart(@RequestBody CartDetails cartResponse) {
 
        return cartService.createCart(cartResponse);
 
    }
	
	@RequestMapping(value = "/createCartItems",    method = RequestMethod.POST, produces = "application/json", consumes="application/json")
	public CartItems createCartItems(@RequestBody CartItems cartItems) {
 
        return cartService.createCartItems(cartItems);
 
    }
	
	@RequestMapping(value = "/updateOrCreateCartItems",    method = RequestMethod.PUT, produces = "application/json", consumes="application/json")
	public CartDetails updateOrcreateCartItems(@RequestBody CartDetails CartDetails) {
 
        return cartService.updateOrcreateCartItems(CartDetails);
 
    }

}
