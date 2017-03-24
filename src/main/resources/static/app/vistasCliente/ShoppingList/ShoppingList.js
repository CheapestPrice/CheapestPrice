'use strict';

angular.module('myApp.shopList', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ShoppingList', {
    templateUrl: 'vistasCliente/ShoppingList/ShoppingList.html',
    controller: 'shopListCtrl'
  });
}])

.controller('shopListCtrl', ['$scope','sellItemSelected','$rootScope','$mdDialog', 'deleteItemSelected', 'favoriteItemList','getUserEmail',function($scope, sellItemSelected, $rootScope,$mdDialog, deleteItemSelected,favoriteItemList,getUserEmail) {
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
    $scope.eliminarItem = function(id,tien){
       deleteItemSelected.delete({correo:$scope.usua.correo,listaNombre:$scope.listado.listaid.nombre,productoId:id,nit:tien.id.nit,x:tien.id.x,y:tien.id.y});
    };
     $scope.comprado = function(id,tien,comp,item){
        console.log(comp);
        comp=!comp
        console.log(comp);
        sellItemSelected.update({correo:$scope.usua.correo,listaNombre:$scope.listado.listaid.nombre,productoId:id,nit:tien.id.nit,x:tien.id.x,y:tien.id.y,comp:comp},item)
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
             scope.$apply(function(favoriteItemList,$rootScope,$scope){
               scope.todo.favorito = !scope.todo.favorito;
               $scope.listado = $rootScope.listaMercado;
               $scope.usua = $rootScope.usuario;
               favoriteItemList.update({correo:$scope.usua.correo,listaNombre:$scope.listado.listaid.nombre,prodcutoId:scope.todo.item.producto.id,nit:scope.todo.item.tienda.id.nit,x:scope.todo.item.tienda.id.x,y:scope.todo.item.tienda.id.y,fav:scope.todo.favorito},scope.todo);
             });
           });
         }
       };
     });