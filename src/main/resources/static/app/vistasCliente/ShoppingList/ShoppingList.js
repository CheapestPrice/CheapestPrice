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
        comp=!comp
        sellItemSelected.update({correo:$scope.usua.correo,listaNombre:$scope.listado.listaid.nombre,productoId:id,nit:tien.id.nit,x:tien.id.x,y:tien.id.y,comp:comp},item)
    };

    $scope.favorito = function(id,tien,fav,item){
        fav=!fav
        favoriteItemList.update({correo:$scope.usua.correo,listaNombre:$scope.listado.listaid.nombre,productoId:id,nit:tien.id.nit,x:tien.id.x,y:tien.id.y,fav:fav},item)
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

}]);