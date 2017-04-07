package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import com.model.comment.Comment;
import com.model.user.Application;

public class CommentService {

	static Logger log = Logger.getLogger(CommentService.class.getName());

	// Getting all comments list
	@Transactional
	public List<Comment> getAllComments() {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Comment");
		List<Comment> comments = query.list();
		session.close();
		return comments;
	}

	// Getting comment by Id
	@Transactional
	public Comment getCommentById(Integer commentId) {
		log.info("Starting get Comment By Id" + commentId);

		Session session = SessionUtil.getSession();
		Comment comment = session.get(Comment.class, commentId);
		session.close();
		return comment;

	}

	// Getting all commentsList filtered by uniqueId
	@Transactional
	public List<Comment> getApplications(String uniqueId) {
		log.info("Starting get Comment By uniqueId" + uniqueId);
		Session session = SessionUtil.getSession();
		String hql = "from Comment where uniqueId='" + uniqueId + "'";
		log.error("from Comment where uniqueId='" + uniqueId + "'");
		Query query = session.createQuery(hql);
		return (List<Comment>) query.list();

	}

}
