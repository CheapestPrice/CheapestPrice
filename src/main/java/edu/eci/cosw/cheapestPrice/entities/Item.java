package edu.eci.cosw.cheapestPrice.entities;

/**
 * Created by Julian David Devia Serna on 2/19/17.
 */
public class Item {
    private Tienda tienda;
    private Producto producto;

    public Item(){};

    public Item(Tienda tienda,Producto producto){
        this.producto=producto;
        this.tienda=tienda;
    }

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
}