package com.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CommentDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Comment;

@RestController
public class CommentController {

	static Logger log = Logger.getLogger(CommentController.class.getName());

	@Autowired
	private CommentDao commentDao;

	@RequestMapping(value = "/getAllComments", method = RequestMethod.GET)
	public ResponseEntity<String> getAllComments() throws JsonProcessingException {
		log.info("Calling Get All Comments in Controller");
		List<Comment> comments = commentDao.getAllComments();
		
		
		String jsonComment = JSONObject.valueToString(comments);

		return new ResponseEntity<String>(jsonComment, HttpStatus.OK);

	}
}	
