package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 2105684 on 3/17/17.
 */
@Embeddable
public class ItemListaId implements Serializable {

    @Column(name = "ITEMS_TIENDAS_nit",nullable = false)
    private String tiendaNit;

    @Column(name = "ITEMS_TIENDAS_x",nullable = false)
    private double tiendaX;

    @Column(name = "ITEMS_TIENDAS_y",nullable = false)
    private double tiendaY;

    @Column(name = "ITEMS_PRODUCTOS_id",nullable = false)
    private long productoId;

    @Column(name = "LISTAS_MERCADOS_nombre",nullable = false)
    private String listaNombre;

    @Column(name = "LISTAS_MERCADOS_USUARIOS_correo",nullable = false)
    private String listaCorreo;

    public ItemListaId(){}

    public ItemListaId(Item item, ListaDeMercado lista){

    }

    public ItemListaId(String listaCorreo,String listaNombre,String tiendaNit,double tiendaX,double tiendaY, long productoId){
        this.listaCorreo=listaCorreo;
        this.listaNombre=listaNombre;
        this.tiendaNit=tiendaNit;
        this.tiendaX=tiendaX;
        this.tiendaY=tiendaY;
        this.productoId=productoId;
    }

    public String getTiendaNit() {
        return tiendaNit;
    }

    public void setTiendaNit(String tiendaNit) {
        this.tiendaNit = tiendaNit;
    }

    public double getTiendaX() {
        return tiendaX;
    }

    public void setTiendaX(double tiendaX) {
        this.tiendaX = tiendaX;
    }

    public double getTiendaY() {
        return tiendaY;
    }

    public void setTiendaY(double tiendaY) {
        this.tiendaY = tiendaY;
    }

    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    public String getListaNombre() {
        return listaNombre;
    }

    public void setListaNombre(String listaNombre) {
        this.listaNombre = listaNombre;
    }

    public String getListaCorreo() {
        return listaCorreo;
    }

    public void setListaCorreo(String listaCorreo) {
        this.listaCorreo = listaCorreo;
    }

}