package edu.eci.cosw.cheapestPrice.entities;

/**
 * Created by Julian David Devia Serna on 2/19/17.
 */
public class Tienda {
    private String direccion;
    private double x;
    private double y;
    private String nombre;
    private String nit;
    private String telefono;
    private boolean disponible;
    private byte[] logo;

    public Tienda(){};

    public Tienda(String direccion,double x,double y,String nombre,String nit,String telefono, boolean disponible){
        this.direccion=direccion;
        this.x=x;
        this.y=y;
        this.nombre=nombre;
        this.nit=nit;
        this.telefono=telefono;
        this.disponible=disponible;
    }

    public Tienda(String direccion,double x,double y,String nombre,String nit,String telefono, boolean disponible,byte[] logo){
        this.direccion=direccion;
        this.x=x;
        this.y=y;
        this.nombre=nombre;
        this.nit=nit;
        this.telefono=telefono;
        this.disponible=disponible;
        this.logo=logo;
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

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
}
