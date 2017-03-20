package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by amoto on 3/20/17.
 */
@Embeddable
public class HorarioId implements Serializable {
    @Column(name = "dia",nullable = false,insertable = false,updatable = false)
    private String dia;

    @Column(name = "TIENDAS_nit",nullable = false,insertable = false,updatable = false)
    private String tiendaNit;

    @Column(name = "TIENDAS_x",nullable = false,insertable = false,updatable = false)
    private double tiendaX;

    @Column(name = "TIENDAS_y",nullable = false,insertable = false,updatable = false)
    private double tiendaY;

    public HorarioId(){}

    public HorarioId(String dia, String nit, double x, double y){
        this.setDia(dia);
        this.setTiendaNit(nit);
        this.setTiendaX(x);
        this.setTiendaY(y);
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTiendaNit() {
        return tiendaNit;
    }

    public void setTiendaNit(String tiendaNit) {
        this.tiendaNit = tiendaNit;
    }

    public double getTiendaX() {
        return tiendaX;
    }

    public void setTiendaX(double tiendaX) {
        this.tiendaX = tiendaX;
    }

    public double getTiendaY() {
        return tiendaY;
    }

    public void setTiendaY(double tiendaY) {
        this.tiendaY = tiendaY;
    }
}
