package edu.eci.cosw.cheapestPrice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Julian David Devia Serna on 2/19/17.
 */
@Entity
@Table(name = "ITEMS")
public class Item implements Serializable {

    @Id
    private int id;

    @Column(name="precio")
    private long precio;

    //@MapsId("tiendaId")
    @ManyToOne(cascade=CascadeType.ALL,optional=false)
    @JoinColumns({
            @JoinColumn(name="TIENDAS_id", referencedColumnName="id", nullable=false,insertable=false, updatable=false)
    })
    private Tienda tienda;

    //@MapsId("productoId")
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name="PRODUCTOS_id", referencedColumnName="id", nullable=false, insertable=false,updatable=false)
    })
    private Producto producto;

    public Item(){};

    public Item(int id){
        this.id=id;
    }

    public Item(Producto producto,Tienda tienda,long precio,int id){
        this.producto=producto;
        this.tienda=tienda;
        this.precio=precio;
        this.id=id;
    }

    public Item(Producto producto,Tienda tienda,int id){
        this.producto=producto;
        this.tienda=tienda;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
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
    public String toString() {
        return "["+tienda.getNit()+ " "+ tienda.getX() + " " + tienda.getY() + " "+producto.getId() +" "+precio+"]";
    }
}