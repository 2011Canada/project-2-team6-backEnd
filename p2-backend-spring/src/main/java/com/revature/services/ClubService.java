package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Club;
import com.revature.models.ClubBookAssociation;
import com.revature.models.ClubComment;
import com.revature.models.ClubMemberAssociation;
import com.revature.models.User;
import com.revature.repositories.ClubBooksDao;
import com.revature.repositories.ClubCommentsDao;
import com.revature.repositories.ClubsDao;
import com.revature.repositories.ClubMembersDao;

@Service
public class ClubService {
	ClubsDao cld;
	ClubBooksDao clbd;
	ClubMembersDao clmd;
	ClubCommentsDao clcd;
	UserService us;
	
	@Autowired
	public ClubService(ClubsDao cld, ClubBooksDao clbd, ClubMembersDao clmd, ClubCommentsDao clcd, UserService us) {
		this.cld = cld;
		this.clbd = clbd;
		this.clmd = clmd;
		this.clcd = clcd;
		this.us = us;
	}
	public List<Club> getAllClubs() {
		return cld.findAll();
	}
	public Club saveClub(Club club) {
		return cld.saveAndFlush(club);
	}
	
	public int deleteClubByClubId(int id) {
		return cld.deleteByClubId( id); 
	}
	
	public Club getClubByClubId(int clubId) {
		return cld.findByClubId(clubId);
	}
	
	public String getClubDescriptionByClubId(int clubId) {
		return cld.findByClubId(clubId).getClubDescription();
	}
	public Club updateClubDescriptionByClubId(int clubId, String newDescription) {
		Club club = cld.findByClubId(clubId);
		if(club==null) {
			return null;
		}
		club.setClubDescription(newDescription);
		return cld.save(club);
	}
	
	public Club updateClubNameByClubId(int clubId, String newName) {
		Club club = cld.findByClubId(clubId);
		if(club==null) {
			return null;
		}
		club.setClubName(newName);
		return cld.save(club);
	}
	
	public ClubMemberAssociation saveClubMemberAssociation(ClubMemberAssociation cma) {
		return clmd.saveAndFlush(cma);
	}
	
	public void removeClubMemberAssociation(ClubMemberAssociation cma) {
		clmd.delete(cma);
	}
	
	public List<User> getUsersByClubId(int clubId) {
		ArrayList<ClubMemberAssociation> membersCMA = clmd.findByClubId(clubId);
		
		ArrayList<User> members = new ArrayList<User>();
		for(ClubMemberAssociation memberCMA: membersCMA ) {
			int userid = memberCMA.getUserId();
			members.add(us.getUserById(userid));
		}
		return members;
	} 
	
	public List<Integer> getUserIdsByClubId(int clubId) {
		List<User> users;
		ArrayList<Integer> usersIds = new ArrayList<Integer>();
		users = getUsersByClubId(clubId);
		for(User user: users) {
			usersIds.add(user.getUserId());
		}
		return usersIds;
	}
	
	public ClubBookAssociation saveClubBookAssociation(ClubBookAssociation cba) {
		return clbd.saveAndFlush(cba);
	}
	
	public void removeClubBookAssociation(ClubBookAssociation cba) {
		clbd.delete(cba);
	}
	
	public ClubComment saveClubComment(ClubComment cc) {
		return clcd.save(cc);
	
	}
	
	public List<ClubComment> getClubCommentsByClubId(int clubId) {
		return clcd.findByClubId(clubId);
	}
	
	public User getUserByClubComment(ClubComment cc) {
		int userid = cc.getUserId();
		return us.getUserById(userid);
	}
	
	public void removeClubComment(ClubComment cc) {
		clcd.delete(cc);
	}
	
	public List<String> getBooksByClubId(int clubId) {
		ArrayList<ClubBookAssociation> results = clbd.findByClubId(clubId);
		ArrayList<String> bookIds = new ArrayList<String>();
		for(ClubBookAssociation cba: results) {
			bookIds.add(cba.getBookId());
		}
		return bookIds;
		
		
	}
	
	
	
	
	
}