package com.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Elements;
import com.model.Test;

public class commentService2 {

	Configuration config = new Configuration().configure("hibernate.cfg.xml");
	SessionFactory sessionfactory = config.buildSessionFactory();

	public List<Test> getAllTest() {
		Session session = sessionfactory.openSession();
		System.out.println("Starting getAllTest");
		List<Test> list = session.createQuery("from Test").list();
		return list;
	}

	public List<Elements> getAllElements() {
		Session session = sessionfactory.openSession();
		System.out.println("Starting Elements");
		List<Elements> elements = session.createQuery("from Elements").list();
		return elements;
	}
}
