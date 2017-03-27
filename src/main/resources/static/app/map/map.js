'use strict';

angular.module('myApp.viewMap', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/viewMap', {
            templateUrl: 'map/map.html',
            controller: 'ViewMapCtrl'
        });
    }])
    .controller('ViewMapCtrl', ['uiGmapGoogleMapApi', '$scope', '$rootScope', '$location', '$http','$document', function (uiGmapGoogleMapApi, $scope, $rootScope, $location, $http,$document) {
        console.log($rootScope.x + " " + $rootScope.y);
        $scope.map = {center: {latitude: $rootScope.x, longitude: $rootScope.y}, zoom: 15,control : {}};
        $scope.curr = {
            id: 'source',
            center: {
                latitude : $rootScope.x,
                longitude : $rootScope.y
            }
        };
        $scope.markers=[{id: 'source',center: {latitude : $rootScope.x,longitude : $rootScope.y}}];
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
        $scope.request={
            origin: {
                    lat : $rootScope.x,
                    lng : $rootScope.y
                },
            destination:{
                    lat : $rootScope.x,
                    lng : $rootScope.y
                },
            travelMode : google.maps.TravelMode.WALKING,
            waypoints:[],
            optimizeWaypoints: true
        };
        places.forEach(function(item,index){
            $scope.markers.push({id: index+"",center: {latitude: item.x,longitude: item.y}});
            $scope.request.waypoints.push({
                location:{
                    lat: item.x,
                    lng: item.y
                },
                stopover:true
            });
        });
        var directionsDisplay = new google.maps.DirectionsRenderer();
        var directionsService = new google.maps.DirectionsService();
        directionsService.route($scope.request, function (response, status) {
            if (status === google.maps.DirectionsStatus.OK) {
                directionsDisplay.setDirections(response);
                directionsDisplay.setMap($scope.map.control.getGMap());
            } else {
                alert('Google route unsuccesfull!');
            }
        });     
    }])
