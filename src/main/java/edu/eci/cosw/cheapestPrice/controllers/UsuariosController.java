package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ger9410 on 21/02/17.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    UserPersistence uP;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarios(){
        return new ResponseEntity<>(uP.loadAllUsuarios(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/{nickname}" ,method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarioPorNickname(@PathVariable String nickname){
        try{
            return new ResponseEntity<>(uP.loadUsuarioByNickname(nickname), HttpStatus.ACCEPTED);
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
