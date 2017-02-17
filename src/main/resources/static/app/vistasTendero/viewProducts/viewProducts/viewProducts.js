'use strict';

angular.module('myApp.viewProducts', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewProducts', {
    templateUrl: 'vistasTendero/viewProducts/viewProducts.html',
    controller: 'ViewProductsCtrl'
  });
}])

.controller('ViewProductsCtrl', ['$scope','placesStubFactory','$rootScope', function($scope,productsStubFactory,$rootScope) {
    //Listado quemado en memoria con el stub
    console.log($rootScope.sede);
    $scope.listado=productsStubFactory.getSede($rootScope.tienda,$rootScope.sede).productos;
    $scope.propertyName = 'nombre';
    $scope.reverse = false;

    $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };
}]);