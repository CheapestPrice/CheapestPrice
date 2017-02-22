'use strict';

angular.module('myApp.listasMercado', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/ListasMercado', {
    templateUrl: 'vistasCliente/ShoppingList/ListasMercado.html',
    controller: 'listasMercadoCtrl'
  });
}])

.controller('listasMercadoCtrl', ['$scope','listasMercadoStubFactory','$rootScope', '$location', 'getUserNickname', 'updateUser', function($scope, listasMercadoStubFactory, $rootScope, $location,getUserNickname, updateUser) {
    listasMercadoStubFactory.listaCompleta();
    //$scope.listMerc = getUserNickname.get({nickname:'nickname1'});
    console.log($scope.listMerc);
    //$rootScope.usuario = getUserNickname.get({nickname:'nickname1'});
    $scope.listMerc = listasMercadoStubFactory.getListaMercado();
    $rootScope.listaMercado = ""

    $scope.eliminar = function(nom){
        listasMercadoStubFactory.eliminate(nom);
        /*for(var i=0;i<$scope.listMerc.listas.length;i++){
             if($scope.listMerc.listas[i].nombre == nom){
                 $scope.listMerc.listas.splice(i,1);
                    break
             }

        }
        updateUser.update({nickname:'nickname1'},$scope.listMerc);*/
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