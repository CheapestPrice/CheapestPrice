'use strict';

angular.module('myApp.shopList', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ShoppingList', {
    templateUrl: 'vistasCliente/ShoppingList/ShoppingList.html',
    controller: 'shopListCtrl'
  });
}])

.controller('shopListCtrl', ['$scope','listasMercadoStubFactory','$rootScope','$mdDialog', function($scope, listasMercadoStubFactory, $rootScope,$mdDialog) {
    $scope.listado = $rootScope.listaMercado;
    $scope.propertyName = 'producto.nombre';
    $scope.customFullscreen = false;
    $scope.reverse = true;
    $scope.producto=null;
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
     $scope.showAdvanced = function(ev,produc) {
            $scope.producto=produc;
            console.log( $scope.producto);
            $mdDialog.show({
              controller: DialogController,
              templateUrl: 'viewItem/viewItem.html',
              parent: angular.element(document.body),
              targetEvent: ev,
              clickOutsideToClose:true,
              scope:$scope,
              preserveScope: true,
              fullscreen: $scope.customFullscreen
            });
      };
          function DialogController($scope, $mdDialog,$rootScope) {
              $scope.hide = function() {
                $mdDialog.hide();
              };

              $scope.cancel = function() {
                $mdDialog.cancel();
              };

          }

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