'use strict';

angular.module('myApp.viewSearch', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewSearch', {
    templateUrl: 'viewSearchItem/viewSearch.html',
    controller: 'ViewSearchCtrl'
  });
}])

.controller('ViewSearchCtrl', ['$scope','placesStubFactory','$rootScope', function($scope,placesStubFactory,$rootScope) {
    $scope.products= placesStubFactory.getListado()[0].sedes[0].productos;
    console.log(placesStubFactory.getListado()[0].sedes[0].productos)
}]);