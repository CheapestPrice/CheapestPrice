package edu.eci.cosw.cheapestPrice.entities;

/**
 * Created by Paula on 21/02/2017.
 */
public class Tendero extends Usuario {

    private String tienda;

    public Tendero(String nombre,String correo, String nickname){
        super(nombre,correo);
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

}
