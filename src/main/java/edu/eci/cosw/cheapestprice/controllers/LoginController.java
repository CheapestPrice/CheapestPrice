package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Cuenta;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.services.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 2105684 on 5/3/17.
 */
@RestController
public class LoginController {
    @Autowired
    CuentaService cs;
    @RequestMapping(value="/api/login",method = RequestMethod.POST)
    public ResponseEntity<?> agregarCuenta(@RequestBody Cuenta cuenta){
        try{
            //Consultar que el usuario exista
            //retornar el usuario con su rol y su id
            cs.agregarCuenta(cuenta);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
}
