package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Paula on 20/02/2017.
 */
@RestController
@RequestMapping("/usuario")
public class UserController {
    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        return user;
    }
    @Autowired
    UserPersistence uP;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getListas(){
        return new ResponseEntity<>(uP.loadAllShopList(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarUsuario(Usuario usuario){
        try{
            uP.updateUser(usuario);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
}
