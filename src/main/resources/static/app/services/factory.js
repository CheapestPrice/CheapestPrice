'use strict';
angular.module('services.listFactory', ['ngRoute'])

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