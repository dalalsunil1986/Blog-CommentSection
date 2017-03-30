package com.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dao.CommentDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Comment;

@RestController
public class CommentController {

	static Logger log = Logger.getLogger(CommentController.class.getName());

	@Autowired
	private CommentDao commentDao;

	@RequestMapping(value = "/getAllComments", method = RequestMethod.GET)
	public ResponseEntity<String> getAllComments(UriComponentsBuilder build) throws JsonProcessingException {
		log.info("Calling Get All Comments in Controller");
		List<Comment> comments = commentDao.getAllComments();

		String path = build.path("/comments/").build().toString();

		for (Comment c : comments) {
			c.setLinks(c.addCommentLink(path.concat(c.getId().toString()), "Self"));
		}
		// Converting List of comments into JSON String
		String jsonComment = JSONObject.valueToString(comments);
		// returning JSON object with HTTPStatus.
		return new ResponseEntity<String>(jsonComment, HttpStatus.OK);

	}

	@RequestMapping(value = "/comment/getComment/{commentId}", method = RequestMethod.GET)
	public ResponseEntity<Comment> getUserById(@PathVariable("commentId") Integer commentId,
			UriComponentsBuilder build) {
		Comment comment = commentDao.getCommentById(commentId);
		String path = build.path("/comments/").build().toString();
		comment.setLinks(comment.addCommentLink(path.concat(comment.getId().toString()), "Self"));
		
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}
}
