package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {

	static Logger log = Logger.getLogger(CommentDaoImpl.class.getName());
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public List<Comment> getAllComments() {
		Session session = sessionFactory.openSession();
		List<Comment> comments = session.createQuery("from Comment").list();
		log.info("Ending Comment method in DaoImpl");
		return comments;
	}
}
