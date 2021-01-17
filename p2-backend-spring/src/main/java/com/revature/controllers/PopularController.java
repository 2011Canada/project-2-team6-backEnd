package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Bookmark;
import com.revature.services.PopularService;
@CrossOrigin(origins = "http://ec2-13-58-108-231.us-east-2.compute.amazonaws.com")
@RestController
public class PopularController {
	PopularService service;
	
	@Autowired
	public PopularController(PopularService service) {
		this.service = service;
	}
	
        
        @GetMapping(path="/popular")
        public ResponseEntity<List<Bookmark>> getAllBookmarks() {
            return new ResponseEntity(this.service.getAllBookmarks(), HttpStatus.OK);
        }
        
}
