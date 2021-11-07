package com.example.Campings.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Campings.bo.Login;
import com.example.Campings.dal.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repo;
  
	public Login login(String username, String password) {
		Login user = repo.findByUsernameAndPassword(username, password);
		return user;
  }
 
}
