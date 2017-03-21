package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Tienda;
import edu.eci.cosw.cheapestPrice.entities.TiendaId;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;
import edu.eci.cosw.cheapestPrice.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Daniela on 19/02/2017.
 */
@RestController
@RequestMapping("/tiendas")
public class ShopController {

    @Autowired
    public ShopService serviceShop;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getShops()  {
        try {
            return new ResponseEntity<>(serviceShop.consultShop(), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/x/{x}/y/{y}/nit/{nit}")
    public ResponseEntity<?> getShop(@PathVariable double x,@PathVariable double y,@PathVariable String nit)  {
        try {
            TiendaId id=new TiendaId(nit,x,y);
            return new ResponseEntity<>(serviceShop.consultTienda(id), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/x/{x:.+}/y/{y:.+}/nit/{nit:-+}/items")
    public ResponseEntity<?> loadItems(@PathVariable double x,@PathVariable double y,@PathVariable String nit)  {
        try {
            TiendaId id=new TiendaId(nit,x,y);
            return new ResponseEntity<>(serviceShop.loadItems(id), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/x/{x}/y/{y}/nit/{nit}/item/{idproducto}")
    public ResponseEntity<?> loadItem(@PathVariable double x,@PathVariable double y,@PathVariable String nit,@PathVariable long idproducto)  {
        try {
            TiendaId id=new TiendaId(nit,x,y);
            return new ResponseEntity<>(serviceShop.loadItem(id,idproducto), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> modifyShop(@RequestBody Tienda tienda){
        ResponseEntity a;
        try {
            TiendaId id=tienda.getId();
            serviceShop.modifyTienda(id, tienda);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda actualizada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/telephone/{tel}")
    public ResponseEntity<?> modifyShopTelephone(@RequestBody Tienda tienda,@PathVariable String tel){
        ResponseEntity a;
        try {
            TiendaId id=tienda.getId();
            serviceShop.modifyTelephone(id, tel);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda actualizada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/logo/{tel}")
    public ResponseEntity<?> modifyShopLogo(@RequestBody Tienda tienda){
        ResponseEntity a;
        try {
            TiendaId id=tienda.getId();
            serviceShop.modifyLogo(id, tienda.getLogo());
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda actualizada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addShop(@RequestBody Tienda tienda){
        ResponseEntity a;
        try {
            serviceShop.addTienda(tienda);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda creada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteShop(@RequestBody Tienda tienda){
        ResponseEntity a;
        try {
            serviceShop.deleteTienda(tienda);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda eliminada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/producto/{idproducto}")
    public ResponseEntity<?> deleteProduct(@RequestBody Tienda tienda,@PathVariable long idproducto){
        ResponseEntity a;
        try {
            TiendaId id=tienda.getId();
            serviceShop.deleteProduct(id, idproducto);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Product eliminada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

}

