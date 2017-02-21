'use strict';
angular.module('services.listFactory', ['ngRoute'])
    .factory('itemsStubFactory', function () {
        var items = {
                    lista:[
                      {favorito:false,
                       comprado:false,
                       producto:{
                            nombre:'Leche',
                            categoria:'Leche',
                            precio:3500,
                            marca:'Alqueria',
                            id:'01'
                        },
                        tienda:{
                            direccion:'Cll 167 #58a-20',
                            x:4.7498466,
                            y:-74.0623005,
                            nombre:'Surtir',
                            nit:'123456456'
                        }},
                        {favorito:false,
                        comprado:false,
                        producto:{
                            nombre:'Coca-Cola',
                             categoria:'Gaseosa',
                             precio:4500,
                             marca:'Coca-Cola',
                            id:'02'
                        },
                        tienda:{
                            direccion:'Cll 167 #58a-20',
                            x:4.7498466,
                            y:-74.0623005,
                            nombre:'Surtir',
                            nit:'123456456'
                        }},{favorito:false,
                        comprado:false,
                        producto:{
                              nombre:'Papas BBQ',
                              categoria:'Papas',
                              precio:4500,
                              marca:'Margarita',
                              id:'03'
                          },
                          tienda:{
                              direccion:'Cll 167 #58a-20',
                              x:4.7498466,
                              y:-74.0623005,
                              nombre:'Surtir',
                              nit:'123456456'
                          }}
                    ]
                }
        return{
        getItems : function(){
            return items.lista;
        },
        eliminate : function(pro, tien){
            for(var i=0;i<items.lista.length;i++){
                if(items.lista[i].producto.id == pro && items.lista[i].tienda.nombre == tien){
                        items.lista.splice(i,1);
                        break
                    }
             }
         },
         sale : function(pro, tien, fav){
            for(var i=0;i<items.lista.length;i++){
                if(items.lista[i].producto.id == pro && items.lista[i].tienda.nombre == tien){
                   items.lista[i].comprado=fav;
                   break
                }
             }
             console.log(fav);
            console.log(items.articulos);
         }
       }
    })
    .factory('items2StubFactory', function () {
        var items = {
            lista:[
               {producto:{
                    nombre:'Leche',
                    categoria:'Leche',
                    precio:3500,
                    marca:'Alqueria',
                    id:'01'
                },
                tienda:{
                    direccion:'Cll 167 #58a-20',
                    x:4.7498466,
                    y:-74.0623005,
                    nombre:'Surtir',
                    nit:'123456456',
                    telefono:'65498765'
                }},
                {producto:{
                    nombre:'Coca-Cola',
                     categoria:'Gaseosa',
                     precio:4500,
                     marca:'Coca-Cola',
                    id:'02'
                },
                tienda:{
                    direccion:'Cll 167 #58a-20',
                    x:4.7498466,
                    y:-74.0623005,
                    nombre:'Surtir',
                    nit:'123456456',
                    telefono:'65498765'
                }},{producto:{
                      nombre:'Papas BBQ',
                      categoria:'Papas',
                      precio:4500,
                      marca:'Margarita',
                      id:'03'
                  },
                  tienda:{
                      direccion:'Cll 167 #58a-20',
                      x:4.7498466,
                      y:-74.0623005,
                      nombre:'Surtir',
                      nit:'123456456',
                      telefono:'65498765'
                  }}
            ]
        }
        return{
            getItems : function(){
                return items.lista;
            },
            getItemsTienda:function(tienda){
                var res=[]
                items.lista.forEach(function(item,index){
                    if(item.tienda.nombre==tienda){
                        res.push(item);
                    }
                })
                return res;
            },
            getCategorias: function(){
               var cate=new Set();
               var catego=[]
               items.lista.forEach(function(item,index){
                    if(!cate.has(item.producto.categoria)){
                        cate.add(item.producto.categoria);
                        catego.push(item.producto.categoria);
                        }
                })
               return catego;
            },
            registrarProducto: function(item){
                items.lista.push(item);
                console.log(items.lista);
            },
            modificarProducto:function(item){
                items.lista.forEach(function (itemm,index) {
                    if(item.producto.id==itemm.producto.id && item.tienda.nombre==itemm.tienda.nombre){
                        itemm.producto=item.producto;
                    }
                })
            }

       }
    })
    .factory('placesStubFactory', function () {
            var list = {
                listado : [{
                            nombre:'Surtir',
                            sedes:[{
                                 nombre:'San Cipriano',
                                 direccion: 'Cll 167 # 40B 20',
                                 productos:[{
                                                nombre:'Leche',
                                                categoria:'Leche',
                                                precio:'3500',
                                                marca:'Alqueria',
                                                tienda:'Surtir'
                                           },
                                           {
                                                 nombre:'Coca-Cola',
                                                 categoria:'Gaseosa',
                                                 precio:'4500',
                                                 marca:'Coca-Cola',
                                                 tienda:'Surtir'
                                           },
                                           {
                                                nombre:'Papas BBQ',
                                                categoria:'Papas',
                                                precio:'4500',
                                                marca:'Margarita',
                                                tienda:'Surtir'
                                           }]
                            }
                            ]
                       }]
            }
            return {
                getListado : function(){
                    return list.listado;
                },
                addProduct : function(tienda){
                    list.listado.push(tienda);
                },
                getSedes : function(name){
                    var a;
                    list.listado.forEach(function(item,index){
                        if(item.nombre==name){
                            a=item;
                        }
                    })
                    return a.sedes;
                },
                getSede : function(tienda,sede){
                    var a;
                    this.getSedes(tienda).forEach(function(item,index){
                        if(item.nombre==sede){
                            a=item;
                        }
                    })
                    return a;
                }
            }
        });
