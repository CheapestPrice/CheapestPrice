package edu.eci.cosw.cheapestPrice.entities;

/**
 * Created by Paula on 21/02/2017.
 */
public class Tendero extends Usuario {

    private String tienda;

    public Tendero(String nombre,String email, String nickname){
        super(nombre,email,nickname);
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

}
