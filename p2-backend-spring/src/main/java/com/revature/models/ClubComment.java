package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="club_comments")
public class ClubComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int commentId;
	
	@JoinColumn(name="club_id")
	private int clubId;
	
	private String comment;
	
	@JoinColumn(name="user_id")
	private int userId;

	public ClubComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClubComment(int commentId, int clubId, String comment, int userId) {
		super();
		this.commentId = commentId;
		this.clubId = clubId;
		this.comment = comment;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ClubComment [commentId=" + commentId + ", clubId=" + clubId + ", comment=" + comment + ", userId="
				+ userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + clubId;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + commentId;
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
		ClubComment other = (ClubComment) obj;
		if (clubId != other.clubId)
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (commentId != other.commentId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	 
	
}
