'use strict';

angular.module('myApp.viewMap', ['ngRoute'])

  .config(['$routeProvider','$sceDelegateProvider', function($routeProvider,$sceDelegateProvider) {
      $routeProvider.when('/viewMap', {
          templateUrl: 'map/map.html',
          controller: 'ViewMapCtrl'
      });
      $sceDelegateProvider.resourceUrlWhitelist(['self','https://maps.googleapis.com/maps/api/directions/**'])
  }])
  .controller('ViewMapCtrl', ['$scope', '$rootScope','$location','$http', function($scope,$rootScope,$location,$http) {
    console.log($rootScope.x+" "+$rootScope.y);
    var apiKey="AIzaSyBYRVtSxaERYgZoESFx_4pExGXMbHHU8F8";
    var url="https://maps.googleapis.com/maps/api/directions/json?origin=4.7809235999999995,-74.04762629999999&destination=4.7809235999999995,-74.04762629999999&key=AIzaSyBYRVtSxaERYgZoESFx_4pExGXMbHHU8F8";
    $http.jsonp(url,{jsonpCallbackParam: 'work'})
    var work=function(data){
      console.log(data);
    }
    //console.log(googleAns);
  }])
