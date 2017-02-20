package edu.eci.cosw.cheapestPrice.entities;

import java.util.List;

/**
 * Created by masterhugo on 2/19/17.
 */
public class Tienda {
    private String direccion;
    private double x;
    private double y;
    private String nombre;
    private String nit;
    private String telefono;
    private boolean disponible;
    private List<Horario> horarios;
    public Tienda(){

    }
    public Tienda(String nombre, double x, double y, String direccion, String nit, String telefono, boolean disponible){
        this.nombre=nombre;
        this.x=x;
        this.y=y;
        this.direccion=direccion;
        this.nit=nit;
        this.telefono=telefono;
        this.disponible=disponible;
    }

    public void agregarProducto(Producto producto){

    }
    public void modificarProducto(Producto producto){

    }
    public void eliminarProducto(Producto producto){

    }
    public void mnodificarHorario(String dia, Horario horario){

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
