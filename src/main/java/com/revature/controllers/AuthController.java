package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Credentials;
import com.revature.models.CurrentUser;
import com.revature.services.LoginService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/login")
public class AuthController {
	LoginService service;
	
	@Autowired
	public AuthController(LoginService service) {
		this.service = service;
	}
	
        
        @PostMapping("/verify")
        public ResponseEntity<CurrentUser> verifyUser(@RequestBody Credentials user) {
        	HttpHeaders headers = new HttpHeaders();
        	headers.add("Content-Type","application/json");
 if ((user.getUserName() == "") || user.getPassword()=="") {
	 return new ResponseEntity<CurrentUser>(new CurrentUser(), HttpStatus.NOT_FOUND);
 }
            return new ResponseEntity<CurrentUser>(this.service.validateUser(user), headers, HttpStatus.OK);
        }
        
}
