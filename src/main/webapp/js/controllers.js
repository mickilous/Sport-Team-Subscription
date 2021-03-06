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

	$scope.getteamnumbers = function(number) {
	factory.getteamnumbers(number)
		.success(function (teamnumbers) {
			var panelnumber = Math.ceil(teamnumbers.length / 9);
			var total = teamnumbers.length;
			var count = 0;
			var panels = [];
			console.log(panelnumber);
			for (var i = 0; i < panelnumber ; i++) {
				panels[i] = [];
				for (var j = 0; j < 9; j++) {
					if (count < total)
						panels[i].push(teamnumbers[count++]);
				};
			};
			$scope.panels = panels;
			console.log(panels);
		})
		.error(function (error) {
			console.log(error);
		});
	};

	$scope.submitData = function() {
	var data = {
		"name" : "My Te4m",
		"number" : 42,
		"pilots" : 3,
		"lookingForPilots" : false
	};

	factory.createteam(data)
		.success(function (myteam) {
			$scope.dashboard.team = new Object(myteam);
			console.log(myteam);
		})
		.error(function (error) {
			console.log(error);
		});
	};

}]);
