'use strict';

angular.module('myApp.viewAddProducts', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/viewAddProducts', {
        templateUrl: 'vistasTendero/viewAddProducts/viewAddProducts.html',
        controller: 'ViewAddProductsCtrl'
    });
}])

.controller('ViewAddProductsCtrl', ['$scope', 'items2StubFactory', '$rootScope','$location', function($scope,items2StubFactory,$rootScope,$location) {
    //AGREGAR
    $scope.agregar=true;
    $rootScope.tienda="Surtir";
    $rootScope.shop={
        direccion:'Cll 167 #58a-20',
        x:4.7498466,
        y:-74.0623005,
        nombre:'Surtir',
        nit:'123456456'
    };
    $scope.selectedCategoria="";
    $scope.nombre="";
    $scope.precio=50;
    $scope.marca="";
    $scope.listado=items2StubFactory.getItemsTienda($rootScope.tienda);
    $scope.propertyName = 'producto.nombre';
    $scope.reverse = false;
    $scope.sortBy = function(propertyName) {
        $scope.reverse = ($scope.propertyName === propertyName) ? !$scope.reverse : false;
        $scope.propertyName = propertyName;
    };
    $scope.categorias=items2StubFactory.getCategorias();
    $scope.visible=false;
    $scope.registrarProducto= function(){
        $scope.mensaje="Por favor, revise la información suministrada...";
        $scope.fail=false;
        $scope.success=false;
        if($scope.nombre.length>0 && $scope.marca.length>0 && $scope.selectedCategoria.length>0 && $scope.precio>0){
            $scope.mensaje="El producto fue registrado sactisfactoriamente...";
            $scope.success=true;
            $scope.fail=false;
            var num=$scope.listado.length;
            var itemm={
                producto:{
                    nombre: $scope.nombre,
                    categoria: $scope.selectedCategoria,
                    precio: $scope.precio,
                    marca:$scope.marca,
                    id:(num+1).toString()
                },
                tienda:$rootScope.shop
            }
            items2StubFactory.registrarProducto(itemm);
            $scope.listado=items2StubFactory.getItemsTienda($rootScope.shop.nombre);
            $scope.listado=items2StubFactory.getItemsTienda($rootScope.tienda);
            $scope.categorias=items2StubFactory.getCategorias();
        }else{
            $scope.fail=true;
            $scope.success=false;
        }
    };

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#blah').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
    $("#imgInp").change(function(){
        readURL(this);
    });
    //Modificar
    $scope.modificar=false;
    $scope.producto=null;
    $scope.modoModificar=function(item){
        $scope.producto=item;
        $scope.modificar=true;
        $scope.agregar=false;
    };
    $scope.update=function(){
        $scope.mensaje="Por favor, revise la información suministrada...";
        $scope.fail=true;
        $scope.success=false;
        console.log($scope.producto.producto.nombre+" "+$scope.producto.producto.categoria+" "+$scope.producto.producto.precio+" "+$scope.producto.producto.marca);
        if($scope.producto.producto.nombre.length>0 && $scope.producto.producto.marca.length>0 && $scope.producto.producto.categoria.length>0 && $scope.producto.producto.precio>=0){
            $scope.mensaje="El producto fue modificado sactisfactoriamente...";
            $scope.success=true;
            $scope.fail=false;
            items2StubFactory.modificarProducto($scope.producto);
        }
    };
    $scope.volver=function () {
        $scope.agregar = true;
        $scope.modificar = false;

    }
}]);