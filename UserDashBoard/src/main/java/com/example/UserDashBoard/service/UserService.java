package com.example.UserDashBoard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.UserDashBoard.dao.UserDAO;
import com.example.UserDashBoard.model.UserRequest;

@Component
public class UserService {
	
	@Autowired
	private UserDAO userDAO;

	public List<UserRequest> getUserDetails() {
		return userDAO.getUserDetails();
	}
	
	public UserRequest getUserById(String id) {
		return userDAO.getUserById1(id);
	}

	public UserRequest addUser(UserRequest userDetails) {
		return userDAO.addUser(userDetails);
	}

	public String updateUser(int id, UserRequest user) {
		// TODO Auto-generated method stub
		return  userDAO.updateUser(id, user);
	}
	
}
