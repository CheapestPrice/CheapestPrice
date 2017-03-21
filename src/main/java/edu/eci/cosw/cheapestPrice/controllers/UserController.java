package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import edu.eci.cosw.cheapestPrice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ger9410 on 21/02/17.
 */
@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    UserService uP;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarios(){
        return new ResponseEntity<>(uP.loadAllUsuarios(), HttpStatus.ACCEPTED);
    }
    //{correo:.+}
    @RequestMapping(value="/{correo:.+}" ,method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarioPorCorreo(@PathVariable String correo){
        try{
            return new ResponseEntity<>(uP.loadUserByEmail(correo),HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> agregarUsuario(@RequestBody Usuario usuario){
        try{
            uP.addUser(usuario);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{correo:.+}" ,method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarUsuario(@PathVariable String correo, Usuario usuario){
        System.out.println(usuario.getCorreo());
        try{
            uP.updateUser(correo, usuario);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{correo:.+}/{listaNombre}" ,method = RequestMethod.DELETE)
    public ResponseEntity<?> borrarListaMercado(@PathVariable String correo, @PathVariable String listaNombre){
        try{
            uP.deleteShoppingList(correo,listaNombre);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }


}
