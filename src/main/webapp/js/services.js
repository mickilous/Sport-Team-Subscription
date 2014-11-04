'use strict';

var services = angular.module('services', []);

services.factory('factory', ['$http', function($http) {
	var factory = {};

	factory.getdashboard = function() { return $http.get('http://localhost:8080/dashboard'); }
	factory.getteamnumbers = function(members) { return $http.get('http://localhost:8080/numbers?pilots=' + members); }

	factory.createteam = function(data) { return $http.post('http://localhost:8080/createTeam', data); }

	return factory;
}]);
