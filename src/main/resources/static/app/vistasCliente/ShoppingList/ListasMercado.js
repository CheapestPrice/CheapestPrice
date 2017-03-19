
'use strict';

angular.module('myApp.listasMercado', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ListasMercado', {
    templateUrl: 'vistasCliente/ShoppingList/ListasMercado.html',
    controller: 'listasMercadoCtrl'
  });
}])

.controller('listasMercadoCtrl', ['$scope','listasMercadoStubFactory','$rootScope', '$location', 'getUserNickname', 'updateUser', function($scope, listasMercadoStubFactory, $rootScope, $location,getUserNickname, updateUser) {
    //listasMercadoStubFactory.listaCompleta();
    //Falta el usuario global, cambiar nickname1
    $rootScope.usuario = getUserEmail.get({correo:'prueba@prueba.com'});
    //$scope.listMerc = listasMercadoStubFactory.getListaMercado();

    //$scope.eliminar = function(nom){
        //listasMercadoStubFactory.eliminate(nom);
    //}
    $scope.eliminarLista = function(listaNombre){
        for(var i=0;i<$rootScope.usuario.listas.length;i++){
             if($scope.listMerc.listas[i].nombre == listaNombre){
                 $scope.listMerc.listas.splice(i,1);
                    break
             }

        }
        //Falta el usuario global
        updateUser.update({correo:$rootScope.usuario.correo},$rootScope.usuario);
    }

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