package com.revature.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.GenericGenerator;

public class BookmarkCompositeKey implements Serializable {
	
	private String bookId;
	
	private int userId;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookmarkCompositeKey other = (BookmarkCompositeKey) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BookmarkCompositeKey [bookId=" + bookId + ", userId=" + userId + "]";
	}

	public BookmarkCompositeKey(String bookId, int userId) {
		super();
		this.bookId = bookId;
		this.userId = userId;
	}

	public BookmarkCompositeKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
