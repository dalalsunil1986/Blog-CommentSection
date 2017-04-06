package com.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.user.User;

public class UserService {

	static Logger log = Logger.getLogger(UserService.class.getName());

	Configuration config = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory sessionfactory = config.buildSessionFactory();

	public List<User> getAllUsers() {
		Session session = sessionfactory.openSession();
		log.info("Starting getAllUsers");
		List<User> list = session.createQuery("from User").list();
		return list;
	}

	public User getUserById(Integer userId) {
		log.info("Starting get User By Id" + userId);

		Session session = sessionfactory.openSession();
		User user = session.get(User.class, userId);
		session.close();
		return user;

	}
}
