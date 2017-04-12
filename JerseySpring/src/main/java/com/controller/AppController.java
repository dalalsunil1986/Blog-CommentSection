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
		Application app = appService.getApplicationByName(appName);
		return app;
	}

	@POST
	@Path("/create")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addUser(Application app) {
		// creating random AlphaNumeric for APIkey
		Application oldApp = appService.getApplicationByName(app.getOrgName());

		if (oldApp == null) {
			Application newApp = app;
			String uniqueId = RandomStringUtils.randomAlphanumeric(5).toUpperCase();
			app.setUniqueId(uniqueId);
			appService.addApplication(newApp);
			return Response.ok().entity(newApp).build();
		} else {
			oldApp.setErrorCode("406");
			oldApp.setErrorMessage("Organization Already Exist in this Name. Please choose ");
			return Response.ok().entity(oldApp).build();
		}

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
	@Path("/validation")
	@Consumes("application/json")
	@Produces("application/json")
	public Response validateApp(Application app) {
		log.info("Starting User Controller Validation");
		app = appService.validateApp(app);

		if (app == null) {
			app = new Application();
			app.setErrorCode("401");
			app.setErrorMessage("Invalid Credentials Please Check");
			return Response.status(Response.Status.UNAUTHORIZED).entity(app).build();
		} else {
			// stored the apikey in session to use it in comment section
			return Response.status(Response.Status.ACCEPTED).entity(app).build();
		}

	}

}
