package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clubs")
public class Club {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="club_id")
	private int clubId;
	
	@Column(name="club_name")
	private String clubName;
	
	@Column(name="club_description")
	private String clubDescription;

	public Club() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Club(int clubId, String clubName, String clubDescription) {
		super();
		this.clubId = clubId;
		this.clubName = clubName;
		this.clubDescription = clubDescription;
	}

	@Override
	public String toString() {
		return "Club [clubId=" + clubId + ", clubName=" + clubName + ", clubDescription=" + clubDescription + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clubDescription == null) ? 0 : clubDescription.hashCode());
		result = prime * result + clubId;
		result = prime * result + ((clubName == null) ? 0 : clubName.hashCode());
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
		Club other = (Club) obj;
		if (clubDescription == null) {
			if (other.clubDescription != null)
				return false;
		} else if (!clubDescription.equals(other.clubDescription))
			return false;
		if (clubId != other.clubId)
			return false;
		if (clubName == null) {
			if (other.clubName != null)
				return false;
		} else if (!clubName.equals(other.clubName))
			return false;
		return true;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getClubDescription() {
		return clubDescription;
	}

	public void setClubDescription(String clubDescription) {
		this.clubDescription = clubDescription;
	}
	
	
	
}