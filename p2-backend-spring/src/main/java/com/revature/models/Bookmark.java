package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@IdClass(BookmarkCompositeKey.class)
@Table(name="bookmarks")
public class Bookmark {
	
	@Id
	@Column(name="book_id")
	private String bookId;
	
	@Id
	@JoinColumn(name="user_id")
	private int userId;
	
    @Column(name="book_img")
	private String bookImage;
	
	@Column(name="book_title")
	private String bookTitle;

	public Bookmark() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bookmark(String bookId, int userId, String bookImage, String bookTitle) {
		super();
		this.bookId = bookId;
		this.userId = userId;
		this.bookImage = bookImage;
		this.bookTitle = bookTitle;
	}

	@Override
	public String toString() {
		return "Bookmark [bookId=" + bookId + ", userId=" + userId + ", bookImage=" + bookImage + ", bookTitle="
				+ bookTitle + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((bookImage == null) ? 0 : bookImage.hashCode());
		result = prime * result + ((bookTitle == null) ? 0 : bookTitle.hashCode());
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
		Bookmark other = (Bookmark) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (bookImage == null) {
			if (other.bookImage != null)
				return false;
		} else if (!bookImage.equals(other.bookImage))
			return false;
		if (bookTitle == null) {
			if (other.bookTitle != null)
				return false;
		} else if (!bookTitle.equals(other.bookTitle))
			return false;
		if (userId != other.userId)
			return false;
		return true;
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

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	
	



}



	
	

