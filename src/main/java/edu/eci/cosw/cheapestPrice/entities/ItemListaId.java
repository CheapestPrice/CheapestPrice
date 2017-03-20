package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by 2105684 on 3/17/17.
 */
@Embeddable
public class ItemListaId implements Serializable {

    /**
     * @return the tiendaNit
     */
    public String getTiendaNit() {
        return tiendaNit;
    }

    /**
     * @param tiendaNit the tiendaNit to set
     */
    public void setTiendaNit(String tiendaNit) {
        this.tiendaNit = tiendaNit;
    }

    /**
     * @return the tiendaX
     */
    public double getTiendaX() {
        return tiendaX;
    }

    /**
     * @param tiendaX the tiendaX to set
     */
    public void setTiendaX(double tiendaX) {
        this.tiendaX = tiendaX;
    }

    /**
     * @return the tiendaY
     */
    public double getTiendaY() {
        return tiendaY;
    }

    /**
     * @param tiendaY the tiendaY to set
     */
    public void setTiendaY(double tiendaY) {
        this.tiendaY = tiendaY;
    }

    /**
     * @return the productoId
     */
    public long getProductoId() {
        return productoId;
    }

    /**
     * @param productoId the productoId to set
     */
    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    /**
     * @return the listaNombre
     */
    public String getListaNombre() {
        return listaNombre;
    }

    /**
     * @param listaNombre the listaNombre to set
     */
    public void setListaNombre(String listaNombre) {
        this.listaNombre = listaNombre;
    }

    /**
     * @return the listaCorreo
     */
    public String getListaCorreo() {
        return listaCorreo;
    }

    /**
     * @param listaCorreo the listaCorreo to set
     */
    public void setListaCorreo(String listaCorreo) {
        this.listaCorreo = listaCorreo;
    }

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


}