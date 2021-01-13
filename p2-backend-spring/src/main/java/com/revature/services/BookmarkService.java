package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Bookmark;
import com.revature.models.User;
import com.revature.repositories.BookmarkDao;


@Service
public class BookmarkService {
	
	BookmarkDao bd; 
	
	@Autowired
	public BookmarkService(BookmarkDao bd) {
		this.bd = bd;
	}
	
	public Bookmark saveBookmark(Bookmark b) {
		return bd.saveAndFlush(b);
	}
	
	public List<Bookmark> findBookmarksByUserId(int user_id) {
		return bd.findByUserId(user_id);
	}
	
	public int deleteBookmarkByUserIdAndBookId(int user_id, String book_id) {
		return bd.deleteByUserIdAndBookId(user_id, book_id);
	}
	
	
	
}
