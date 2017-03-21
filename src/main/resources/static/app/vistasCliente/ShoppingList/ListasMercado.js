
'use strict';

angular.module('myApp.listasMercado', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ListasMercado', {
    templateUrl: 'vistasCliente/ShoppingList/ListasMercado.html',
    controller: 'listasMercadoCtrl'
  });
}])

.controller('listasMercadoCtrl', ['$scope','listasMercadoStubFactory','$rootScope', '$location', 'getUserEmail', 'updateUser', 'deleteShoppingList', function($scope, listasMercadoStubFactory, $rootScope, $location,getUserEmail, updateUser, deleteShoppingList) {
    //listasMercadoStubFactory.listaCompleta();
    $scope.usuario1 = getUserEmail.get({correo:'admin@cheapestprice.com'});
    //$scope.eliminar = function(nom){
        //listasMercadoStubFactory.eliminate(nom);
    //}
    $scope.eliminarLista=function(listaNombre){
        deleteShoppingList.delete({correo:$scope.usuario1.correo,nombreLista:listaNombre})
        $scope.usuario1 = getUserEmail.get({correo:'admin@cheapestprice.com'});
     };
     /*function(listaNombre){
        for(var i=0;i<$scope.usuario1.listas.length;i++){
             if($scope.usuario1.listas[i].listaid.nombre == listaNombre){
                 $scope.usuario1.listas.splice(i,1);
                    break
             }

        }*/
        //Falta el usuario global
        $rootScope.usuario=$scope.usuario1;



    $scope.propertyName = 'nombre';
    $scope.reverse = true;

    $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };

    $scope.completo = function(ban){
        var com='No'
        if(ban){
            com='Si'
        }
       return com
    }

    $scope.ver=function(items){
           $rootScope.listaMercado=items;
           $location.path("/ShoppingList");
       }


}]);