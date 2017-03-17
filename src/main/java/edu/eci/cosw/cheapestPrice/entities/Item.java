package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Julian David Devia Serna on 2/19/17.
 */
//@Entity
//@Table(name = "ITEMS")
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

    @Override
    public boolean equals(Object o){
        Item oi=(Item) o;
        return tienda.equals(oi.getTienda()) && producto.equals(oi.getProducto());
    }

    @Override
    public String toString(){
        return "->Tienda: "+tienda+"\nProducto: "+producto+"\n";
    }
}
