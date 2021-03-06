package com.revature.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Bookmark;
import com.revature.services.BookmarkService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@CrossOrigin(origins = "http://ec2-13-58-108-231.us-east-2.compute.amazonaws.com")
@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {
	
	private BookmarkService bms; 
	
	@Autowired
	public BookmarkController(BookmarkService bms) {
		this.bms = bms; 
	}
	
	@GetMapping("/{user_id}")
	public ResponseEntity<List<Bookmark>> getBookmarkByUserId(@PathVariable int user_id) {
		return new ResponseEntity(bms.findBookmarksByUserId(user_id), HttpStatus.OK);
	}
	@PostMapping
	public ResponseEntity<Bookmark> saveNewCustomer(@RequestBody Bookmark bm) {
		
		return new ResponseEntity<Bookmark>(bms.saveBookmark(bm), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{user_id}/{book_id}")
	public ResponseEntity<Bookmark> deleteBookmarkByUserIdAndBookmarkId(@PathVariable int user_id, @PathVariable String book_id) {
		return new ResponseEntity(bms.deleteBookmarkByUserIdAndBookId(user_id, book_id), HttpStatus.OK);
	}
}
