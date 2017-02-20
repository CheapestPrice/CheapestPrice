'use strict';

angular.module('myApp.shopList', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ShoppingList', {
    templateUrl: 'vistasCliente/ShoppingList/ShoppingList.html',
    controller: 'shopListCtrl'
  });
}])

.controller('shopListCtrl', ['$scope','itemsStubFactory','$rootScope', function($scope, itemsStubFactory, $rootScope) {
    $scope.data = {
        cb1: true
      };
    //Listado quemado en memoria con el stub
    $scope.listado=itemsStubFactory.getItems();
    $scope.propertyName = 'nombre';
    $scope.reverse = false;

    $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };
    $scope.eliminar = function(iden, tien){
        itemsStubFactory.eliminate(iden, tien);
    };
    $scope.comprado = function(iden, tien, fav){
        itemsStubFactory.sale(iden, tien, fav);
    };
}])
 .directive('buttonFavorite', function() {
       return {
         scope: true,
         restrict: 'E',
         template: '<button class="btn btn-icon"><span class="glyphicon glyphicon-heart" ng-class="{active: todo.favorito}"></span></button>',
         link: function(scope, elem) {
           elem.bind('click', function() {
             scope.$apply(function(){
               scope.todo.favorito = !scope.todo.favorito;
             });
           });
         }
       };
     });