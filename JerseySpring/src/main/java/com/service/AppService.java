package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.user.Application;

public class AppService {

	static Logger log = Logger.getLogger(AppService.class.getName());

	@Transactional
	public List<Application> getAllApplication() {
		Session session = SessionUtil.getSession();
		log.info("Starting getAllApplication");
		List<Application> list = session.createQuery("from Application").list();
		return list;
	}

	@Transactional
	public Application getApplicationById(String appName) {
		log.info("Starting get Application By Id" + appName);
		Session session = SessionUtil.getSession();
		String hql = "from Application where orgName='" + appName + "'";
		log.error("from Application where orgName='" + appName + "'");
		Query query = session.createQuery(hql);
		return (Application) query.uniqueResult();

	}

	@Transactional
	public int deleteApplication(String id) {
		log.info("Starting delete User by" + id);
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "delete from Application where uniqueId = :id";
		Query query = session.createQuery(hql);
		query.setString("id", id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}

	@Transactional
	public void addApplication(Application app) {
		log.info("adding Application " + app.getOrgName());
		Session session = SessionUtil.getSession();
		Transaction tx = session.beginTransaction();
		session.save(app);
		tx.commit();
		session.close();
	}

	@Transactional
	public Application validateApp(Application app) {

		Session session = SessionUtil.getSession();
		String hql = "from Application where orgName='" + app.getOrgName() + "' and password='" + app.getPassword()
				+ "'";
		Query query = session.createQuery(hql);
		Application validApp = (Application) query.uniqueResult();
		return validApp;

	}
}
