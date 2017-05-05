package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Cuenta;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import edu.eci.cosw.cheapestPrice.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Paula on 20/02/2017.
 */
@RestController
public class UserLoginController {

   @Autowired
    CuentaService cs;

    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value="/cuenta",method = RequestMethod.POST)
    public ResponseEntity<?> agregarCuenta(@RequestBody Cuenta cuenta){
        try{
            cs.agregarCuenta(cuenta);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

}
