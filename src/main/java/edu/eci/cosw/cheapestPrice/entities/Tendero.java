package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Paula on 21/02/2017.
 */
@Entity
@Table(name="TENDEROS")
public class Tendero extends Usuario implements Serializable {

    private double tiendaX;
    private double tiendaY;
    private String tiendaNit;

    public Tendero(String nombre,String correo, double tiendaX,double tiendaY,String tiendaNIT){
        super(nombre,correo);
        this.setTiendaX(tiendaX);
        this.setTiendaY(tiendaY);
        this.setTiendaNit(tiendaNIT);
    }

    @Column(name = "TIENDAS_x",nullable = false,insertable = false,updatable = false)
    public double getTiendaX() {
        return tiendaX;
    }

    public void setTiendaX(double tiendaX) {
        this.tiendaX = tiendaX;
    }

    @Column(name = "TIENDAS_y",nullable = false,insertable = false,updatable = false)
    public double getTiendaY() {
        return tiendaY;
    }

    public void setTiendaY(double tiendaY) {
        this.tiendaY = tiendaY;
    }

    @Column(name = "TIENDAS_nit",nullable = false,insertable = false,updatable = false)
    public String getTiendaNit() {
        return tiendaNit;
    }

    public void setTiendaNit(String tiendaNit) {
        this.tiendaNit = tiendaNit;
    }
}
