package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.services.CuentaService;
import edu.eci.cosw.cheapestPrice.services.ShopService;
import edu.eci.cosw.cheapestPrice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by 2105684 on 5/3/17.
 */
@RestController
public class LoginController {
    @Autowired
    CuentaService cs;
    @Autowired
    UserService uP;
    @Autowired
    ShopService serviceShop;

    @RequestMapping(value="/api/login",method = RequestMethod.POST)
    public ResponseEntity<?> agregarCuenta(@RequestBody CuentaPass cuenta){
        try{
            System.out.println("intento: "+cuenta.getEmail());
            return new ResponseEntity<>(cs.login(cuenta),HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.POST,value = "/api/user/reg")
    public ResponseEntity<?> agregarUsuario(@RequestBody Usuario usuario){
        try{
            System.out.println("recibido: "+usuario.getId()+" "+usuario.getNombre()+" "+usuario.getCorreo());
            uP.addUser(usuario);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.POST, value = "/api/tendero/reg")
    public ResponseEntity<?> agregarTendero(@RequestBody Tendero tendero){
        try{
            uP.addTendero(tendero);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value ="/api/tienda/reg" ,method = RequestMethod.POST)
    public ResponseEntity<?> addShop(@RequestBody Tienda tienda){
        ResponseEntity a;
        try {
            serviceShop.addTienda(tienda);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda creada sin error");
        } catch (CheapestPriceException ex) {
            ex.printStackTrace();
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(value="/api/cuenta/reg",method = RequestMethod.POST)
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
