'use strict';

var services = angular.module('services', []);

services.factory('factory', ['$http', function($http) {
	var factory = {};

	factory.getjson = function() { return $http.get('http://localhost:8080/dashboard'); }

	return factory;
}]);
