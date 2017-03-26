'use strict';

angular.module('myApp.viewAddProducts', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
    $routeProvider.when('/viewAddProducts', {
        templateUrl: 'vistasTendero/viewAddProducts/viewAddProducts.html',
        directive: 'fileModel',
        service: 'fileUpload',
        controller: 'ViewAddProductsCtrl'
    });
}])
.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}])
.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function(file, uploadUrl){
        var fd = new FormData();
        fd.append('file', file);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
    }
}])
.controller('ViewAddProductsCtrl', ['$scope', 'items2StubFactory', '$rootScope','$location','itemsByShop','getShop','updateItem','itemByShopAndId','allItems','fileUpload', function($scope,items2StubFactory,$rootScope,$location,itemsByShop,getShop,updateItem,itemByShopAndId,allItems,fileUpload) {
    //AGREGAR
    $scope.agregar=true;
    $rootScope.tienda="Surtir";
    $rootScope.shopId = new TiendaId();
    $rootScope.shop= new Tienda();
    $rootScope.shopId.nit = '1234567-2';
    $rootScope.shopId.x = 4.7649271000;
    $rootScope.shopId.y = -74.0476042000;
    $rootScope.shop.direccion = 'Cll 167 #58a-20';
    $rootScope.shop.nombre = 'Donde Pepe';
    $rootScope.shop.telefono = '5473829';
    $rootScope.shop.disponible = true;
    $rootScope.shop.id= $rootScope.shopId;

    /*{
        direccion:'CR NM #NM-NM',
        x:4.7649271000,
        y:-74.0476042000,
        nombre:'Donde Pepe',
        telefono:"5473829",
        disponible:true,
        nit:'1234567-2'
    };*/
    $scope.uploadFile = function(){
        var file = $scope.myFile;
        console.log('file is ' );
        console.dir(file);
        var uploadUrl = "/dispatches/upload?idpedido="+$scope.idpedido+"&idvehiculo="+$scope.idvehiculo;
        fileUpload.uploadFileToUrl(file, uploadUrl);
    };
    $scope.produc = new Producto();
    $scope.produc.nombre = "";
    $scope.produc.marca = "";
    $scope.produc.categoria = "";
    $scope.ite = new Item();
    $scope.ite.precio = 50;
    /*$scope.selectedCategoria="";
    $scope.nombre="";
    $scope.precio=50;
    $scope.marca="";*/
    //$scope.listaProductos=itemsByShop.query({shopName:$rootScope.shop.nombre});
    console.log(getShop);
    console.log(getShop.get({x:$rootScope.shopId.x, y:$rootScope.shopId.y, nit:$rootScope.shopId.nit}));
    $scope.listado=itemsByShop.query({x:$rootScope.shopId.x, y:$rootScope.shopId.y, nit:$rootScope.shopId.nit});
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
        if($scope.produc.nombre.length>0 && $scope.produc.marca.length>0 && $scope.produc.categoria.length>0 && $scope.ite.precio>0){
            $scope.mensaje="El producto fue registrado sactisfactoriamente...";
            $scope.success=true;
            $scope.fail=false;
            /*var num=items2StubFactory.getItems().length;
            var itemm={
                producto:{
                    nombre: $scope.nombre,
                    categoria: $scope.selectedCategoria,
                    marca:$scope.marca
                },
                tienda:$rootScope.shop,
                precio:$scope.precio
            }*/
            $scope.ite.producto = $scope.produc;
            $scope.ite.tienda = $rootScope.shop;
            $scope.iteId = new ItemId();
            $scope.iteId.tiendaNit = $rootScope.shopId.nit;
            $scope.iteId.tiendaX = $rootScope.shopId.x;
            $scope.iteId.tiendaY = $rootScope.shopId.y;
            $scope.iteId.productoId = $scope.listado.length + 1;
            $scope.ite.id = $scope.iteId;
            allItems.save($scope.ite,function(data){
                var file = $scope.myFile;
                console.log('file is ' );
                console.dir(file);
                var uploadUrl = "/items/upload?nombre="+ $scope.produc.nombre+"&marca="+$scope.produc.marca+"&categoria="+$scope.produc.categoria;
                fileUpload.uploadFileToUrl(file, uploadUrl);
                $scope.listado=itemsByShop.query({x:$rootScope.shopId.x, y:$rootScope.shopId.y, nit:$rootScope.shopId.nit});
              },function(error){
                $scope.fail=true;
                $scope.success=false;
                $scope.mensaje="Por favor, revise la información suministrada...";
              })
            $scope.mensaje="Por favor, revise la información suministrada...";

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
            updateItem.update({oldShop:$scope.producto.tienda.nombre,oldId:$scope.producto.producto.id},$scope.producto,
                function(){
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