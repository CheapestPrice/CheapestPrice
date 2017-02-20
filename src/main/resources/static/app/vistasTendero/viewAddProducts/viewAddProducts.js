'use strict';

angular.module('myApp.viewAddProducts', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('vistasTendero/viewAddProducts', {
    templateUrl: 'vistasTendero/viewAddProducts/viewAddProducts.html',
    controller: 'ViewPlacesCtrl'
  });
}])

.controller('ViewAddProductsCtrl', ['$scope', '$rootScope','$location', function($scope,$rootScope,$location) {
    $scope.listado=                                         [{
                                                                   nombre:'Leche',
                                                                   categoria:'Leche',
                                                                   precio:'3500',
                                                                   marca:'Alqueria',
                                                                   foto:'No disponible'
                                                              },
                                                              {
                                                                    nombre:'Coca-Cola',
                                                                    categoria:'Gaseosa',
                                                                    precio:'4500',
                                                                    marca:'Coca-Cola',
                                                                    foto:'No disponible'
                                                              },
                                                              {
                                                                   nombre:'Papas BBQ',
                                                                   categoria:'Papas',
                                                                   precio:'4500',
                                                                   marca:'Margarita',
                                                                   foto:'No disponible'
                                                              }]
    $scope.propertyName = 'nombre';
    $scope.reverse = false;
    $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
     };

}]);