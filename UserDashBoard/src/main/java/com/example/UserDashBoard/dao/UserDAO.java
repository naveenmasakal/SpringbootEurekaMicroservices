package com.example.UserDashBoard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.UserDashBoard.mapper.UserDAOMapper;
import com.example.UserDashBoard.model.UserRequest;

@Repository
public class UserDAO {
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	


	public List<UserRequest> getUserDetails() {
		return jdbcTemplate.query("select * from user", new UserDAOMapper());
	}
	
	public UserRequest getUserById1(String id) {
		String sql="select * from user where id=?";
		//return (UserRequest) jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper(UserRequest.class));
		UserRequest userRequest = (UserRequest) jdbcTemplate.queryForObject(sql, new Object[] { id }, new UserDAOMapper());
		return userRequest;
		
	}
	
	
	public List<UserRequest> getUserDetails1(){  
		 return jdbcTemplate.query("select * from user",new RowMapper<UserRequest>(){  
			 
		    @Override  
		    public UserRequest mapRow(ResultSet rs, int rownumber) throws SQLException {  
		    	UserRequest userRequest=new UserRequest();  
		    	userRequest.setId(rs.getInt("id"));
				userRequest.setName(rs.getString("name"));
				userRequest.setEmail(rs.getString("email"));
				userRequest.setMobile(rs.getInt("mobile"));
		        return userRequest;  
		    }  
		    });  
	}  

	public UserRequest addUser(UserRequest userDetails) {
				
		jdbcTemplate.update("INSERT INTO USER (id, name, email,mobile) VALUES (?,?,?,?)",  userDetails.getId(), userDetails.getName(),userDetails.getEmail(),userDetails.getMobile());

		return userDetails;
	}

	public String updateUser(int id, UserRequest user) {
		
		String sql="update user set name=?,email=?,mobile=? where id=?";
		int result=jdbcTemplate.update(sql,new Object[] {user.getName(),user.getEmail(),user.getMobile(),id});
		if(result==0) {
			return "User not updated";}

		else return "User has been updated";
	}
	
}
