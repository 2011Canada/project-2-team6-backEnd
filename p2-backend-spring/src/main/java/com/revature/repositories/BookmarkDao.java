package com.revature.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Bookmark;
import com.revature.models.User;

@Repository
public interface BookmarkDao extends JpaRepository<Bookmark, Integer>{

	public List<Bookmark> findByUserId(int user_id);
	
	@Transactional
	public int deleteByUserIdAndBookId(int user_id, String bookmark_id);
}
