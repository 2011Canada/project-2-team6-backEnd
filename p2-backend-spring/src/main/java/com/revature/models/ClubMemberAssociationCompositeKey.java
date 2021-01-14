package com.revature.models;

import java.io.Serializable;

public class ClubMemberAssociationCompositeKey implements Serializable{
	private int userId;
	private int clubId;
	public ClubMemberAssociationCompositeKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClubMemberAssociationCompositeKey(int userId, int clubId) {
		super();
		this.userId = userId;
		this.clubId = clubId;
	}
	@Override
	public String toString() {
		return "ClubMemberAssociationCompositeKey [userId=" + userId + ", clubId=" + clubId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clubId;
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
		ClubMemberAssociationCompositeKey other = (ClubMemberAssociationCompositeKey) obj;
		if (clubId != other.clubId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	
	
}
