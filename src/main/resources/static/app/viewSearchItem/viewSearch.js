'use strict';

angular.module('myApp.viewSearch', ['ngRoute', 'ngMaterial'])

    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/viewSearch', {
            templateUrl: 'viewSearchItem/viewSearch.html',
            controller: 'ViewSearchCtrl',
            directive: 'starRating'
        });
    }])

    .controller('ViewSearchCtrl', ['$scope', 'placesStubFactory', '$rootScope', 'allItems', '$mdDialog', 'listasMercadoStubFactory', function ($scope, placesStubFactory, $rootScope, allItems, $mdDialog, listasMercadoStubFactory) {
        //$scope.items= placesStubFactory.getListado()[0].sedes[0].productos;
        $scope.items = allItems.query();
        $scope.status = '  ';
        $scope.customFullscreen = false;
        $scope.chooseItem = "";
        $scope.chooseList = "";
        console.log($scope.items);
        console.log(placesStubFactory.getListado()[0].sedes[0].productos);
        $scope.rating2 = 3;
        $scope.isReadonly = true;
        $scope.rateFunction = function (rating) {
            console.log('Rating selected: ' + rating);
        };
        $scope.item = function (ite) {
            $rootScope.itemSeleccionado = ite;
        }
        var x = 0;
        var y = 0;
        $scope.propertyName='producto.precio'
        $scope.sortBy = function(propertyName) {
            $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
            $scope.propertyName = propertyName;
        };
        $scope.test=navigator.geolocation.getCurrentPosition(function (position) {
            x = position.coords.latitude;
            y = position.coords.longitude;
        })
        $scope.distanceComparator = function (o1, o2) {
            var ans = 0;
            var t1 = o1.value.tienda;
            var t2 = o2.value.tienda;
            console.log(x+" "+y);
            if (t1 && t2 && x!=0 && y!=0) {
                if (navigator.geolocation) {
                    console.log(position);
                    var d1 = Math.sqrt((x - t1.x) * (x - t1.x) + (y - t1.y) * (y - t1.y));
                    var d2 = Math.sqrt((x - t2.x) * (x - t2.x) + (y - t2.y) * (y - t2.y));
                    ans = (d1 < d2) ? -1 : 1;
                    console.log(d1 + " " + d2 + " " + ans);
                }
            }
            return ans
        }

        /*$scope.lista = function(lista){
         $rootScope.listaSeleccionada = lista;
         }*/
        $scope.showAdvanced = function (ev, item) {
            $scope.chooseItem = item;
            $scope.chooseItem['favorito'] = false;
            $scope.chooseItem.comprado = false;
            console.log("Escogio el item ", item);
            $mdDialog.show({
                controller: DialogController,
                templateUrl: 'viewSearchItem/addToShoppingCart.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose: true,
                fullscreen: $scope.customFullscreen // Only for -xs, -sm breakpoints.
            })
                .then(function (list) {
                    $scope.chooseList = list;
                    console.log("Llego la lista ", list);
                    listasMercadoStubFactory.agregarProducto($scope.chooseItem, $scope.chooseList);
                });
        };
        function DialogController($scope, $mdDialog, listasMercadoStubFactory, $rootScope, $location) {
            listasMercadoStubFactory.listaCompleta();

            $scope.listMerc = listasMercadoStubFactory.getListaMercado();
            $scope.listaMercado = "";
            $scope.hide = function () {
                $mdDialog.hide();
            };

            $scope.cancel = function () {
                $mdDialog.cancel();
            };

            $scope.answer = function () {
                $mdDialog.hide($scope.listaMercado);
            };
            $scope.propertyName = 'nombre';
            $scope.reverse = true;

            $scope.sortBy = function (propertyName) {
                $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
                $scope.propertyName = propertyName;
            };
            $scope.ver = function (items) {
                $scope.listaMercado = items;
                $mdDialog.hide($scope.listaMercado);
            }
        }


    }]).directive('starRating', [function () {
    return {
        restrict: 'EA',
        template: '<ul class="star-rating" ng-class="{readonly: readonly}">' +
        '  <li ng-repeat="star in stars" class="star" ng-class="{filled: star.filled}" ng-click="toggle($index)">' +
        '    <i class="fa fa-star"></i>' + // or &#9733
        '  </li>' +
        '</ul>',
        scope: {
            ratingValue: '=ngModel',
            max: '=?', // optional (default is 5)
            onRatingSelect: '&?',
            readonly: '=?'
        },
        link: function (scope, element, attributes) {
            if (scope.max == undefined) {
                scope.max = 5;
            }
            function updateStars() {
                scope.stars = [];
                for (var i = 0; i < scope.max; i++) {
                    scope.stars.push({
                        filled: i < scope.ratingValue
                    });
                }
            };
            scope.toggle = function (index) {
                if (scope.readonly == undefined || scope.readonly === false) {
                    scope.ratingValue = index + 1;
                    scope.onRatingSelect({
                        rating: index + 1
                    });
                }
            };
            scope.$watch('ratingValue', function (oldValue, newValue) {
                if (newValue) {
                    updateStars();
                }
            });
        }
    };
}]);