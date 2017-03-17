package edu.eci.cosw.cheapestPrice.entities;

import java.util.List;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Embeddable;
/*
* Created by Julian Devia .
*/
@Embeddable
public class TenderoId implements java.io.Serializable  {

    private String nit;
    private double x;
    private double y;

    public TenderoId(){

    };

    public TenderoId(String nit, double x, double y){
        this.setX(x);
        this.setY(y);
        this.setNit(nit);
    }

    @Column(name="TIENDA_nit", nullable=false)
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    @Column(name="TIENDA_x", nullable=false)
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    @Column(name="TIENDA_y", nullable=false)
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