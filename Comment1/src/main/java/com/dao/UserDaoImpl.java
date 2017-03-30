package com.dao;

import java.util.List;

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

	public List<User> getAllUsers() {

		log.info("Calling List of Users");

		Session session = sessionFactory.openSession();
		List<User> users = session.createQuery("from User").list();
		return users;
	}

}
