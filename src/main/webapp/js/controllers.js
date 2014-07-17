'use strict';

var controllers = angular.module('controllers', []);

controllers.controller('dashboardCtrl', ['$scope', 'factory', function($scope, factory) {
  factory.getjson()
    .success(function (dashboard) {
      $scope.dashboard = dashboard;
      console.log(dashboard);
    })
    .error(function (error) {
      $scope.status = 'Unable to load customer data: ' + error.message;
      console.log(error);
    });
}]);