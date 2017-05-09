package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Account;
import edu.eci.cosw.cheapestPrice.entities.Tienda;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.services.CuentaService;
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
@RequestMapping("/api/tiendas")
public class ShopController {

    @Autowired
    ShopService serviceShop;

    @Autowired
    CuentaService cs;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/shop/{shop}/logo")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getShopLogo(@PathVariable int id,@PathVariable int shop) {
        try {
            cs.load(id);
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


    @RequestMapping(method = RequestMethod.GET, value = "/{id}/shop/{shop}/opiniones")
    @ResponseBody
    public ResponseEntity<?> getOpiniones(@PathVariable int id,@PathVariable int shop) {
        int ids=0;
        try {
            Account acc=cs.load(id);
            ids=acc.getId();
            return new ResponseEntity <>(serviceShop.consultOpiniones(shop),HttpStatus.ACCEPTED);
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(new CheapestPriceException("Error autenticando el usuario: "+ids));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/shop/{shopId}")
    public ResponseEntity<?> modifyShop(@PathVariable int id,@PathVariable int shopId,@RequestBody Tienda tienda){
        ResponseEntity a;
        try {
            cs.load(id);
            serviceShop.modifyTienda(shopId, tienda);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda actualizada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(new CheapestPriceException("OOPS! Error al actualizar tienda"));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/{id}/shop/{shop}/telephone")
    public ResponseEntity<?> modifyShopTelephone(@PathVariable int id,@PathVariable int shop,@RequestBody String tel){
        ResponseEntity a;
        try {
            cs.load(id);
            serviceShop.modifyTelephone(shop, tel);
            a = new ResponseEntity<>(HttpStatus.ACCEPTED);
            System.out.println("Tienda actualizada sin error");
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(new CheapestPriceException("OOPS! Error al actualizar el numero de telefono de la tienda"));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/{id}/shop/{shop}/logo")
    public ResponseEntity uploadLogo(MultipartHttpServletRequest request, @PathVariable int id ,@PathVariable int shop) {
        try {
            cs.load(id);
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

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/shop/{shopId}")
    public ResponseEntity<?> getShop(@PathVariable int id,@PathVariable int shopId){
        int ids=0;
        try {
            Account acc=cs.load(id);
            ids=acc.getId();
            return new ResponseEntity<>(serviceShop.consultTienda(id),HttpStatus.ACCEPTED);
        } catch (CheapestPriceException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(new CheapestPriceException("Error autenticando el usuario: "+ids));
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

