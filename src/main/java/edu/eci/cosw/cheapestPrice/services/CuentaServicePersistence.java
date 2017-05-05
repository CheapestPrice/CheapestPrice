package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Account;
import edu.eci.cosw.cheapestPrice.entities.Cuenta;
import edu.eci.cosw.cheapestPrice.entities.CuentaPass;
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

    @Override
    public Account login(CuentaPass cuenta) throws CheapestPriceException {
        Cuenta acc=cr.Login(cuenta.getEmail(),cuenta.getHash());
        if(acc==null){
            throw new  CheapestPriceException("El usuario o la contraseña son incorrectos");
        }
        return new Account(acc.getId(),acc.getRol());
    }

    @Override
    public Account load(int id) throws CheapestPriceException {
        Cuenta acc=cr.findOne(id);
        if(acc==null){
            throw new  CheapestPriceException("El usuario no se encuentra registrado");
        }
        return new Account(acc.getId(),acc.getRol());
    }
}
