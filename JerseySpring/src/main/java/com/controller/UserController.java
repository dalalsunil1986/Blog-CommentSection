package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.model.comment.Avatar;
import com.model.comment.CommentData;
import com.model.comment.Href;
import com.model.user.Member;
import com.model.user.User;
import com.model.user.UserData;
import com.service.UserService;

//User Controller 
@Path("rest/users")
public class UserController {

	static Logger log = Logger.getLogger(UserController.class.getName());

	UserService userService = new UserService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List getAllUsers() {

		log.info("Starting User Controller Get All Users");

		List<User> userList = userService.getAllUsers();
		List<UserData> resultList = new ArrayList<UserData>();

		for (User u : userList) {
			UserData userData = new UserData();
			userData.setId(u.getUserId());

			Member user = new Member();
			user.setEmail(u.getEmail());
			user.setFullname(u.getFullName());
			user.setSelf(new Href("/rest/user/" + u.getUserId()));
			userData.setUser(user);

			Avatar avatar = new Avatar();
			avatar.setProfile_picture_url(u.getProfile_picture_url());
			avatar.setSelf(new Href("/image/" + u.getFullName() + "/" + u.getUserId()));
			userData.setAvatar(avatar);

			resultList.add(userData);
		}

		return resultList;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("user/{userId}")
	public UserData getUserIdById(@PathParam(value = "userId") Integer userId) {

		log.info("Starting User Controller Get User By Id");

		User user = userService.getUserById(userId);

		UserData userData = new UserData();
		userData.setId(user.getUserId());

		Member member = new Member();
		member.setEmail(user.getEmail());
		member.setFullname(user.getFullName());
		member.setSelf(new Href("/rest/user/" + user.getUserId()));
		userData.setUser(member);

		Avatar avatar = new Avatar();
		avatar.setProfile_picture_url(user.getProfile_picture_url());
		avatar.setSelf(new Href("/image/" + user.getFullName() + "/" + user.getUserId()));
		userData.setAvatar(avatar);

		return userData;
	}
}
