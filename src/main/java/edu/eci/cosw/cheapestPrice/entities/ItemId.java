package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

/**
 * Created by 2105684 on 3/17/17.
 */
@Embeddable
public class ItemId implements Serializable{

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

    @Column(name = "TIENDAS_nit",nullable = false)
    private String tiendaNit;

    @Column(name = "TIENDAS_x",nullable = false)
    private double tiendaX;

    @Column(name = "TIENDAS_y",nullable = false)
    private double tiendaY;


    @Column(name = "PRODUCTOS_id",nullable = false)
    private long productoId;

    public ItemId(){}

    public ItemId( long producto){
        //this.tiendaId=tienda;
        this.productoId=producto;
    }

    public ItemId(long productoId,double tiendaX,double tiendaY, String tiendaNit){
        this.productoId=productoId;
        this.tiendaX=tiendaX;
        this.tiendaY=tiendaY;
        this.tiendaNit=tiendaNit;
    }

    /*public TiendaId getTiendaId() {
        return tiendaId;
    }

    public void setTiendaId(TiendaId tienda) {
        this.tiendaId = tienda;
    }*/


    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long producto) {
        this.productoId = producto;
    }

    /*@Override
    public boolean equals(Object o){
        ItemId oi=(ItemId) o;
        return tiendaId.equals(oi.getTiendaId()) && productoId.equals(oi.getProductoId());
    }

    @Override
    public String toString(){
        return "->Tienda: "+tienda+"\nProducto: "+producto+"\n";
    }*/
}
