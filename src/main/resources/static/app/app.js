'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngMaterial',
  'services.listFactory',
  'myApp.viewProducts',
  'myApp.shopList',
  'myApp.viewItem',
  'myApp.version',
  'myApp.viewAddProducts',
  'myApp.viewSearch'
])
.config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
