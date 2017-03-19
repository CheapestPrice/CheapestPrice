'use strict';

angular.module('myApp.viewMap', ['ngRoute'])

    .config(['$routeProvider', '$sceDelegateProvider', function ($routeProvider, $sceDelegateProvider) {
        $routeProvider.when('/viewMap', {
            templateUrl: 'map/map.html',
            controller: 'ViewMapCtrl'
        });
        //$sceDelegateProvider.resourceUrlWhitelist(['self','https://maps.googleapis.com/maps/api/directions/**'])
    }])
    .controller('ViewMapCtrl', ['uiGmapGoogleMapApi', '$scope', '$rootScope', '$location', '$http','$document', function (uiGmapGoogleMapApi, $scope, $rootScope, $location, $http,$document) {
        console.log($rootScope.x + " " + $rootScope.y);
        /*window.map = new google.maps.Map(document.getElementById('map'), {
            mapTypeId: google.maps.MapTypeId.ROADMAP,
            scrollwheel: false
        });*/
        $scope.map = {center: {latitude: $rootScope.x, longitude: $rootScope.y}, zoom: 15};
        $scope.curr = {
            id: 'source',
            center: {
                latitude : $rootScope.x,
                longitude : $rootScope.y
            }
        };
        $scope.points=[];
        $scope.markers=[
            {
                id: 'source',
                center: {
                    latitude : $rootScope.x,
                    longitude : $rootScope.y
                }
            }
        ];
        var places=[
            {
                x: 4.750667,
                y: -74.062927
            },
            {
                x: 4.747331,
                y: -74.065019
            }
        ];
        places.forEach(function(item,index){
            $scope.markers.push({
                id: index+"",
                center: {
                    latitude: item.x,
                    longitude: item.y
                }

            });
            $scope.points.push({
                latitude: item.x,
                longitude: item.y
            });
        });
        /*var directionsDisplay = new google.maps.DirectionsRenderer();
        var directionsService = new google.maps.DirectionsService();
        var geocoder = new google.maps.Geocoder();
        var bounds = new google.maps.LatLngBounds();*/
        //bounds.extend($scope.source.center);

        /*var apiKey="AIzaSyBYRVtSxaERYgZoESFx_4pExGXMbHHU8F8";
         var url="https://maps.googleapis.com/maps/api/directions/json?origin=4.7809235999999995,-74.04762629999999&destination=4.7809235999999995,-74.04762629999999&key=AIzaSyBYRVtSxaERYgZoESFx_4pExGXMbHHU8F8";
         $.ajax({
         url:url,
         type: 'GET',
         dataType: 'jsonp',
         cache: false
         })
         .done(function(data){
         console.log("it worked");
         console.log(data);
         });
         var work=function(data){
         console.log(data);
         }*/
        //console.log(googleAns);
    }])
