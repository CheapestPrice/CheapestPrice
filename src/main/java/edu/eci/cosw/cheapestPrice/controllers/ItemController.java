package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(method = RequestMethod.GET,value="/shop/{shopName}")
    public ResponseEntity<?> getItemsShop(@PathVariable String shopName){
        try {
            return new ResponseEntity<>(is.loadItemByShop(shopName), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
