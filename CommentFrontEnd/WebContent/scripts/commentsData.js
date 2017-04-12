/**
 * Created by MOAB on 3/27/2017.
 */

// Base URI for RESTService
var BASE_URL = 'http://localhost:8080/CommentJersey/webApi';
var dom_el = document.querySelector('[data-ng-controller="appController"]');
var ng_el = angular.element(dom_el);
var ng_el_scope = ng_el.scope();

console.log("************************" + ng_el_scope.commentsArray);

var commentsArray = ng_el_scope.commentsArray;
var usersArray = ng_el_scope.usersArray;