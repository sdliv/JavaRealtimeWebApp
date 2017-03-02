/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var realTime = angular.module("realtime",[]);

realTime.controller("RealtimeCtrl", function($scope, $http, $timeout) {
    $scope.tasks = [];
    
    $scope.addTask = function() {
        $http.post("api/task", $scope.task);
    }
    
    $scope.getTasks = function() {
        $http.get("api/task")
                .success(function(data) {
                    $scope.tasks = data;
        });
    }
    
    $scope.activeRealtime = function() {
        $scope.getTasks();
        $timeout($scope.activateRealtime, 1000);
    }
});
