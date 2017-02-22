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

/**
 * Created by ger9410 on 21/02/17.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    UserPersistence uP;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getListas(){
        return new ResponseEntity<>(uP.loadAllShopList(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarUsuario(String oldNickname, Usuario usuario){
        try{
            uP.updateUser(oldNickname, usuario);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
}
