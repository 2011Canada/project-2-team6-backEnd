package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Bookmark;
import com.revature.models.User;
import com.revature.services.BookmarkService;
import com.revature.services.UserService;

@CrossOrigin(origins="http://ec2-13-58-108-231.us-east-2.compute.amazonaws.com")
@RestController
@RequestMapping("/users")
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
	
	@GetMapping("/{userId}")
		public ResponseEntity<User> getUser(@PathVariable int userId) {
		    User user = us.getUserById(userId);
		    user.setPassword(null);
		
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}
