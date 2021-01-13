package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.models.User;
import com.revature.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/register")
public class UserController {
		
	private UserService us; 
		
	@Autowired
	public UserController(UserService us) {
		this.us = us; 
	}
		
	@PostMapping
		public ResponseEntity<User> saveNewUser(@RequestBody User user) {
			
			return new ResponseEntity<User>(us.saveUser(user), HttpStatus.CREATED);
		}
	}