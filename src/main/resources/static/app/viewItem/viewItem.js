'use strict';

angular.module('myApp.viewItem', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewItem', {
    templateUrl: 'viewItem/viewItem.html',
    controller: 'ViewItemCtrl'
  });
}])

.controller('ViewItemCtrl', ['$scope','itemsStubFactory','$rootScope', function($scope, itemsStubFactory, $rootScope) {


}]);