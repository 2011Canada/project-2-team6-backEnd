package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Credentials;
import com.revature.models.CurrentUser;
import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class LoginService {

	private UserRepository dao;
	
	@Autowired
	public LoginService(UserRepository dao) {
		super();
		
		this.dao = dao;
	}
	
	public CurrentUser validateUser(Credentials cred) {
		User user = dao.findByUserNameAndUserPassword(cred.getUserName(), cred.getPassword());
		CurrentUser currentUser = new CurrentUser(user.getUserId(),user.getUserName(),user.getFirstName(), user.getLastName());
		return currentUser;
		
	}

}