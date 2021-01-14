package com.revature.models;

import java.util.ArrayList;

public class PopularCollection {
	ArrayList<PopularBookArray> bookCollection = new ArrayList<PopularBookArray>();

	public PopularCollection() {
		super();
	}
	
	public void addBookArray(PopularBookArray array) {
		this.bookCollection.add(array);
	}

	public ArrayList<PopularBookArray> getList() {
		return bookCollection;
	}

	public void setList(ArrayList<PopularBookArray> list) {
		this.bookCollection = list;
	}
	

}
