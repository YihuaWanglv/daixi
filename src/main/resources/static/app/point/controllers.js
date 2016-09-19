(function(angular) {
  

  var UserPointController = function($scope, UserPoint, $location) {
    $scope.location = $location;
    $scope.pid = ($location.search()).pid;

    UserPoint.get({pid: $scope.pid}, function(response) {
      $scope.point = response ? response : [];
    });
    $scope.answer = function(point) {
      console.log(point);
      point.$update(function(point) {
        console.log(point);
      });
    };
    $scope.edit = true;
    $scope.changeButtonFlag = function(point) {
      $scope.edit = (!$scope.edit);
    }
  };
  
  UserPointController.$inject = ['$scope', 'UserPoint', '$location'];

  angular.module("point.controllers").controller("UserPointController", UserPointController);
}(angular));