package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Tienda;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.SQLException;
import java.util.Iterator;
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


    @RequestMapping(method = RequestMethod.GET, value="/{id}/items")
    public ResponseEntity<?> loadItems(@PathVariable int id)  {
        try {
            return new ResponseEntity<>(serviceShop.loadItems(id), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}/item/{idproducto}")
    public ResponseEntity<?> loadItem(@PathVariable int id,@PathVariable long idproducto)  {
        try {
            return new ResponseEntity<>(serviceShop.loadItem(id,idproducto), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/{id}/logo")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getShopLogo(@PathVariable int id) {
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("image/png"))
                    .body(new InputStreamResource(serviceShop.consultTienda(id).getLogo().getBinaryStream()));
        } catch (CheapestPriceException ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (SQLException ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}/item/{idproducto}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id,@PathVariable long idproducto){
        ResponseEntity a;
        try {
            serviceShop.deleteProduct(id, idproducto);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Product eliminada sin error");
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

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> modifyShop(@PathVariable int id,@RequestBody Tienda tienda){
        ResponseEntity a;
        try {
            serviceShop.modifyTienda(id, tienda);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda actualizada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}/telephone")
    public ResponseEntity<?> modifyShopTelephone(@PathVariable int id,@RequestBody String tel){
        ResponseEntity a;
        try {
            serviceShop.modifyTelephone(id, tel);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda actualizada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/{id}/logo")
    public ResponseEntity uploadLogo(MultipartHttpServletRequest request, @PathVariable int id ) {
        try {
            Iterator<String> itr = request.getFileNames();

            while (itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                Tienda tienda= serviceShop.consultTienda(id);
                tienda.setLogo(new SerialBlob(StreamUtils.copyToByteArray(file.getInputStream())));
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<?> getShop(@PathVariable int id){
        try {
            return new ResponseEntity<>(serviceShop.consultTienda(id),HttpStatus.ACCEPTED);
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
    }


}

