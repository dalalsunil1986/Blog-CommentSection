/**
 * Created by MOAB on 3/27/2017.
 */

var BASE_URL = 'http://localhost:8091/CommentRESTService/';

var commentsArray;

$.getJSON(BASE_URL + "getAllComments", function(json) {
	commentsArray = json;
});

var usersArray;

$.getJSON(BASE_URL + "getAllUsers", function(json) {
	usersArray = json;
});

/*
 * Example Pattern for commentArray and UserArray var commentsArray = [ { "id" :
 * 1, "parent" : null, "created" : "2015-01-01", "modified" : "2015-01-01",
 * "content" : "Software AG’s latest product releases feature exciting
 * innovations to accelerate your Digital Transformation. Learn more about these
 * updates.", "pings" : [], "creator" : 6, "fullname" : "Raj Kumar",
 * "profile_picture_url" : "img/common/commentAvatar.png", "created_by_admin" :
 * false, "created_by_current_user" : false, "upvote_count" : 3,
 * "user_has_upvoted" : false } ]; var usersArray = [ { id : 1, fullname :
 * "Current User", email : "current.user@gmail.com", profile_picture_url :
 * "img/common/commentAvatar.png" } ];
 */