'use strict';

var controllers = angular.module('controllers', []);

controllers.controller('dashboardCtrl', ['$scope', 'factory', function($scope, factory) {
  factory.getdashboard()
    .success(function (dashboard) {
      $scope.dashboard = dashboard;
      console.log(dashboard);
    })
    .error(function (error) {
      $scope.status = 'Unable to load customer data: ' + error.message;
      console.log(error);
    });
}]);

controllers.controller('teamNumbersCtrl', ['$scope', 'factory', function($scope, factory) {
	$scope.getteamnumbers = function(numbers) {
		factory.getteamnumbers(numbers)
			.success(function (teamnumbers) {
				$scope.teamnumbers = teamnumbers;
				console.log(teamnumbers);
			})
			.error(function (error) {
				console.log(error);
			});
	};
}])