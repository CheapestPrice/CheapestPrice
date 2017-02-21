'use strict';

angular.module('myApp.listasMercado', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ListasMercado', {
    templateUrl: 'vistasCliente/ShoppingList/ListasMercado.html',
    controller: 'listasMercadoCtrl'
  });
}])

.controller('listasMercadoCtrl', ['$scope','listasMercadoStubFactory','$rootScope', '$location', function($scope, listasMercadoStubFactory, $rootScope, $location) {
    $scope.listMerc = listasMercadoStubFactory.getListaMercado();
    $rootScope.listaMercado = ""

    $scope.eliminar = function(nom){
        listasMercadoStubFactory.eliminate(nom);
    }

    $scope.propertyName = 'nombre';
    $scope.reverse = true;

    $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };

    $scope.ver=function(items){
           $rootScope.listaMercado=items;
           $location.path("/ShoppingList");
       }
}]);