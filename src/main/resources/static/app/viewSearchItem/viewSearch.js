'use strict';

angular.module('myApp.viewSearch', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/viewSearch', {
    templateUrl: 'viewSearchItem/viewSearch.html',
    controller: 'ViewSearchCtrl',
    directive:'starRating'
});
}])

.controller('ViewSearchCtrl', ['$scope','placesStubFactory','$rootScope', function($scope,placesStubFactory,$rootScope) {
    $scope.products= placesStubFactory.getListado()[0].sedes[0].productos;
    console.log(placesStubFactory.getListado()[0].sedes[0].productos);
        $scope.rating2 = 3;
        $scope.isReadonly = true;
        $scope.rateFunction = function(rating) {
          console.log('Rating selected: ' + rating);
        };
}]).directive('starRating', [function(){
    return {
          restrict: 'EA',
          template:
            '<ul class="star-rating" ng-class="{readonly: readonly}">' +
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
          link: function(scope, element, attributes) {
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
            scope.toggle = function(index) {
              if (scope.readonly == undefined || scope.readonly === false){
                scope.ratingValue = index + 1;
                scope.onRatingSelect({
                  rating: index + 1
                });
              }
            };
            scope.$watch('ratingValue', function(oldValue, newValue) {
              if (newValue) {
                updateStars();
              }
            });
          }
        };
}]);