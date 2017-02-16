'use strict';

angular.module('myApp.shopList', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ShoppingList', {
    templateUrl: 'ShoppingList/ShoppingList.html',
    controller: 'shopListCtrl'
  });
}])

.controller('shopListCtrl', ['$scope','itemsStubFactory','$rootScope', function($scope, itemsStubFactory, $rootScope) {
    //Listado quemado en memoria con el stub
    $scope.listado=itemsStubFactory.getItems();
    $scope.propertyName = 'nombre';
    $scope.reverse = false;

    $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };
    $scope.eliminar=function(){
                //Hacer funcion
            }


}]);