package com.example.UserDashBoard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserDashBoard.model.UserRequest;
import com.example.UserDashBoard.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<UserRequest> getAllUsers() {

		return userService.getUserDetails();

	}

	@RequestMapping(value ="/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public UserRequest getUser(@PathVariable String id) {
		
		return userService.getUserById(id);

	}
	
	@RequestMapping(value ="/id1/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<UserRequest> getUser1(@PathVariable String id) {
		
		UserRequest userResponse=userService.getUserById(id);
		if (userResponse == null) {
            return new ResponseEntity<UserRequest>(HttpStatus.NOT_FOUND);
        }
		else return new ResponseEntity<UserRequest>(userResponse, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/createUser",    method = RequestMethod.POST, produces = "application/json")
	public UserRequest addUser(@RequestBody UserRequest userDetails) {
 
        return userService.addUser(userDetails);
 
    }
	
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Object> updateUser(@PathVariable("id") int id, @RequestBody UserRequest user) {
        String status=userService.updateUser(id,user);
        return new ResponseEntity<Object>( "{\"status\":\""+status+"\"}", HttpStatus.OK);
    }

}
