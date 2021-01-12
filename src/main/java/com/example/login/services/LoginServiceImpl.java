package com.example.login.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.login.dao.LoginDAO;
import com.example.login.model.User;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Transactional
	@Override
	public User get(String username) {


		return loginDAO.get(username);
	}
	
	@Transactional
	@Override
	public void save(User user) {
		loginDAO.save(user);

	}
	
	@Transactional
	@Override
	public void delete(String username) {
		loginDAO.delete(username);

	}

	@Transactional
	@Override
	public List<User> get() {
		return loginDAO.get();
	}

}
