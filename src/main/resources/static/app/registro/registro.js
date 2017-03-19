'use strict';

angular.module('myApp.registro', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registro', {
    templateUrl: 'registro/registro.html',
    controller: 'registro'
  });
}])

.controller('registro', ['bcrypt','$scope', 'registroU', function (bcrypt,$scope, registroU)  {
      var random=Math.floor((Math.random() * 10) + 5);
      $scope.salt = bcrypt.genSaltSync(random);
      $scope.hash = bcrypt.hashSync("tendero", $scope.salt);
      console.log($scope.hash);
      $scope.registro = function(){
              if(($scope.password==$scope.passwordConf)){
                  var usuario={"nombre":$scope.nameU,"email":$scope.email,"nickname":$scope.nickname};
                  registroU.save(usuario);
              }

          }

}]);