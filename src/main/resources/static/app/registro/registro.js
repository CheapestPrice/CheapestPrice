'use strict';

angular.module('myApp.registro', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registro', {
    templateUrl: 'registro/registro.html',
    controller: 'registro'
  });
}])

.controller('registro', ['$scope', 'registroU', function ($scope, registroU)  {
      $scope.registro = function(){
              if(($scope.password==$scope.passwordConf)){
                  var usuario={"nombre":$scope.nameU,"email":$scope.email,"nickname":$scope.nickname};
                  registroU.save(usuario);
              }

          }

}]);