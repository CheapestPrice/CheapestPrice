'use strict';

angular.module('myApp.login', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/login', {
    templateUrl: 'login/login.html',
    controller: 'login'
  });
}])

.controller('login', ['$rootScope', '$scope', '$http', '$location', function($rootScope, $scope, $http, $location) {

            $scope.imagePath = 'images/cheapestPrice.jpg';
            var authenticate = function (credentials, callback) {

                var headers = credentials ? {authorization: "Basic "
                            + btoa(credentials.username + ":" + credentials.password)
                } : {};

                $http.get('user', {headers: headers}).then(successCallback, errorCallback);

                function successCallback(data){
                    if (data.data.name) {
                        $rootScope.authenticated = true;
                    }else {
                        $rootScope.authenticated = false;
                    }
                        callback && callback();
                }

                function errorCallback(error){
                    $rootScope.authenticated = false;
                     callback && callback();
                }
            };

            authenticate();
            $scope.credentials = {};
            $scope.login = function () {
                authenticate($scope.credentials, function () {
                    if ($rootScope.authenticated) {
                        $location.path("/viewSearch");
                        $scope.error = false;
                    } else {
                        $location.path("/login");
                        $scope.error = true;
                    }
                });
            };
}]);