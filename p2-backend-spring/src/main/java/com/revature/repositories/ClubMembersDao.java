package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Club;
import com.revature.models.ClubMemberAssociation;

public interface ClubMembersDao extends JpaRepository<ClubMemberAssociation, Integer>{
	public ArrayList<ClubMemberAssociation> findByClubId(int clubId);
}