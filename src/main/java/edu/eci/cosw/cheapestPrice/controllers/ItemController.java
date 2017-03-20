package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * Created by Julian David Devia Serna on 2/20/17.
 */
@RestController
@RequestMapping(value = "/items")
public class ItemController {
    @Autowired
    ItemService is;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getItems(){
        return new ResponseEntity<>(is.loadItems(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET,value="/shop/{shop}/id/{id}")
    public ResponseEntity<?> getItem(@PathVariable String shop,@PathVariable long id){
        try {
            return new ResponseEntity<>(is.loadItem(shop,id),HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/shop/{shopName}")
    public ResponseEntity<?> getItemsShop(@PathVariable String shopName){
        try {
            return new ResponseEntity<>(is.loadItemByShop(shopName), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/category/{category}")
    public ResponseEntity<?> getItemsCategory(@PathVariable String category){
        try {
            return new ResponseEntity<>(is.loadItemByCategory(category), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{id}")
    public ResponseEntity<?> getItemsId(@PathVariable long id){
        try {
            return new ResponseEntity<>(is.loadItemById(id), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{id}/imagen")
    public ResponseEntity<?> getPictureById(@PathVariable long id){
        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("image/png"))
                    .body(new InputStreamResource(  is.loadProductById(id).getImagen().getBinaryStream()     ));
        } catch (CheapestPriceException | SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> postItem(@RequestBody Item item){
        try {
            is.addItem(item);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.PUT,value="/shop/{oldShop}/id/{oldId}")
    public ResponseEntity<?> putItem(@RequestBody Item item,@PathVariable long oldId,@PathVariable String oldShop){
        try {
            is.updateItem(oldId,oldShop,item);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/shop/{shop}/id/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable String shop,@PathVariable long id){
        try {
            is.deleteItem(shop,id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
}
