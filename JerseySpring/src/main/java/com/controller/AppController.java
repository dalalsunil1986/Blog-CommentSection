package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import com.model.user.Application;
import com.service.AppService;

@Path("/apps")
public class AppController {

	static Logger log = Logger.getLogger(AppController.class.getName());

	AppService appService = new AppService();

	@GET
	@Produces("application/json")
	public List getAllApps() {
		log.info("Starting Application Controller Get All Users");
		List<Application> appList = appService.getAllApplication();
		return appList;
	}

	@GET
	@Produces("application/json")
	@Path("getapp/{appName}")
	public Application getAppByName(@PathParam(value = "appName") String appName) {
		log.info("Starting User Controller Get User By appName");
		Application app = appService.getApplicationById(appName);
		return app;
	}

	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addUser(Application app) {
		//creating random AlphaNumeric for APIkey
		String uniqueId = RandomStringUtils.randomAlphanumeric(5).toUpperCase();
		app.setUniqueId(uniqueId);
		appService.addApplication(app);
		return Response.ok().entity(app).build();
	}

	// deleting the applcation by apikey
	@DELETE
	@Path("/delete/{apiKey}")
	@Consumes("application/json")
	public Response deleteUser(@PathParam("apiKey") String apiKey) {
		appService.deleteApplication(apiKey);
		return Response.ok().build();
	}

	@POST
	@Path("/validate")
	@Consumes("application/json")
	@Produces("application/json")
	public Response validateApp(Application app, HttpSession session) {

		app = appService.validateApp(app);

		if (app == null) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		} else {
			appService.validateApp(app);
			// stored the apikey in session to use it in comment section
			session.setAttribute("LoggedAppKey", app.getUniqueId());
			return Response.status(Response.Status.ACCEPTED).entity(app).build();
		}

	}

}
