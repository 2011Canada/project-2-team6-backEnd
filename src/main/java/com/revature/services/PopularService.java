package com.revature.services;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Bookmark;
import com.revature.models.PopularBook;
import com.revature.models.PopularBookArray;
import com.revature.models.PopularCollection;
import com.revature.repositories.BookmarkRepository;

@Service
public class PopularService {

	private BookmarkRepository dao;
	
	@Autowired
	public PopularService(BookmarkRepository dao) {
		super();
		this.dao = dao;
	}
	
	
	public ArrayList<Bookmark> getAllBookmarks() {
		return dao.findAll();
	}
	
	

}