
'use strict';

angular.module('myApp.listasMercado', ['ngRoute'])

.config(['$routeProvider','$qProvider', function($routeProvider,$qProvider) {
  $routeProvider.when('/ListasMercado', {
    templateUrl: 'vistasCliente/ShoppingList/ListasMercado.html',
    controller: 'listasMercadoCtrl'
  });
  $qProvider.errorOnUnhandledRejections(false);
}])

.controller('listasMercadoCtrl', ['$scope','listasMercadoStubFactory','$rootScope', '$location', 'getUserEmail', 'updateUser', 'deleteShoppingList', 'saveShoppingList', function($scope, listasMercadoStubFactory, $rootScope, $location,getUserEmail, updateUser, deleteShoppingList, saveShoppingList) {
    //listasMercadoStubFactory.listaCompleta();
    $scope.usuario1 = getUserEmail.get({correo:'prueba@prueba.com'});
    //$scope.eliminar = function(nom){
        //listasMercadoStubFactory.eliminate(nom);
    //}
    $scope.eliminarLista=function(listaNombre){
        deleteShoppingList.delete({correo:$scope.usuario1.correo,nombreLista:listaNombre})
        $scope.usuario1 = getUserEmail.get({correo:'prueba@prueba.com'});
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
    $scope.AddLista = new ListaDeMercado();
    $scope.AddListaId = new ListaMercado_Item();

    $scope.nombreLista=""
    $scope.agregarLista = function(){
        $scope.AddListaId.nombre = $scope.nombreLista;
        $scope.AddListaId.usuario = $scope.usuario1.correo;
        $scope.AddLista.listaid = $scope.AddListaId;
        $scope.AddLista.revision = false;
        $scope.AddLista.fechaCreacion = new Date();
        $scope.AddLista.usuario = $scope.usuario1;
        saveShoppingList.save($scope.AddLista);
    };

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
    /*if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function (position) {
          //console.log(position);
          $rootScope.x = position.coords.latitude;
          $rootScope.y = position.coords.longitude;
          //console.log($rootScope.x+" "+$rootScope.y);
      })
      //console.log("navigator.geolocation");
    }else{
      //console.log("no navigator.geolocation");
    }*/

}]);

