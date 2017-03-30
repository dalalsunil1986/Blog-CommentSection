package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	static Logger log = Logger.getLogger(UserDaoImpl.class.getName());

	@Autowired
	private SessionFactory sessionFactory;

	// Getting all users from User table
	public List<User> getAllUsers() {
		log.info("Calling List of Users");
		Session session = sessionFactory.openSession();
		// SELECT * from user
		List<User> users = session.createQuery("from User").list();
		return users;
	}

	@Transactional
	public User getUserById(Integer userId) {
		Session session = sessionFactory.openSession();
		User user = (User) session.get(User.class, userId);
		session.close();
		return user;
	}

}
