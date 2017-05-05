package edu.eci.cosw.cheapestPrice.entities;

import java.io.Serializable;

/**
 * Created by amoto on 5/4/17.
 */
public class Cuenta implements Serializable {

    private int id;

    private String rol;

    public Cuenta(int id, String rol){
        this.setId(id);
        this.setRol(rol);
    }

    public Cuenta(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
