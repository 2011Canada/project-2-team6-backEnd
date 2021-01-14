package com.revature.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Bookmark;
@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark,String> {
	
	public ArrayList<Bookmark> findByUserId(int id);
	
	public ArrayList<Bookmark> findAll();

}
