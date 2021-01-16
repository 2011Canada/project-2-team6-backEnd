package com.revature.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Club;
import com.revature.models.ClubBookAssociation;
import com.revature.models.ClubComment;

public interface ClubCommentsDao extends JpaRepository<ClubComment, Integer>{
	public ArrayList<ClubComment> findByClubId(int clubId);
}