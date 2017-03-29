package edu.eci.cosw.cheapestPrice.persistence.hibernate;

import edu.eci.cosw.cheapestPrice.entities.Cuenta;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.CuentaPersistence;
import edu.eci.cosw.cheapestPrice.repositories.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Paula on 20/03/2017.
 */
@Service
public class CuentaPersistenceHibernate implements CuentaPersistence {

    @Autowired
    CuentaRepository cr;

    @Override
    public Cuenta Login(String email, String hash) throws CheapestPriceException {
        return cr.Login(email,hash);
    }

    @Override
    public void addCuentaTendero(Cuenta cuenta) throws CheapestPriceException {
        cr.save(cuenta);

    }

    @Override
    public void addCuentaUsuario(Cuenta cuenta) throws CheapestPriceException{
        cr.save(cuenta);
    }
}
