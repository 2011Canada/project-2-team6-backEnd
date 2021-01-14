package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.revature.models.User;
@Repository
public interface LoginDao extends JpaRepository<User,Integer> {
	
	public User findByUserNameAndUserPassword(String userName, String password);

}