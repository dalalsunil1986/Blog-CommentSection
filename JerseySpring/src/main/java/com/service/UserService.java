package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.user.User;

public class UserService {

	static Logger log = Logger.getLogger(UserService.class.getName());

	@Transactional
	public List<User> getAllUsers() {
		Session session = SessionUtil.getSession();
		log.info("Starting getAllUsers");
		List<User> list = session.createQuery("from User").list();
		return list;
	}

	@Transactional
	public User getUserById(Integer userId) {
		log.info("Starting get User By Id" + userId);

		Session session = SessionUtil.getSession();
		User user = session.get(User.class, userId);
		session.close();
		return user;

	}

	@Transactional
	public int deleteUser(Integer userId) {
		log.info("Starting delete User by" + userId);
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from User where id = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", userId);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}

	@Transactional
	public void addUser(User user) {
		log.info("adding User " + user.getEmail());
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(user);
		tx.commit();
		session.close();
	}

	@Transactional
	public int editUser(Integer userId, User user) {
		if (userId <= 0)
			return 0;
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "update User set fullName = :fullName, email=:email,profile_picture_url = :profile_picture_url where id = :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", userId);
		query.setString("fullName", user.getFullName());
		query.setString("email", user.getEmail());
		query.setString("profile_picture_url", user.getProfile_picture_url());
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
}
