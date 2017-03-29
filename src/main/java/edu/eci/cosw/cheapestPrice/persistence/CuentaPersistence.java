package edu.eci.cosw.cheapestPrice.persistence;

import edu.eci.cosw.cheapestPrice.entities.Cuenta;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;

/**
 * Created by Paula on 20/03/2017.
 */
public interface CuentaPersistence {

    Cuenta Login(String email, String hash) throws CheapestPriceException;

    public void addCuentaTendero(Cuenta cuenta) throws CheapestPriceException;

    public void addCuentaUsuario(Cuenta cuenta) throws CheapestPriceException;
}
