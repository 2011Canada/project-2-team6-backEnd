package com.revature.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Club;

public interface ClubsDao extends JpaRepository<Club, Integer>{
	
	@Transactional
	public int deleteByClubId(int clubId);
	
	public Club findByClubId(int clubId);
	
	
}
