package edu.eci.cosw.cheapestPrice.entities;

import java.util.List;
import java.util.Map;

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
    private byte[] logo;
    private Map<String,Horario> horarios;

    public Tendero tendero;

    public Tienda(){};

    public Tienda(String direccion,double x,double y,String nombre,String nit,String telefono, boolean disponible) {
        this.direccion = direccion;
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.disponible = disponible;
    }


    public Tienda(String direccion,double x,double y,String nombre,String nit,String telefono, boolean disponible,byte[] logo) {
        this.direccion = direccion;
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.disponible = disponible;
        this.logo = logo;
    }

    public Tienda(String direccion,String nombre,String nit,String telefono, Tendero tendero){
        this.direccion = direccion;
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
        this.tendero=tendero;
        this.disponible=true;
    }

    public void mnodificarHorario(String dia, Horario horario){
        horarios.put(dia,horario);
    }

    public void setHorario(Map<String,Horario> hor){
        this.horarios=hor;
    }

    public Map<String,Horario> getHorario(){
        return this.horarios;
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

    @Override
    public boolean equals(Object o){
        Tienda ot=(Tienda) o;
        return direccion.equals(ot.getDireccion()) && nombre.equals(ot.getNombre()) && nit.equals(ot.getNit()) && telefono.equals(ot.getTelefono()) && x==ot.getX() && y==ot.getY();
    }

    @Override
    public String toString(){
        return "nombre: "+nombre+" direccion: "+direccion+" telefono: "+telefono+" NIT: "+nit;
    }

    public Tendero getTendero() {
        return tendero;
    }

    public void setTendero(Tendero tendero) {
        this.tendero = tendero;
    }
}
