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

	// Getting all comments from Comment table
	@Transactional
	public List<Comment> getAllComments() {
		Session session = sessionFactory.openSession();
		// SELECT * from comment
		List<Comment> comments = session.createQuery("from Comment").list();
		log.info("Ending Comment method in DaoImpl");
		return comments;
	}

	@Transactional
	public Comment getCommentById(Integer commentId) {
		Session session = sessionFactory.openSession();
		Comment comment = (Comment) session.get(Comment.class, commentId);
		session.close();
		return comment;
	}

}
