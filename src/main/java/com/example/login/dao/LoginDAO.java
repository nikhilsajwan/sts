package com.example.login.dao;

import java.util.List;

import com.example.login.model.User;

public interface LoginDAO {
	
	List<User> get();
	
	User get(String username);
	
	void save(User user);
	
	void delete(String username);
	
}
