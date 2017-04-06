/**
 * Created by MOAB on 3/27/2017.
 */

// Base URI for RESTService
var BASE_URL = 'http://localhost:8080/JerseySpring/webApi/';

// Get Comments
var commentsArray;

$.getJSON(BASE_URL + "rest/comments", function(json) {
	commentsArray = json;
});

// Get Users
var usersArray;

$.getJSON(BASE_URL + "rest/users", function(json) {
	usersArray = json;
});
