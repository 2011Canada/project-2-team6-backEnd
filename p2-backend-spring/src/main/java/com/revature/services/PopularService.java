package com.revature.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Bookmark;
import com.revature.models.PopularBook;
import com.revature.repositories.BookmarkDao;

@Service
public class PopularService {

	private BookmarkDao dao;
	
	@Autowired
	public PopularService(BookmarkDao dao) {
		super();
		this.dao = dao;
	}
	
	
	public List<Bookmark> getAllBookmarks() {
		return dao.findAll();
	}
	
	
	

}
