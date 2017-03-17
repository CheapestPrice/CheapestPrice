package edu.eci.cosw.cheapestPrice.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Paula on 21/02/2017.
 */
@Entity
@Table(name="TENDEROS")
public class Tendero extends Usuario {

    private TenderoId tienda;

    public Tendero(String nombre,String correo, TenderoId tienda){
        super(nombre,correo);
        setTienda(tienda);
    }

    @EmbeddedId
    public TenderoId getTienda() {
        return tienda;
    }

    public void setTienda(TenderoId tienda) {
        this.tienda = tienda;
    }

}
