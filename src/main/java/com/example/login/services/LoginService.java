package com.example.login.services;

import java.util.List;

import com.example.login.model.User;

public interface LoginService {
	
	
	List<User> get();
	
	User get(String username);
	
	void save(User user);
	
	void delete(String username);
}
