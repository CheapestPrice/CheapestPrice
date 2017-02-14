'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'ngMaterial',
  'services.listFactory',
  'myApp.view1',
  'myApp.viewProducts',
  'myApp.viewPlaces',
  'myApp.shopList',
  'myApp.viewItem',
  'myApp.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/view1'});
}]);
