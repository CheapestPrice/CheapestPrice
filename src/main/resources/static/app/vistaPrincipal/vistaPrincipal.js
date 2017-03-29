'use strict';

angular.module('myApp.vistaPrincipal', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/vistaPrincipal', {
    templateUrl: 'vistaPrincipal/vistaPrincipal.html',
    controller: 'vistaPrincipalCtrl'
  });
}])

.controller('vistaPrincipalCtrl', ['$scope', '$rootScope', '$location', function($scope,$rootScope,$location) {
    $scope.nextLogin=function(){
            $location.path("/login");
    }
    $rootScope.x=0;
    $rootScope.y=0;
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function (position) {
          console.log(position);
          $rootScope.x = position.coords.latitude;
          $rootScope.y = position.coords.longitude;
          //console.log($rootScope.x+" "+$rootScope.y);
      },function (err) {
          console.warn('ERROR(' + err.code + '): ' + err.message);
        },{timeout:10000, enableHighAccuracy: true})
      console.log("navigator.geolocation");
    }else{
      console.log("no navigator.geolocation");
    }
    $scope.nextRegistro=function(){
                $location.path("/registro");
        }

}]);
