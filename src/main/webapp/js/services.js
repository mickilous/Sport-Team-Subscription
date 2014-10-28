'use strict';

var services = angular.module('services', []);

services.factory('factory', ['$http', function($http) {
	var factory = {};

	factory.getdashboard = function() { return $http.get('http://localhost:8080/dashboard'); }
	factory.getteamnumbers = function(members) { return $http.get('http://localhost:8080/numbers?pilots=' + members); }

	return factory;
}]);
