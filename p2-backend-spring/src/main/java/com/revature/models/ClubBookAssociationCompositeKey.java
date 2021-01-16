package com.revature.models;

import java.io.Serializable;

public class ClubBookAssociationCompositeKey implements Serializable{
	private String bookId;
	private int clubId;
	public ClubBookAssociationCompositeKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClubBookAssociationCompositeKey(String bookId, int clubId) {
		super();
		this.bookId = bookId;
		this.clubId = clubId;
	}
	@Override
	public String toString() {
		return "ClubBookAssociationCompositeKey [bookId=" + bookId + ", clubId=" + clubId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + clubId;
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
		ClubBookAssociationCompositeKey other = (ClubBookAssociationCompositeKey) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (clubId != other.clubId)
			return false;
		return true;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	
}