package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserDao;

@Service
	public class UserService {
		
		
		UserDao ud; 
		
		@Autowired
		public UserService(UserDao ud) {
			this.ud = ud;
		}
		
		public User saveUser(User user) {
			return ud.saveAndFlush(user);
		}

}
