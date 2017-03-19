package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by masterhugo on 2/16/17.
 */

@Entity
@Table(name="PRODUCTOS")

public class Producto implements Serializable {

    private String nombre;
    private long precio;
    private String marca;
    private String categoria;
    private long id;

    public Producto(long id, String nombre, long precio, String marca, String categoria){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;
        this.marca=marca;
        this.categoria=categoria;
    }

    public Producto(){

    }

    @Column(name="nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name="precio")
    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    @Column(name = "marca")
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Column(name="categoria")
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @GeneratedValue
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o){
        Producto op=(Producto) o;
        return op.getNombre().equals(nombre) && op.getCategoria().equals(categoria) && op.getMarca().equals(marca) && op.getPrecio()==precio;
    }
    @Override
    public String toString(){
        return "id: "+id+" categoria: "+categoria+" nombre: "+nombre+" marca: "+marca+" precio: "+precio;
    }
}
