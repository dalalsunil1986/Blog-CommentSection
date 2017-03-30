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

import com.dao.UserDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.User;

@RestController
public class UserController {

	static Logger log = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public ResponseEntity<String> getAllComments() throws JsonProcessingException {
		log.info("Calling Get All Users in Controller");
		List<User> users = userDao.getAllUsers();

		String jsonUser = JSONObject.valueToString(users);

		return new ResponseEntity<String>(jsonUser, HttpStatus.OK);

	}
}
