package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Bookmark;
import com.revature.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	public User getByUserId(int userId);
}
