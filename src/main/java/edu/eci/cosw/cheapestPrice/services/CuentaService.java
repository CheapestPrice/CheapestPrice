package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Account;
import edu.eci.cosw.cheapestPrice.entities.Cuenta;
import edu.eci.cosw.cheapestPrice.entities.CuentaPass;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;

/**
 * Created by Paula on 20/03/2017.
 */
public interface CuentaService {


    public void agregarCuenta(Cuenta cuenta) throws CheapestPriceException;

    public Account login(CuentaPass cuenta) throws CheapestPriceException;

    public Account load(int id) throws CheapestPriceException;
}
