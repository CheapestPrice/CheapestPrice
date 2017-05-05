package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.services.CuentaService;
import edu.eci.cosw.cheapestPrice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 2105684 on 5/3/17.
 */
@RestController
public class LoginController {
    @Autowired
    CuentaService cs;
    @Autowired
    UserService uP;
    @RequestMapping(value="/api/login",method = RequestMethod.POST)
    public ResponseEntity<?> agregarCuenta(@RequestBody CuentaPass cuenta){
        try{
            return new ResponseEntity<>(cs.login(cuenta),HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.POST,value = "/{id}")
    public ResponseEntity<?> agregarUsuario(@RequestBody Usuario usuario, @PathVariable int id){
        try{
            cs.load(id);
            uP.addUser(usuario);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.POST, value = "/{id}/tendero")
    public ResponseEntity<?> agregarTendero(@RequestBody Tendero tendero, @PathVariable int id){
        try{
            //verificar que se esté solicitando con el id de un usuario que exista y sea un tendero
            Account acc=cs.load(id);
            if(acc.getRol().equals(Account.TENDERO)) {
                uP.addTendero(tendero);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>(new CheapestPriceException("Acceso denegado"),HttpStatus.FORBIDDEN);
            }


        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
}
