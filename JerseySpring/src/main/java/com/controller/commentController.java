package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.model.comment.Author;
import com.model.comment.Avatar;
import com.model.comment.Comment;
import com.model.comment.CommentData;
import com.model.comment.Date;
import com.model.comment.Href;
import com.model.comment.Message;
import com.service.CommentService;

// Comment Controller 
@Path("rest/comments")
public class CommentController {

	static Logger log = Logger.getLogger(CommentController.class.getName());

	// Instance for CommentService
	CommentService com = new CommentService();

	// Getting All Comments
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List getAllComments() {

		log.info("Starting Comment Controller Get All Comments");

		List<Comment> list = com.getAllComments();

		List<CommentData> result = new ArrayList<>();

		for (Comment c : list) {
			CommentData comdata = new CommentData();
			comdata.setId(c.getCommentId());
			comdata.setCreated_by_current_user(c.isCreated_by_current_user());
			comdata.setCreated_by_admin(c.isCreated_by_admin());
			comdata.setUser_has_upvoted(c.isUser_has_upvote());

			comdata.setSelf(new Href("/rest/comment/" + c.getCommentId()));

			Author author = new Author();
			author.setFullname(c.getFullName());
			author.setSelf(new Href("/profile/" + c.getFullName() + "/" + c.getCreator()));
			author.setCreator(c.getCreator());
			comdata.setAuthor(author);

			Message message = new Message();
			message.setContent(c.getContent());
			message.setPings(c.getPings());
			message.setUpvote_count(c.getUpvote_count());

			Date date = new Date();
			date.setCreated(c.getCreated());
			date.setModified(c.getModified());
			message.setDate(date);
			comdata.setMessage(message);

			comdata.setParent(c.getParent());

			Avatar avatar = new Avatar();
			avatar.setProfile_picture_url(c.getProfile_picture_url());
			avatar.setSelf(new Href("/image/" + c.getFullName() + "/" + c.getCommentId()));
			comdata.setAvatar(avatar);

			result.add(comdata);
		}

		return result;
	}

	// Getting Comment By Id
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("comment/{commentId}")
	public CommentData getCommentById(@PathParam(value = "commentId") Integer commentId) {

		log.info("Starting Comment Controller Get Comment By Id");

		Comment comment = com.getCommentById(commentId);

		CommentData comdata = new CommentData();
		comdata.setId(comment.getCommentId());
		comdata.setCreated_by_current_user(comment.isCreated_by_current_user());
		comdata.setCreated_by_admin(comment.isCreated_by_admin());
		comdata.setUser_has_upvoted(comment.isUser_has_upvote());

		comdata.setSelf(new Href("/rest/comment/" + comment.getCommentId()));

		Author author = new Author();
		author.setFullname(comment.getFullName());
		author.setSelf(new Href("/profile/" + comment.getFullName() + "/" + comment.getCreator()));
		author.setCreator(comment.getCreator());
		comdata.setAuthor(author);

		Message message = new Message();
		message.setContent(comment.getContent());
		message.setPings(comment.getPings());
		message.setUpvote_count(comment.getUpvote_count());

		Date date = new Date();
		date.setCreated(comment.getCreated());
		date.setModified(comment.getModified());
		message.setDate(date);
		comdata.setMessage(message);

		comdata.setParent(comment.getParent());

		Avatar avatar = new Avatar();
		avatar.setProfile_picture_url(comment.getProfile_picture_url());
		avatar.setSelf(new Href(comment.getFullName() + "/images/" + comment.getCreator()));
		comdata.setAvatar(avatar);

		return comdata;
	}
}
