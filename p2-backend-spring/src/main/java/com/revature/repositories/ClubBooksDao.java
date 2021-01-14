package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Club;
import com.revature.models.ClubBookAssociation;

public interface ClubBooksDao extends JpaRepository<ClubBookAssociation, Integer>{
	public ArrayList<ClubBookAssociation> findByClubId(int clubId);
}
