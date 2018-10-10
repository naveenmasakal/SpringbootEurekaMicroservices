package com.example.UserDashBoard.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
	public UserRequest getUserById(String id) {
		String sql="select * from user where id=?";
		return (UserRequest) jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper(UserRequest.class));
		//return (UserRequest) jdbcTemplate.queryForObject(sql, new Object[] {id},  UserRequest.class);
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
