package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by 2105403 on 3/14/17.
 */
@Embeddable
public class ItemLista_Item {

    private long productoId;
    private Double tiendaX;
    private Double tiendaY;
    private String tiendaNit;

    public ItemLista_Item(){}

    public ItemLista_Item(long productoId,Double tiendaX,Double tiendaY,String tiendaNit){
        this.setProductoId(productoId);
        this.setTiendaX(tiendaX);
        this.setTiendaY(tiendaY);
        this.setTiendaNit(tiendaNit);
    }

    @Column(name="PRODUCTOS_id")
    public long getProductoId() {
        return productoId;
    }

    public void setProductoId(long productoId) {
        this.productoId = productoId;
    }

    @Column(name="TIENDAS_x")
    public Double getTiendaX() {
        return tiendaX;
    }

    public void setTiendaX(Double tiendaX) {
        this.tiendaX = tiendaX;
    }

    @Column(name="TIENDAS_y")
    public Double getTiendaY() {
        return tiendaY;
    }

    public void setTiendaY(Double tiendaY) {
        this.tiendaY = tiendaY;
    }

    @Column(name="TIENDAS_nit")
    public String getTiendaNit() {
        return tiendaNit;
    }

    public void setTiendaNit(String tiendaNit) {
        this.tiendaNit = tiendaNit;
    }
}
