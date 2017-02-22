'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngMaterial',
  'services.listFactory',
  'myApp.vistaPrincipal',
  'myApp.login',
  'myApp.viewProducts',
  'myApp.shopList',
  'myApp.listasMercado',
  'myApp.version',
  'myApp.viewAddProducts',
  'myApp.viewSearch',
  'services.listFactoryApi'
]).
config(['$routeProvider','$httpProvider', function($routeProvider, $httpProvider) {
    $routeProvider.otherwise({redirectTo: '/vistaPrincipal'});
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
}])
.controller('logout',['$rootScope','$scope', '$http','$location', function($rootScope,$scope,$http,$location)  {
  $scope.logout = function () {
	      $http.post('/logout', {}).then(successCallback, errorCallback);
	      function successCallback(){
	        $rootScope.authenticated = false;
	        $location.path("/vistaPrincipal");
	      }
	      function errorCallback(data){
	        $rootScope.authenticated = false;
	      }
    };
}]);
