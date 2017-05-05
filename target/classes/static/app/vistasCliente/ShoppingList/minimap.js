'use strict';

angular.module('myApp.miniMap', ['ngRoute'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/ShoppingList', {
            templateUrl: 'vistasCliente/ShoppingList/ShoppingList.html',
            controller: 'ViewMiniMapCtrl'
          });
    }])
    .controller('ViewMiniMapCtrl', ['uiGmapGoogleMapApi', '$scope', '$rootScope', '$location', '$http','$document', function (uiGmapGoogleMapApi, $scope, $rootScope, $location, $http,$document) {
        $scope.show=false;
        console.log($rootScope.x + " " + $rootScope.y);
        $scope.map = {center: {latitude: $rootScope.x, longitude: $rootScope.y}, zoom: 15,control : {}};
        //getear();
        var directionsDisplay = new google.maps.DirectionsRenderer();
        var directionsService = new google.maps.DirectionsService();
        function getear(){
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

            function isIn(data,arr){
              for (var i = 0; i < arr.length; i++) {
                if(arr[i].location.lat==data.location.lat && arr[i].location.lng==data.location.lng){
                  return true;
                }
              }
              return false;
            }

            $rootScope.listaMercado.items.forEach(function(item,index){
                //$scope.markers.push({id: index+"",center: {latitude: item.x,longitude: item.y}});
                var latlng={
                    location:{
                        lat: item.item.tienda.id.x,
                        lng: item.item.tienda.id.y
                    },
                    stopover:true
                }
                if(!isIn(latlng,$scope.request.waypoints)){
                    $scope.request.waypoints.push(latlng);
                }
            });


            directionsService.route($scope.request, function (response, status) {
                console.log($scope.request);
                console.log(response);
                console.log(status);
                if (status === google.maps.DirectionsStatus.OK) {
                    directionsDisplay.setDirections(response);
                    directionsDisplay.setMap($scope.map.control.getGMap());
                } else {
                    alert('Ha ocurrido un error calculando la ruta');
                }
            });
        }

        $scope.flipShow=function(){
            //console.log($scope.show);
            if(!$scope.show && !navigator.geolocation){
                alert("Por favor active la geolocaclizaci�n del explorador");
            }else{
                if(!$scope.show){
                    getear();
                }
                $scope.show=!$scope.show;
            }
            //$location.path("/viewMap");

        }
    }])
