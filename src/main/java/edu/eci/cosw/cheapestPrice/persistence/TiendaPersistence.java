package edu.eci.cosw.cheapestPrice.persistence;

import edu.eci.cosw.cheapestPrice.entities.Tienda;

/**
 * Created by Paula on 19/02/2017.
 */
public interface TiendaPersistence {

    public void addTienda(Tienda tienda);

    public Tienda getTienda(String nickname);
}
