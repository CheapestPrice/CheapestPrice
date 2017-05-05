'use strict';

angular.module('myApp.registroTienda', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registroTienda', {
    templateUrl: 'registroTienda/registroTienda.html',
    controller: 'registroTienda'
  });
}])

.controller('registroTienda', ['$scope', 'registroT', function ($scope, registroT)  {
      $scope.registroTienda = function(){
              if(($scope.password==$scope.passwordConf)){
                  var tendero={"nombre":$scope.nombre,"email":$scope.email,"nickname":$scope.nickname};
                  var tienda={"direccion":$scope.dirTienda,"nombre":$scope.nomTienda,"nit":$scope.nitTienda,"telefono":$scope.telTienda,"tendero":tendero};
                  registroT.save(tienda);
              }

          }

}]);