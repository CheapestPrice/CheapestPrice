'use strict';
angular.module('services.listFactory', ['ngRoute'])
    .factory('itemsStubFactory', function () {
        var items = {
            articulos:[
               {producto: 'Leche Alpina',
                precio: '2300',
                tienda: 'Don Pepe',
                direccion: 'Cr 67 #147-59',
                detalles: '',
                comprado: false,
                favorito: false,
                id: 3
               }
            ]
        }
        return{
        getItems : function(){
            return items.articulos;
        },
        eliminate : function(pro){
            for(var i=0;i<items.articulos.length;i++){
                if(items.articulos[i].id == pro){
                        items.articulos.splice(i,1);
                        break
                    }
             }
         },
         sale : function(pro, fav){
            for(var j=0;j<items.articulos.length;i++){
                if(items.articulos[i].id == pro){
                   //items.articulos.splice(i,1);
                   break
                }
             }
         }
       }
    })
    .factory('items2StubFactory', function () {
        var items = {
            lista:[
               {producto:{
                    nombre:'Leche',
                    categoria:'Leche',
                    precio:'3500',
                    marca:'Alqueria',
                    id:'01'
                },
                tienda:{
                    direccion:'Cll 167 #58a-20',
                    x:4.7498466,
                    y:-74.0623005,
                    nombre:'Surtir',
                    nit:'123456456'
                }
               }
            ]
        }
        return{
        getItems : function(){
            return items.articulos;
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