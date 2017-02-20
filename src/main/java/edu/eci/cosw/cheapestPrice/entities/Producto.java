package edu.eci.cosw.cheapestPrice.entities;

/**
 * Created by masterhugo on 2/16/17.
 */
public class Producto {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
