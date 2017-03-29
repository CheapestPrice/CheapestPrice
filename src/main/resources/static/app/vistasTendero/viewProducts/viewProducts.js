'use strict';

angular.module('myApp.viewProducts', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewProducts', {
    templateUrl: 'vistasTendero/viewProducts/viewProducts.html',
    controller: 'ViewProductsCtrl'
  });
}])

.controller('ViewProductsCtrl', ['$scope','itemsByShop','$rootScope', function($scope,itemsByShop,$rootScope) {
    //Listado quemado en memoria con el stub
    $rootScope.tienda="Surtir";
    $scope.listado=itemsByShop.query({shopName:"Donde Pepe"})
    $scope.propertyName = 'producto.nombre';
    $scope.reverse = false;


    $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };
}]);