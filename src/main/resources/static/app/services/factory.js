'use strict';
angular.module('services.listFactory', ['ngRoute', 'ngResource'])


    .factory('registroT', function($resource) {
                        return $resource('/tiendas');
    })

    .factory('registroU', function($resource) {
                    return $resource('/usuarios');
                })


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
    .factory('listasMercadoStubFactory', function () {
            var listaMercado = {
                        lista:[{
                            nombre: "Lista 1",
                            fechaCreacion: new Date(1487653200000),
                            revisado: false,
                            items:[{producto:{
                                nombre:'Leche',
                                categoria:'Leche',
                                precio:3500,
                                marca:'Alqueria',
                                id:'01'
                            },
                            favorito: false,
                            comprado: true,
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
                            favorito: false,
                            comprado: true,
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
                              favorito: false,
                              comprado: true,
                              tienda:{
                                  direccion:'Cll 167 #58a-20',
                                  x:4.7498466,
                                  y:-74.0623005,
                                  nombre:'Surtir',
                                  nit:'123456456',
                                  telefono:'65498765'
                              }}
                        ]
                        }]
                }

            return{
            getListaMercado : function(){
                return listaMercado.lista;
            },
            eliminate : function(nom){
                for(var i=0;i<listaMercado.lista.length;i++){
                    if(listaMercado.lista[i].nombre == nom){
                            listaMercado.lista.splice(i,1);
                            break
                        }
                 }
             },
            eliminarItem : function(pro, tien, nom){
                var ban = false
                for(var i=0;i<listaMercado.lista.length;i++){
                   if(listaMercado.lista[i].nombre == nom){
                      for(var j=0; j<listaMercado.lista[i].items.length;j++){
                            if(listaMercado.lista[i].items[j].producto.id == pro && listaMercado.lista[i].items[j].tienda.nombre == tien){
                                  listaMercado.lista[i].items.splice(j,1);
                                    ban = true
                                    break
                            }
                      }
                      if(ban){
                        break
                      }
                   }
                }
            },
            comprarItem : function(pro, tien, nom){
                var ban = false
                for(var i=0;i<listaMercado.lista.length;i++){
                   if(listaMercado.lista[i].nombre == nom){
                      for(var j=0; j<listaMercado.lista[i].items.length;j++){
                            if(listaMercado.lista[i].items[j].producto.id == pro && listaMercado.lista[i].items[j].tienda.nombre == tien){
                                  listaMercado.lista[i].items[j].comprado=!listaMercado.lista[i].items[j].comprado;
                                    ban = true
                                    break
                            }
                      }
                      if(ban){
                        break
                      }
                   }
                }
            },
            listaCompleta : function(){
                for(var i=0;i<listaMercado.lista.length;i++){
                    var completa=false
                    var con=0
                    for(var j=0;j<listaMercado.lista[i].items.length;j++){
                         if(listaMercado.lista[i].items[j].comprado){
                            console.log(listaMercado.lista[i].items[j])
                            con+=1
                         }
                     }
                    if(con==listaMercado.lista[i].items.length){
                        completa = true
                    }
                    listaMercado.lista[i].revisado = completa
                }
                console.log(listaMercado.lista)
            },
            agregarProducto : function(pro, lis){
                for(var i=0;i<listaMercado.lista.length;i++){
                    if(listaMercado.lista[i].nombre == lis.nombre){
                        listaMercado.lista[i].items.push(pro);
                    }
                }
                console.log("Lista luego de agregar producto")
                console.log(listaMercado.lista)
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
                var unique=true;
                items.lista.forEach(function (itemm,index) {
                    if(item.producto.nombre==itemm.producto.nombre && item.producto.marca==itemm.producto.marca){
                        unique=false;
                    }
                })
                if(unique){
                    items.lista.push(item);
                }
                console.log(items.lista);
                return unique;
            },
            modificarProducto:function(item){
                items.lista.forEach(function (itemm,index) {
                    if(item.producto.id==itemm.producto.id && item.tienda.nombre==itemm.tienda.nombre){
                        itemm.producto=item.producto;
                    }
                })
            },
            eliminarProducto:function(item){
                for (var index=0;index<items.lista.length;index++) {
                	var itemm=items.lista[index];
                    if(item.producto.nombre==itemm.producto.nombre && item.producto.marca==itemm.producto.marca){
                        items.lista.splice(index,1);
                        break;
                    }
                }
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
        })

angular.module('services.listFactoryApi', ['ngRoute','ngResource'])
    .factory('allItems',function($resource) {
        return $resource('/items');
    })
    .factory('itemByShopAndId',function($resource) {
        return $resource('/items/shop/:shopName/id/:idNum');
    })
    .factory('itemsByShop',function($resource) {
        return $resource('/items/shop/:shopName');
    })
    .factory('itemsByCategory',function($resource) {
        return $resource('/items/category/:categoryName');
    })
    .factory('itemsById',function($resource) {
        return $resource('/items/:idNum');
    })
    .factory('updateItem',function($resource) {
            return $resource('/items/shop/:oldShop/id/:oldId', null,
                   {
                       'update': { method:'PUT' }
                   });
     })
     .factory('updateUser',function($resource){
            return $resource('/usuarios/:nickname', null,

            {
                'update' : {method:'PUT'}
            });
    })
    .factory('getUserNickname',function($resource) {
        return $resource('/usuarios/:nickname');
    });

