'use strict';

angular.module('myApp.vistaRegistro', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/vistaRegistro', {
    templateUrl: 'vistaRegistro/vistaRegistro.html',
    controller: 'vistaRegistro'
  });
}])

.controller('vistaRegistro', ['$scope', '$location', function($scope,$location) {
    $scope.nextRegistroC=function(){
            $location.path("/registro");
    }

    $scope.nextRegistroT=function(){
                $location.path("/registroTienda");
        }

}]);