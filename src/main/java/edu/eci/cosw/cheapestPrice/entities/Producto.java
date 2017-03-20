package edu.eci.cosw.cheapestPrice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;

/**
 * Created by masterhugo on 2/16/17.
 */

@Entity
@Table(name="PRODUCTOS")
public class Producto implements Serializable {
    @Column(name="nombre")
    private String nombre;
    @Column(name = "marca")
    private String marca;
    @Column(name="categoria")
    private String categoria;
    @Column(name="imagen")
    @JsonIgnore
    private Blob imagen;
    @GeneratedValue
    @Id
    private long id;

    public Producto(long id, String nombre,String marca, String categoria){
        this.id=id;
        this.nombre=nombre;
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

    public Blob getImagen() {
        return imagen;
    }

    public void setImagen(Blob imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o){
        Producto op=(Producto) o;
        return op.getNombre().equals(nombre) && op.getCategoria().equals(categoria) && op.getMarca().equals(marca);
    }
    @Override
    public String toString(){
        return "id: "+id+" categoria: "+categoria+" nombre: "+nombre+" marca: "+marca;
    }
}