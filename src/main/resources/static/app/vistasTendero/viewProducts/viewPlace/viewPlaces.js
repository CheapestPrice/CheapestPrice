'use strict';

angular.module('myApp.viewPlaces', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewPlaces', {
    templateUrl: 'vistasTendero/viewPlace/viewPlaces.html',
    controller: 'ViewPlacesCtrl'
  });
}])

.controller('ViewPlacesCtrl', ['$scope','placesStubFactory','$rootScope','$location', function($scope,placesStubFactory,$rootScope,$location) {
    $rootScope.sede="";
    $rootScope.tienda="Surtir";
    //Listado quemado en memoria con el stub
    $scope.sedes=placesStubFactory.getSedes($rootScope.tienda);
    $scope.next=function(place){
        $rootScope.sede=place;
        $location.path("/viewProducts");
    }
}]);