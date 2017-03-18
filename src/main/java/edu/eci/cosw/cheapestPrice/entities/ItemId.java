package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by 2105684 on 3/17/17.
 */
@Embeddable
public class ItemId implements Serializable{
    @OneToOne
    @JoinColumns({
            @JoinColumn(name="TIENDAS_nit", referencedColumnName="nit", nullable=false),
            @JoinColumn(name="TIENDAS_x", referencedColumnName="x", nullable=false),
            @JoinColumn(name="TIENDAS_y", referencedColumnName="y", nullable=false)
    })
    private Tienda tienda;
    @OneToOne
    @JoinColumns({
            @JoinColumn(name="PRODUCTOS_id", referencedColumnName="id", nullable=false)
    })
    private Producto producto;


    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o){
        ItemId oi=(ItemId) o;
        return tienda.equals(oi.getTienda()) && producto.equals(oi.getProducto());
    }

    @Override
    public String toString(){
        return "->Tienda: "+tienda+"\nProducto: "+producto+"\n";
    }
}
