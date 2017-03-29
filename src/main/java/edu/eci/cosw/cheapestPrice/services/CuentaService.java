package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Cuenta;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;

/**
 * Created by Paula on 20/03/2017.
 */
public interface CuentaService {

    Cuenta Login(String email, String hash) throws CheapestPriceException;

    public void agregarCuenta(Cuenta cuenta) throws CheapestPriceException;
}
