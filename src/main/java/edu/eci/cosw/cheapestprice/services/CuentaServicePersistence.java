package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Cuenta;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Paula on 20/03/2017.
 */
@Service
public class CuentaServicePersistence implements CuentaService{


    @Autowired
    CuentaRepository cr;

    @Override
    public void agregarCuenta(Cuenta cuenta) throws CheapestPriceException {
        cr.save(cuenta);
    }
}
