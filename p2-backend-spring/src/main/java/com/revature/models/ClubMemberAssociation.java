  
package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@IdClass(ClubMemberAssociationCompositeKey.class)
@Table(name="club_members")
public class ClubMemberAssociation {
	@Id
	@JoinColumn(name="user_id")
	private int userId;
	
	@Id
	@JoinColumn(name="club_id")
	private int clubId;

	public ClubMemberAssociation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubMemberAssociation(int userId, int clubId) {
		super();
		this.userId = userId;
		this.clubId = clubId;
	}

	@Override
	public String toString() {
		return "ClubMemberAssociation [userId=" + userId + ", clubId=" + clubId + "]";
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
		ClubMemberAssociation other = (ClubMemberAssociation) obj;
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