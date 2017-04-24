'use strict';

angular.module('myApp.registro', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registro', {
    templateUrl: 'registro/registro.html',
    controller: 'registro'
  });
}])

.controller('registro', ['bcrypt','$scope', 'registroU','registroC','registroT', function (bcrypt,$scope, registroU, registroC, registroT)  {

    $scope.validada=false;

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

    $scope.registroTienda = function(){
        if($scope.validada){
            if(($scope.password==$scope.passwordConf)&& ($scope.nitTienda!=null)){
                var latitud;
                var longitud;
                var geocoder = new google.maps.Geocoder();
                var address = $scope.dirTienda+",Bogota";
                geocoder.geocode( { 'address': address}, function(results, status) {
                    if (status == google.maps.GeocoderStatus.OK) {
                        latitud = results[0].geometry.location.lat();
                        longitud = results[0].geometry.location.lng();
                        console.log('La longitud es: ' + longitud + ', la latitud es: ' + latitud);
                        var tiendaId={"nit":$scope.nitTienda,"latitud":latitud,"longitud":longitud};
                        var tendero={"nombre":$scope.nombre,"email":$scope.email,"nickname":$scope.nickname};
                        var cuenta={"email":$scope.email, "hash:" :$scope.password, "rol":'Tendero'}
                        var tienda={"direccion":$scope.dirTienda,"id":tiendaId,"nombre":$scope.nomTienda,"telefono":$scope.telTienda,"tendero":tendero};
                        registroT.save(tienda).$promise.then(registroC.save(cuenta));

                    }
                });
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
                registroU.save(usuario).$promise.then(registroC.save(cuenta));


            }
            else{
                alert("Llena los campos correctamente");
            }
        }

    };



}]);