'use strict';

angular.module('myApp.vistaPrincipal', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/vistaPrincipal', {
    templateUrl: 'vistaPrincipal/vistaPrincipal.html',
    controller: 'vistaPrincipalCtrl'
  });
}])

.controller('vistaPrincipalCtrl', ['$scope', '$location', function($scope,$location) {
    $scope.nextLogin=function(){
            $location.path("/login");
    }

    $scope.nextRegistro=function(){
                $location.path("/registro");
        }

}]);