/**
 * 
 */

app.factory('appService', function($http) {
	console.log('-----starting appService.js')

	var BASE_URL = "http://localhost:8080/CommentJersey/webApi/"

	var appService = this;

	appService.authenticate = function(app) {
		console.log('entering authentication in services Application :' + app)
		return $http.post(BASE_URL + "apps/validation", app).then(
				function(response) {
					console.log('Status :' + response.status)
					return response.data;
				}, null);
	},

	appService.createApp = function(app) {
		console.log('entering create app in service' + app)
		return $http.post(BASE_URL + "apps/create", app).then(
				function(response) {
					console.log('creating application')
					console.log('Status :' + response.status)
					return response.data
				}, function(errResponse) {

					console.log('Error while creating application')
					return errResponse
				});
	}

	appService.getUserByPost = function(apiKey, postId) {
		return $http.get(
				BASE_URL + "comments/" + apiKey + "/" + postId + "/comments")
				.then(function(response) {
					console.log('Data: ' + response.data);
					return response.data;
				}, function(error) {
					console.error('Error while get user by post')
					return error.data;
				});
	},

	appService.fetchAllUsers = function() {

		console.log('----entering getAllUsers')
		return $http.get(BASE_URL + 'users').then(function(response) {
			console.log('Status : ' + response.status);
			return response.data
		}, function(response) {
			console.log('Error : ' + response.data)
			return response.data
		});
	};

	return appService;
});