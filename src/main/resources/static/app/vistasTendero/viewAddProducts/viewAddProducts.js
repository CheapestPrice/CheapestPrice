'use strict';

angular.module('myApp.viewAddProducts', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/viewAddProducts', {
        templateUrl: 'vistasTendero/viewAddProducts/viewAddProducts.html',
        controller: 'ViewAddProductsCtrl'
    });
}])

.controller('ViewAddProductsCtrl', ['$scope', 'items2StubFactory', '$rootScope','$location','itemsByShop','updateItem','itemByShopAndId','allItems', function($scope,items2StubFactory,$rootScope,$location,itemsByShop,updateItem,itemByShopAndId,allItems) {
    //AGREGAR
    $scope.agregar=true;
    $rootScope.tienda="Surtir";
    $rootScope.shop={
        direccion:'Cll 167 #58a-20',
        x:4.7498466,
        y:-74.0623005,
        nombre:'Surtir',
        telefono:"65498765",
        disponible:true,
        nit:'123456456'
    };
    $scope.selectedCategoria="";
    $scope.nombre="";
    $scope.precio=50;
    $scope.marca="";
    //$scope.listaProductos=itemsByShop.query({shopName:$rootScope.shop.nombre});
    console.log(itemsByShop.query({shopName:$rootScope.shop.nombre}));
    $scope.listado=itemsByShop.query({shopName:$rootScope.shop.nombre});
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
            var num=items2StubFactory.getItems().length;
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

            allItems.save(itemm,function(data){
                $scope.listado=itemsByShop.query({shopName:$rootScope.shop.nombre});
              },function(error){
                $scope.fail=true;
                $scope.success=false;
                $scope.mensaje="Por favor, revise la información suministrada...";
              })
            $scope.mensaje="Por favor, revise la información suministrada...";
            }
            /*var sePudo=items2StubFactory.registrarProducto(itemm);
            if(!sePudo){
                $scope.fail=true;
                $scope.success=false;
                $scope.mensaje="Por favor, revise la información suministrada...";
            }*/

            //$scope.listado=items2StubFactory.getItemsTienda($rootScope.shop.nombre);
            //$scope.listado=items2StubFactory.getItemsTienda($rootScope.tienda);
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
        if($scope.producto.producto.nombre.length>0 && $scope.producto.producto.marca.length>0 && $scope.producto.producto.categoria.length>0 && $scope.producto.producto.precio>=0){
            $scope.mensaje="El producto fue modificado sactisfactoriamente...";
            $scope.success=true;
            $scope.fail=false;
            //items2StubFactory.modificarProducto($scope.producto);
            updateItem.update({oldShop:$scope.producto.tienda.nombre,oldId:$scope.producto.producto.id},$scope.producto,function(){
                                                                                                                                    $scope.listado=itemsByShop.query({shopName:$rootScope.shop.nombre});
                                                                                                                                });
        }
    };
    $scope.volver=function () {
        $scope.agregar = true;
        $scope.modificar = false;

    }
    //Eliminar
    $scope.eliminar=function(item){
		//items2StubFactory.eliminarProducto(item);
        itemByShopAndId.delete({shopName:item.tienda.nombre,idNum:item.producto.id},function(){
            $scope.listado=itemsByShop.query({shopName:$rootScope.shop.nombre});
        })
		//$scope.listado=items2StubFactory.getItemsTienda($rootScope.shop.nombre);
		$scope.volver();
    }
}]);