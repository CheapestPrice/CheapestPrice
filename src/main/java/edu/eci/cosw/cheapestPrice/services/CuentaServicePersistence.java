package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Cuenta;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.CuentaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Paula on 20/03/2017.
 */
@Service
public class CuentaServicePersistence implements CuentaService{

    @Autowired
    CuentaPersistence cp;


    @Override
    public Cuenta Login(String email, String hash) throws CheapestPriceException {
        return cp.Login(email,hash);
    }

    @Override
    public void agregarCuenta(Cuenta cuenta) throws CheapestPriceException {
        cp.addCuentaTendero(cuenta);
    }
}
