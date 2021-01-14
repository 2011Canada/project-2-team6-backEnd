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
	
	
	public ArrayList<Bookmark> getBooksTest(int id) {
		return dao.findByUserId(id);
	}
	
	public PopularCollection getPopularBooksByUserId(int id) {
		ArrayList<Bookmark> collection = dao.findByUserId(id);
		PopularCollection bookCollection = new PopularCollection();
		Iterator<Bookmark> iterator = collection.iterator();
		while (iterator.hasNext()) {
			PopularBookArray bookArray = new PopularBookArray();
			
			while(bookArray.isEmpty()) {
				Bookmark bm = iterator.next();
				PopularBook book = new PopularBook();
				book.setBookId(bm.getBookId());
				book.setImgUrl(bm.getImgUrl());
				bookArray.addElement(book); //
			}
			System.out.println(bookArray);
			
			bookCollection.addBookArray(bookArray);
		}
		return bookCollection;
	}

}