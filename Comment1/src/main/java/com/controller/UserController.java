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

import com.dao.UserDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Comment;
import com.model.User;

@RestController
public class UserController {

	static Logger log = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<String> getAllComments(UriComponentsBuilder build) throws JsonProcessingException {
		log.info("Calling Get All Users in Controller");
		List<User> users = userDao.getAllUsers();
		String path = build.path("/users/").build().toString();

		for (User us : users) {
			us.setLinks(us.addUserLink(path.concat(us.getId().toString()), "Self"));
		}

		// Converting list of users into JSON String
		String jsonUser = JSONObject.valueToString(users);

		return new ResponseEntity<String>(jsonUser, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/getUser/{userId}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId, UriComponentsBuilder build) {
		User user = userDao.getUserById(userId);
		String path = build.path("/users/").build().toString();
		user.setLinks(user.addUserLink(path.concat(user.getId().toString()), "Self"));

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
