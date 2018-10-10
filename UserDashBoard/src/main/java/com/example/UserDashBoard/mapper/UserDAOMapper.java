package com.example.UserDashBoard.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.example.UserDashBoard.model.UserRequest;
public class UserDAOMapper implements RowMapper<UserRequest> {

		@Override
		public UserRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserRequest userRequest = new UserRequest();
			userRequest.setId(rs.getInt("id"));
			userRequest.setName(rs.getString("name"));
			userRequest.setEmail(rs.getString("email"));
			userRequest.setMobile(rs.getInt("mobile"));
			
			return userRequest;
		}

}
