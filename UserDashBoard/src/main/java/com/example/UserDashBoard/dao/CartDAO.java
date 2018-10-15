package com.example.UserDashBoard.dao;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.example.UserDashBoard.mapper.CartDAOMapper;
import com.example.UserDashBoard.model.CartItems;
import com.example.UserDashBoard.model.CartDetails;

@Repository
public class CartDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<CartDetails> getAllCartDetails() {

		return jdbcTemplate.query("select * from cart", new CartDAOMapper());
	}
	
	public CartItems getCartItemsByCartdId(String cartItemId) {
		String sql="select * from cartitems where CartItemId=?";
		RowMapper<CartItems> rowMapper = new BeanPropertyRowMapper<CartItems>(CartItems.class);
		return (CartItems) jdbcTemplate.queryForObject(sql, new Object[] { cartItemId }, rowMapper);
		
	}

	public CartDetails createCart(CartDetails cartResponse) {
				
		jdbcTemplate.update("INSERT INTO CART(CartId,userId,userSNo,DateCreated,DateUpdated,CheckedOut,status,session,agent) VALUES (?,?,?,?,?,?,?,?,?)",  
				cartResponse.getCartId(),cartResponse.getUserId(),cartResponse.getUserSNo(),	cartResponse.getDateCreated(),
				cartResponse.getDateUpdated(),cartResponse.getCheckedOut(),cartResponse.getStatus(),cartResponse.getSession(),cartResponse.getAgent());

		return cartResponse;
	}
	
	public CartItems createCartItems(CartItems cartItems) {
		jdbcTemplate.update("INSERT INTO CARTITEMS VALUES (?,?,?,?,?,?,?,?,?,?,?)",cartItems.getCartItemId(),cartItems.getCartId() ,
				cartItems.getProductId(),cartItems.getProductTypeId(),cartItems.getProductCategoryId(),
				cartItems.getSkuId(),cartItems.getQuantity(),cartItems.getPrice(),new Date(),
				new Date(),cartItems.getStatus());
				
		return cartItems;
	}

	
	public CartDetails updateOrcreateCartItems(CartDetails cartItems) {
		List<CartItems> cartItemLists=cartItems.getCartItemList();
		for(CartItems cartItemList:cartItemLists) {
			String sql="select count(*) from CARTITEMS where CartId=?";
			int cartCont = jdbcTemplate.queryForObject(sql, new Object[] { cartItems.getCartId() }, Integer.class);
			if(cartCont>0) {
				String sql1="update CARTITEMS set CartItemId=?,CartId=?,ProductId=?, Quantity=?,DateUpdated=? where CartId=? and ProductId=?";
				int result=jdbcTemplate.update(sql1,new Object[] {cartItemList.getCartItemId(),cartItemList.getCartId(),
						cartItemList.getProductId(),cartItemList.getQuantity(),new Date(),cartItemList.getCartId(),cartItemList.getProductId()});
			}
			else {
				createCartItems(cartItemList);
				
			}
		}
		return cartItems;
	}
}
