/**
 * 
 */
var app = angular.module('myApp', [ 'ngRoute', 'ngCookies' ]);

console.log('----Starting app.js')
app.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'pages/login.html',
	}).when('/login', {
		templateUrl : 'pages/login.html'
	}).when('/home', {
		templateUrl : 'pages/blog.html'
		
	}).when('/blog1', {
		templateUrl : 'pages/blog1.html'
	})

	.otherwise({
		redirectTo : '/'
	})
});
