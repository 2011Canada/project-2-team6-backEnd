package com.revature.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Bookmark;
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
	
        
        @GetMapping("/books")
        public ResponseEntity<ArrayList<Bookmark>> verifyUser() {
        	HttpHeaders headers = new HttpHeaders();
        	headers.add("Content-Type","application/json");
            return new ResponseEntity<ArrayList<Bookmark>>(this.service.getAllBookmarks(), headers, HttpStatus.OK);
        }
        
}
