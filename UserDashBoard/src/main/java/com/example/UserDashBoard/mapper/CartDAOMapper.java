package com.example.UserDashBoard.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.example.UserDashBoard.model.CartDetails;
public class CartDAOMapper implements RowMapper<CartDetails> {

		@Override
		public CartDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			CartDetails cartResponse = new CartDetails();
			cartResponse.setCartId(rs.getInt("CartId"));
			cartResponse.setUserId(rs.getInt("userId"));
			cartResponse.setUserSNo(rs.getString("userSNo"));
			cartResponse.setDateCreated(rs.getDate("DateCreated"));
			cartResponse.setDateUpdated(rs.getDate("DateUpdated"));
			cartResponse.setCheckedOut(rs.getString("CheckedOut"));
			cartResponse.setStatus(rs.getString("status"));
			cartResponse.setSession(rs.getString("session"));
			cartResponse.setAgent(rs.getString("agent"));
			return cartResponse;
		}

}
