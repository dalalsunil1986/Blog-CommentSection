var app = angular.module('myApp', []);
 app.controller('myCtrl', function($scope) {

    var str = '[{"user" : "Administrator System", "body" : "Hello Ismail", "reply" : [{"user" : "Admin", "body": "Hello Ismail", "time" : "12h"},{"user" : "Student", "body": "Hello Admin", "time": "10h"}], "time" : "2h"},{"user" : "Student", "body" : "Hello Admin","reply" : [{"user" : "Admin", "body": "Hello Ismail", "time" : "2h"}], "time" : "1h"},{"user" : "Employee", "body" : "Hello everyone", "time" : "12min"}]';

    $scope.messages = JSON.parse(str);
 });