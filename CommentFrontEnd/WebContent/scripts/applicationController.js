/**
 * 
 */
app
		.controller(
				'appController',
				function($scope, $http, appService, $rootScope, $location,
						$cookieStore, $route, $window) {

					console.log('starting app Controller')

					$scope.application = {
						id : '',
						uniqueId : '',
						orgName : '',
						password : '',
						errorCode : '',
						errorMessage : ''
					};

					$scope.usersArray = {
						errorCode : '',
						errorMessage : '',
						id : '',
						fullName : '',
						email : '',
						profile_picture_url : ''
					};
					
					$scope.commentsArray = {
						commentId : '',
						created_by_current_user : '',
						created_by_admin : '',
						user_has_upvote : '',
						creator : '',
						fullName : '',
						content : '',
						created : '',
						modified : '',
						upvote_count : '',
						profile_picture_url : '',
						pings : '',
						parent : '',
						uniqueId : '',
						postId : ''
					};

					$scope.user = '';

					$scope.authenticate = function(application) {
						console.log('enering authenticate in controller')
						appService
								.authenticate(application)
								.then(
										function(d) {
											$scope.application = d;
											console
													.log('applicationErrorCode'
															+ $scope.application.errorCode)
											if ($scope.application.errorCode == '404') {
												$scope.application.errorMessage = "Invalid Credentials";
												$scope.application.orgName = '';
												$scope.application.password = '';
											} else {
												console
														.log('Valid credentials. Navigating to home')
												$rootScope.currentApp = $scope.application
												$http.defaults.headers.common['Authorization'] = 'Basic'
														+ $rootScope.currentApp;
												$cookieStore.put('currentApp',
														$rootScope.currentApp);
												$scope.user = $cookieStore
														.get('currentApp');
												$scope.api = $scope.user.uniqueId;

												$location.path("/home");

											}
										},
										function(errResponse) {
											console
													.error('Error while authenticating User')
											$scope.application.errorMessage = "Invalid Credentials please check your Id or password";
											$scope.application.orgName = '';
											$scope.application.password = '';
										});
					};

					$scope.login = function() {

						{
							console
									.log('login validation ',
											$scope.application)
							$scope.authenticate($scope.application);
						}
					};

					$scope.createApp = function(app) {
						console.log('entering create app in controller')
						appService
								.createApp(app)
								.then(
										function(response) {
											console
													.log('registered Successfully'
															+ response.status)
											$scope.application = {};
											$scope.application.errorMessage = "Registered Successfully";
										},
										function(error) {
											consol
													.error('Error while creating application')
											$scope.application = {};
											$scope.application.errorMessage = "Error while creating application please try again";
										});
					};

					$scope.submit = function() {
						{
							console.log('Saving New application',
									$scope.application);
							$scope.createApp($scope.application);
						}

					};

					$scope.getByPost = function(postId) {
						location.reload();
						console.log('getpost')
						$scope.user = $cookieStore.get('currentApp');
						$scope.api = $scope.user.uniqueId;
						console.log($scope.user.uniqueId);
						$scope.getUsers();
						appService.getUserByPost($scope.user.uniqueId, postId)
								.then(function(data) {
									$scope.commentsArray = data;
									console.log("Comments" + data)
								}, function(error) {
									console.error('Error: ' + error.status);
									return error
								});
					};

					$scope.getUsers = function() {
						console.log('getpost')
						appService.fetchAllUsers().then(function(data) {
							console.log("Users" + data)
							$scope.usersArray = data;
						}, function(error) {
							console.log('Error ' + error)
						})
					};

					$scope.logout = function() {
						$cookieStore.remove('currentApp');
						$location.path("/login");
						location.reload();
					}

				});
