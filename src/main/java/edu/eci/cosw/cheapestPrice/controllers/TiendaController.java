package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Tienda;
import edu.eci.cosw.cheapestPrice.persistence.TiendaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Paula on 19/02/2017.
 */
@RestController
@RequestMapping("/tiendas")
public class TiendaController {

    @Autowired
    public TiendaPersistence tp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> newTiendaRecurso(@RequestBody Tienda tienda){
        ResponseEntity a;
        try {
            tp.addTienda(tienda);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda creada sin error");

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Tienda no creada!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(value = "/{nickname}", method = RequestMethod.GET)
    public ResponseEntity<?>obtenerTiendaPorNickname(@PathVariable String nickname){

        ResponseEntity a;
        try {
            //obtener datos que se enviarán a través del API
            a = new ResponseEntity<>(tp.getTienda(nickname),HttpStatus.ACCEPTED);

        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error no encontro tienda!",HttpStatus.NOT_FOUND);
        }
        return a;
    }
}

