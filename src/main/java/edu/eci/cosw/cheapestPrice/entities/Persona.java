package edu.eci.cosw.cheapestPrice.entities;

/**
 *
 * @author amoto
 */

public interface Persona {

    public abstract String getCorreo();

    public abstract String getNombre();

    public abstract int getId();

    public abstract void setId(int id);

    public abstract void setNombre(String nombre);

    public abstract void setCorreo(String nombre);


}