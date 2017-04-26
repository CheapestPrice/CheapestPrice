'use strict';

angular.module('myApp.registro', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registro', {
    templateUrl: 'registro/registro.html',
    controller: 'registro'
  });
}])

.controller('registro', ['bcrypt','$scope', '$rootScope', 'registroU','registroC','registroT','$mdDialog', function (bcrypt,$scope,$rootScope, registroU, registroC, registroT,$mdDialog)  {

    $scope.validada=false;
    $scope.validada2=false;

    $scope.tienda=function(){
        if($scope.validada) $scope.validada = false;
        else $scope.validada=true;

    }

    var random=Math.floor((Math.random() * 10) + 5);
    $scope.salt = bcrypt.genSaltSync(random);
    $scope.hash = bcrypt.hashSync("tendero", $scope.salt);
    console.log($scope.hash);
    $scope.registro = function(){
        if(($scope.password==$scope.passwordConf)){
            var usuario={"nombre":$scope.nameU,"email":$scope.email};
            var cuenta={"email":$scope.email, "hash:" :$scope.password, "rol":'Usuario'}
            registroC.save(cuenta);
            registroU.save(usuario);
        }
    }

    $scope.registroTienda = function(ev){
        if($scope.validada){
            if(($scope.password==$scope.passwordConf)&& ($scope.nitTienda!=null)){
                $scope.showAdvanced(ev);

            }
            else{
                alert("Llena los campos correctamente");
            }
        }else{
            if(($scope.password==$scope.passwordConf)){
                var usuario = new Usuario();
                usuario.nombre = $scope.nameU;
                usuario.correo = $scope.email;
                var cuenta = new Cuenta();
                cuenta.email = $scope.email;
                cuenta.hash = $scope.password;
                cuenta.rol = 'Usuario';
                //registroU.save(usuario).$promise.then(registroC.save(cuenta));


            }
            else{
                alert("Llena los campos correctamente");
            }
        }

    };
    $scope.showAdvanced = function(ev) {
        // Appending dialog to document.body to cover sidenav in docs app
        $mdDialog.show({
          controller: DialogController,
          templateUrl: 'registro/mapaConfirm.html',
          parent: angular.element(document.body),
          targetEvent: ev,
          clickOutsideToClose:true,
          onComplete: function(){
                $scope.mapi();
             }
        })
            .then(function(answer) {
              $scope.status = 'You said the information was "' + answer + '".';
            }, function() {
              $scope.status = 'You cancelled the dialog.';
            });
      };
      $scope.mapi = function(){
        console.log($rootScope.x+", "+$rootScope.y);
        var latitud;
        var longitud;
        var latlon = "";
        var geocoder = new google.maps.Geocoder();
        var address = $scope.dirTienda+",Bogota";
        geocoder.geocode( { 'address': address}, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                console.log(results);
                latitud = results[0].geometry.location.lat();
                longitud = results[0].geometry.location.lng();
                console.log('La longitud es: ' + longitud + ', la latitud es: ' + latitud);
                latlon = latitud + "," + longitud;
                var img_url = "https://maps.googleapis.com/maps/api/staticmap?center="
                    +latlon+"&zoom=17&size=400x300&markers=color:blue|label:H|"
                    +latlon+"&sensor=true&key=AIzaSyAHWCLBHGvJpCZkc82kL9w9FykQB6Zy3pM";
                document.getElementById("mapholder").innerHTML = "<img src='"+img_url+"'>";
                //$scope.validada2=true;
                var tiendaId={"nit":$scope.nitTienda,"latitud":latitud,"longitud":longitud};
                var tendero={"nombre":$scope.nombre,"email":$scope.email,"nickname":$scope.nickname};
                var cuenta={"email":$scope.email, "hash:" :$scope.password, "rol":'Tendero'}
                var tienda={"direccion":$scope.dirTienda,"id":tiendaId,"nombre":$scope.nomTienda,"telefono":$scope.telTienda,"tendero":tendero};
                //registroT.save(tienda).$promise.then(registroC.save(cuenta));
                    }
                        });
      }
      function DialogController($scope, $mdDialog, $rootScope) {

              $scope.hide = function() {
                $mdDialog.hide();
              };

              $scope.cancel = function() {
                $mdDialog.cancel();
              };

              $scope.answer = function() {
                $mdDialog.hide();
              };
        }



}]);