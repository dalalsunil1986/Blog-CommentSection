package com.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model1.Comment;

public class CommentService {

	Configuration config = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory sessionfactory = config.buildSessionFactory();

	public List<Comment> getAllComments() {
		Session session = sessionfactory.openSession();
		System.out.println("Starting getAllTest");
		List<Comment> list = session.createQuery("from Comment").list();
		return list;
	}
}
