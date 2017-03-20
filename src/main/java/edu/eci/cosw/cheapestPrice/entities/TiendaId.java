package edu.eci.cosw.cheapestPrice.entities;

import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Embeddable;
/*
* Clase TiendaId, identificador de la clase Tienda
* Created by Daniela .
*/
@Embeddable
public class TiendaId implements java.io.Serializable  {
    @Column(name="nit", nullable=false, insertable=false,updatable=false)
    private String nit;
    @Column(name="x", nullable=false ,insertable=false,updatable=false)
    private double x;
    @Column(name="y", nullable=false ,insertable=false,updatable=false)
    private double y;

    public TiendaId(){

    };

    public TiendaId(String nit, double x, double y){
        this.x=x;
        this.y=y;
        this.nit=nit;
    }



    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
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

    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( (other == null ) ) return false;
        if ( !(other instanceof TiendaId) ) return false;
        TiendaId castOther = ( TiendaId ) other;

        return (this.getNit().equals(castOther.getNit()))
                && (((this.getX() == castOther.getX()) && (this.getY() == castOther.getY())) || ((this.getY() != 0.0) && (castOther.getY() != 0.0) && (this.getX() != 0.0) && (castOther.getX() != 0.0) && this.getX()==castOther.getX() && this.getY()==castOther.getY()));
    }
}