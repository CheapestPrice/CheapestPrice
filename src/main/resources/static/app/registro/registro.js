'use strict';

angular.module('myApp.registro', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/registro', {
    templateUrl: 'registro/registro.html',
    controller: 'registro'
  });
}])

.controller('registro', ['bcrypt','$scope', '$rootScope', 'registroU','registroC','registroTi','registroTe','$mdDialog', function (bcrypt,$scope,$rootScope, registroU, registroC, registroTi,registroTe,$mdDialog)  {

    $scope.validada=false;
    $scope.validada2=false;

    $scope.tienda=function(){
        if($scope.validada) $scope.validada = false;
        else $scope.validada=true;

    }
    /*var random=Math.floor((Math.random() * 10) + 5);
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
    }*/

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
              console.log('2. La longitud es: ' + $scope.longitud + ', la latitud es: ' + $scope.latitud);
              var cuenta = new Cuenta();
              cuenta.email = $scope.email;
              cuenta.hash = $scope.password;
              cuenta.rol = 'Tendero';
              var usuario = new Usuario();
              usuario.nombre = $scope.nameU;
              usuario.correo = $scope.email;
              var tiendaId = new TiendaId($scope.nitTienda, $scope.longitud, $scope.latitud);
              var tienda = new Tienda(tiendaId, $scope.dirTienda, $scope.nomTienda, $scope.telTienda, true);
              var tendero = new Tendero($scope.email, $scope.nameU, $scope.nitTienda, $scope.longitud, $scope.latitud);
              registroU.save(usuario).$promise.then(registroTi.save(tienda).$promise.then(registroTe.save(tendero).$promise.then(registroC.save(cuenta))));
              //$scope.status = 'You said the information was "' + answer + '".';
            }, function() {
            alert("Bueno jodase");
              //$scope.status = 'You cancelled the dialog.';
            });
      };
      $scope.mapi = function(){
        $scope.latitud;
        $scope.longitud;
        var latlon = "";
        var geocoder = new google.maps.Geocoder();
        var address = $scope.dirTienda+",Bogota";
        geocoder.geocode( { 'address': address}, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                console.log(results);
                $scope.latitud = results[0].geometry.location.lat();
                $scope.longitud = results[0].geometry.location.lng();
                console.log('La longitud es: ' + $scope.longitud + ', la latitud es: ' + $scope.latitud);
                latlon = $scope.latitud + "," + $scope.longitud;
                var img_url = "https://maps.googleapis.com/maps/api/staticmap?center="
                    +latlon+"&zoom=17&size=400x300&markers=color:blue|label:H|"
                    +latlon+"&sensor=true&key=AIzaSyAHWCLBHGvJpCZkc82kL9w9FykQB6Zy3pM";
                document.getElementById("mapholder").innerHTML = "<img src='"+img_url+"'>";
                //$scope.validada2=true;

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