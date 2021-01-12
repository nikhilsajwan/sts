package com.example.login.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.login.model.User;


@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public User get(String username) {
		Session currentSession = entityManager.unwrap(Session.class);
		User userObj = currentSession.get(User.class, username);
		return userObj;
	}

	@Override
	public void save(User user) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(user);
		

	}

	@Override
	public void delete(String username) {
		Session currentSession = entityManager.unwrap(Session.class);
		User userObj = currentSession.get(User.class, username);
		currentSession.delete(userObj);

	}

	@Override
	public List<User> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> query = currentSession.createQuery("from User",User.class);
		
		List<User> list = query.getResultList();
		return list;
	}

}
