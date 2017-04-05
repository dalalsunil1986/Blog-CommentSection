package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model1.Author;
import com.model1.Avatar;
import com.model1.Comment;
import com.model1.CommentData;
import com.model1.Creator;
import com.model1.Date;
import com.model1.Href;
import com.model1.Message;
import com.service.CommentService;

@Path("rest")
public class commentController {

	CommentService com = new CommentService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("comments")
	public List getAllComments() {

		List<Comment> list = com.getAllComments();

		List<CommentData> result = new ArrayList<>();

		for (Comment c : list) {
			CommentData comdata = new CommentData();
			comdata.setCommentId(c.getCommentId());
			comdata.setCreated_by_current_user(c.isCreated_by_current_user());
			comdata.setCreated_by_admin(c.isCreated_by_admin());
			comdata.setUser_has_upvote(c.isUser_has_upvote());

			Author author = new Author();
			author.setfullName(c.getFullName());
			author.setSelf(new Href("/profile/" + c.getFullName() + "/" + c.getCreator()));
			comdata.setAuthor(author);

			Message message = new Message();
			message.setContent(c.getContent());
			message.setPings(c.getPings());
			message.setUp_count(c.getUpvote_count());

			Date date = new Date();
			date.setCreated(c.getCreated());
			date.setModified(c.getModified());
			message.setDate(date);
			comdata.setMessage(message);

			Creator creator = new Creator();
			creator.setCreator(c.getCreator());
			creator.setSelf(new Href("/profile/" + c.getFullName() + "/" + c.getCreator()));
			comdata.setCreator(creator);

			comdata.setParent(c.getParent());

			Avatar avatar = new Avatar();
			avatar.setProfile_picture(c.getProfile_picture_url());
			avatar.setSelf(new Href(c.getFullName() + "/images/" + c.getCreator()));
			comdata.setAvatar(avatar);

			result.add(comdata);
		}

		return result;
	}
}
