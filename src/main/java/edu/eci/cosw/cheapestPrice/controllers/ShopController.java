package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.entities.Tienda;
import edu.eci.cosw.cheapestPrice.entities.TiendaId;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;
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


    @RequestMapping(method = RequestMethod.GET, value="/x/{x}/y/{y}/nit/{nit}/items")
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
            //TiendaId id=new TiendaId(nit,x,y);
            return new ResponseEntity<>(serviceShop.loadItem(nit,x,y,idproducto), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/x/{x}/y/{y}/nit/{nit}/logo")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getShopLogo(@PathVariable double x,@PathVariable double y,@PathVariable String nit) {
        try {
            TiendaId id=new TiendaId(nit,x,y);
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

    @RequestMapping(method = RequestMethod.DELETE,value = "/x/{x}/y/{y}/nit/{nit}/item/{idproducto}")
    public ResponseEntity<?> deleteProduct(@PathVariable double x,@PathVariable double y,@PathVariable String nit,@PathVariable long idproducto){
        ResponseEntity a;
        try {
            TiendaId id=new TiendaId(nit,x,y);
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

    @RequestMapping(method = RequestMethod.PUT, value = "/x/{x}/y/{y}/nit/{nit}")
    public ResponseEntity<?> modifyShop(@PathVariable double x,@PathVariable double y,@PathVariable String nit,@RequestBody Tienda tienda){
        ResponseEntity a;
        try {
            TiendaId id=new TiendaId(nit,x,y);
            serviceShop.modifyTienda(id, tienda);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda actualizada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/x/{x}/y/{y}/nit/{nit}/telephone")
    public ResponseEntity<?> modifyShopTelephone(@PathVariable double x,@PathVariable double y,@PathVariable String nit,@RequestBody String tel){
        ResponseEntity a;
        try {
            TiendaId id=new TiendaId(nit,x,y);
            serviceShop.modifyTelephone(id, tel);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda actualizada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Oops! Un error a ocurrido!",HttpStatus.NOT_ACCEPTABLE);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/x/{x}/y/{y}/nit/{nit}/logo")
    public ResponseEntity uploadLogo(MultipartHttpServletRequest request, @PathVariable double x,@PathVariable double y,@PathVariable String nit ) {
        try {
            Iterator<String> itr = request.getFileNames();

            while (itr.hasNext()) {
                String uploadedFile = itr.next();
                MultipartFile file = request.getFile(uploadedFile);
                TiendaId id=new TiendaId(nit,x,y);
                Tienda tienda= serviceShop.consultTienda(id);
                tienda.setLogo(new SerialBlob(StreamUtils.copyToByteArray(file.getInputStream())));
            }
        }
        catch (Exception e) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

}

