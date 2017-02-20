'use strict';

angular.module('myApp.viewProducts', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewProducts', {
    templateUrl: 'vistasTendero/viewProducts/viewProducts.html',
    controller: 'ViewProductsCtrl'
  });
}])

.controller('ViewProductsCtrl', ['$scope','items2StubFactory','$rootScope', function($scope,items2StubFactory,$rootScope) {
    //Listado quemado en memoria con el stub
    $rootScope.tienda="Surtir";
    $scope.listado=items2StubFactory.getItemsTienda($rootScope.tienda);
    $scope.propertyName = 'producto.nombre';
    $scope.reverse = false;

    $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };
}]);