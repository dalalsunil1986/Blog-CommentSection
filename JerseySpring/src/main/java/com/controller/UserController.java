package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.model.comment.Avatar;
import com.model.comment.Href;
import com.model.user.Member;
import com.model.user.User;
import com.model.user.UserData;
import com.service.UserService;

//User Controller 
@Path("/users")
public class UserController {

	static Logger log = Logger.getLogger(UserController.class.getName());

	UserService userService = new UserService();

	@GET
	@Produces("application/json")
	public List getAllUsers() {

		log.info("Starting User Controller Get All Users");

		List<User> userList = userService.getAllUsers();
		List<UserData> resultList = new ArrayList<UserData>();

		for (User u : userList) {
			UserData userData = new UserData();
			userData.setId(u.getId());

			Member user = new Member();
			user.setEmail(u.getEmail());
			user.setFullname(u.getFullName());
			user.setSelf(new Href("/rest/user/" + u.getId()));
			userData.setUser(user);

			Avatar avatar = new Avatar();
			avatar.setProfile_picture_url(u.getProfile_picture_url());
			avatar.setSelf(new Href("/image/" + u.getFullName() + "/" + u.getId()));
			userData.setAvatar(avatar);

			resultList.add(userData);
		}

		return userList;
	}

	@GET
	@Produces("application/json")
	@Path("getUser/{userId}")
	public UserData getUserIdById(@PathParam(value = "userId") Integer userId) {

		log.info("Starting User Controller Get User By Id");

		User user = userService.getUserById(userId);
		UserData userData = new UserData();
		if (user == null) {
			userData.setErrorCode("404");
			userData.setErrorMessage("There is No user for this Id: " + userId);
			return userData;
		} else {

			userData.setId(user.getId());

			Member member = new Member();
			member.setEmail(user.getEmail());
			member.setFullname(user.getFullName());
			member.setSelf(new Href("/rest/user/" + user.getId()));
			userData.setUser(member);

			Avatar avatar = new Avatar();
			avatar.setProfile_picture_url(user.getProfile_picture_url());
			avatar.setSelf(new Href("/image/" + user.getFullName() + "/" + user.getId()));
			userData.setAvatar(avatar);

			return userData;
		}

	}

	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addUser(User user) {
		userService.addUser(user);
		return Response.ok().entity(user).build();
	}

	@PUT
	@Path("/update/{userId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateUser(@PathParam(value = "userId") Integer userId, User user) {
		int count = userService.editUser(userId, user);
		if (count == 0) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		return Response.ok().entity(user).build();
	}

	@DELETE
	@Path("/delete/{userId}")
	@Consumes("application/json")
	public Response deleteUser(@PathParam("userId") Integer userId) {
		userService.deleteUser(userId);
		return Response.ok().build();
	}

}
