package com.controller;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dao.ActivityDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.Activity;

@RestController
public class ActivityController {

	static Logger log = Logger.getLogger(ActivityController.class.getName());

	@RequestMapping(value = "/getAllActivity", method = RequestMethod.GET)
	public ResponseEntity<Activity> getAllComments(UriComponentsBuilder build) throws JsonProcessingException {
		log.info("Calling Get All Activity in Controller");
		ActivityDAO act = new ActivityDAO();

		Activity actUser = act.getUserActivity();
		// Converting List of comments into JSON String
		// String jsonComment = JSONObject.valueToString(act.getUserActivity());
		// returning JSON object with HTTPStatus.
		return new ResponseEntity<Activity>(actUser, HttpStatus.OK);

	}
}
