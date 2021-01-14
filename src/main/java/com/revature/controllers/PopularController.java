package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.PopularCollection;
import com.revature.services.PopularService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/popular")
public class PopularController {
	PopularService service;
	
	@Autowired
	public PopularController(PopularService service) {
		this.service = service;
	}
	
        
        @PostMapping("/books")
        public ResponseEntity<PopularCollection> verifyUser() {
        	HttpHeaders headers = new HttpHeaders();
        	headers.add("Content-Type","application/json");
            return new ResponseEntity<PopularCollection>(this.service.getPopularBooksByUserId(1), headers, HttpStatus.OK);
        	//return new ResponseEntity<ArrayList<Bookmark>>(this.service.getBooksTest(1), headers, HttpStatus.OK);
        }
        
}
