'use strict';

angular.module('myApp.shopList', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ShoppingList', {
    templateUrl: 'vistasCliente/ShoppingList/ShoppingList.html',
    controller: 'shopListCtrl'
  });
}])

.controller('shopListCtrl', ['$scope','listasMercadoStubFactory','$rootScope','$mdDialog', 'updateUser', function($scope, listasMercadoStubFactory, $rootScope,$mdDialog, updateUser) {
    $scope.listado = $rootScope.listaMercado;
    $scope.usua = $rootScope.usuario;
    $scope.propertyName = 'producto.nombre';
    $scope.customFullscreen = false;
    $scope.reverse = true;
    $scope.producto=null;

    $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };
    //$scope.eliminar = function(iden, tien){
        //listasMercadoStubFactory.eliminarItem(iden, tien, $rootScope.listaMercado.nombre);
    //};
    $scope.eliminarItem = function(id,tien){
        var ban = false
        for(var i=0;i<$scope.usua.listas.length;i++){
            if($scope.usua.listas[i].listaid.nombre == $scope.listado.listaid.nombre){
                for(var j=0; j<$scope.usua.listas[i].length;j++){
                    if($scope.usua.listas[i].items[j].item.producto.id == iden && $scope.usua.listas[i].items[j].item.tienda.nombre == tien){
                        $scope.usua.listas[i].items.splice(j,1);
                        ban = true
                        break
                    }
                }
                if(ban){
                    break
                }
            }
        }
        updateUser.update({correo:$scope.usua.correo},$scope.usua);
    };
    //$scope.comprado = function(iden, tien){
        //listasMercadoStubFactory.comprarItem(iden, tien, $rootScope.listaMercado.nombre);
     //};
     $scope.comprado = function(iden,tien){
        var ban = false
                for(var i=0;i<$scope.usua.listas.length;i++){
                    if($scope.usua.listas[i].listaid.nombre == $scope.listado.listaid.nombre){
                        for(var j=0; j<$scope.usua.listas[i].length;j++){
                            if($scope.usua.listas[i].items[j].item.producto.id == iden && $scope.usua.listas[i].items[j].item.tienda.nombre == tien){
                                $scope.usua.listas[i].items[j].item.comprado=!$scope.usua.listas[i].items[j].item.comprado;
                                ban = true
                                break
                            }
                        }
                        if(ban){
                            break
                        }
                    }
                }
                updateUser.update({correo:$scope.usua.correo},$scope.usua);
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