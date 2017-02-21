'use strict';

angular.module('myApp.shopList', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ShoppingList', {
    templateUrl: 'vistasCliente/ShoppingList/ShoppingList.html',
    controller: 'shopListCtrl'
  });
}])

.controller('shopListCtrl', ['$scope','listasMercadoStubFactory','$rootScope', function($scope, listasMercadoStubFactory, $rootScope) {
    $scope.listado = $rootScope.listaMercado;
    $scope.propertyName = 'producto.nombre';
    $scope.reverse = true;

    $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };
    $scope.eliminar = function(iden, tien){
        listasMercadoStubFactory.eliminarItem(iden, tien, $rootScope.listaMercado.nombre);
    };
    $scope.comprado = function(iden, tien){
        listasMercadoStubFactory.comprarItem(iden, tien, $rootScope.listaMercado.nombre);
    };

    $scope.agregarItem = function(){
                 listasMercadoStubFactory.agregarProducto($rootScope.itemSeleccionado, $rootScope.listaSeleccionada);
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