package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.Account;
import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.services.CuentaService;
import edu.eci.cosw.cheapestPrice.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * Created by Julian David Devia Serna on 2/20/17.
 */

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    ItemService is;
    @Autowired
    CuentaService cs;

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<?> getItems(@PathVariable int id){
        try {
            //verificar que se esté solicitando con el id de un usuario que exista
            cs.load(id);
            return new ResponseEntity<>(is.loadItems(), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{id}/products" )
    public ResponseEntity<?> getProducts(@PathVariable int id){
        try {
            //verificar que se esté solicitando con el id de un usuario que exista
            cs.load(id);
            return new ResponseEntity<>(is.getProducts(), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{id}/categories" )
    public ResponseEntity<?> getCategories(@PathVariable int id){
        try {
            //verificar que se esté solicitando con el id de un usuario que exista
            cs.load(id);
            return new ResponseEntity<>(is.loadCategories(), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{id}/shop/{shop}/item/{idItem}")
    public ResponseEntity<?> getItemShop(@PathVariable int id,@PathVariable int shop,@PathVariable int idItem){
        try {
            //verificar que se esté solicitando con el id de un usuario que exista
            cs.load(id);
            return new ResponseEntity<>(is.loadItem(shop,idItem), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{id}/shop/{shop}/items")
    public ResponseEntity<?> getItemsShop(@PathVariable int id, @PathVariable int shop){
        try {
            //verificar que se esté solicitando con el id de un usuario que exista
            cs.load(id);
            return new ResponseEntity<>(is.loadItemByShop(shop), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{id}/items/category/{category}")
    public ResponseEntity<?> getItemsCategory(@PathVariable int id, @PathVariable String category){
        try {
            cs.load(id);
            return new ResponseEntity<>(is.loadItemsByCategory(category), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{id}/items/{idItem}")
    public ResponseEntity<?> getItemById(@PathVariable int id, @PathVariable int idItem){
        try {
            cs.load(id);
            return new ResponseEntity<>(is.loadItemById(idItem), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{id}/shop/{shop}/item/{idItem}" ,method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteItem(@PathVariable int id,@PathVariable int shop,@PathVariable int idItem){
        try {
            Item item=is.loadItemById(idItem);
            int idshop=item.getTienda().getId();
            int user=item.getTienda().getTendero().getUsuarioId();
            Account acc=cs.load(id);
            if(id==user && idshop==shop) {
                is.deleteItem(shop,idItem);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }else{
                System.out.println("Acceso denegado id:"+acc.getId()+" rol: "+acc.getRol());
                return new ResponseEntity<>(new CheapestPriceException("Acceso denegado"),HttpStatus.FORBIDDEN);
            }
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{id}/shop/{shop}/item/{idItem}",method = RequestMethod.PUT)
    public ResponseEntity<?> updateItem(@RequestBody Item item,@PathVariable int id,@PathVariable int shop){
        try {
            int idshop=item.getTienda().getId();
            int user=item.getTienda().getTendero().getUsuarioId();
            Account acc=cs.load(id);
            if(id==user && idshop==shop) {
                is.updateItem(item);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }else{
                System.out.println("Acceso denegado id:"+acc.getId()+" rol: "+acc.getRol());
                return new ResponseEntity<>(new CheapestPriceException("Acceso denegado"),HttpStatus.FORBIDDEN);
            }
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

///No tocar ... excepto si es Hugo!

    @RequestMapping(value = "/{id}/shop/{shop}/items", method = RequestMethod.POST)
    public ResponseEntity uploadFile(@PathVariable int id,@PathVariable int shop,@RequestPart(value = "items") Item items,@RequestPart(value = "files", required = false) MultipartFile files) {
        try {

            int idshop=items.getTienda().getId();
            int user=items.getTienda().getTendero().getUsuarioId();
            Account acc=cs.load(id);
            if(id==user && idshop==shop) {
                if(files != null){
                    Blob imagen = new SerialBlob(StreamUtils.copyToByteArray(files.getInputStream()));
                    Producto p =items.getProducto();
                    p.setImagen(imagen);
                    items.setProducto(p);
                    is.addItem(items);
                }else{
                    is.addItem(items);
                }
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }else{
                System.out.println("Acceso denegado id:"+acc.getId()+" rol: "+acc.getRol());
                return new ResponseEntity<>(new CheapestPriceException("Acceso denegado"),HttpStatus.FORBIDDEN);
            }

        }
        catch (Exception e) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{id}/shop/{shop}/item/{idItem}/imagen")
    public ResponseEntity<?> getPictureById(@PathVariable int id,@PathVariable int shop,@PathVariable int idItem) {
        try {
            Item items = is.loadItemById(idItem);
            int idshop = items.getTienda().getId();
            Account acc=cs.load(id);
            if (idshop == shop) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("image/png"))
                        .body(new InputStreamResource(items.getProducto().getImagen().getBinaryStream()));
            }else{
                System.out.println("El item "+idItem+" no pertenece a la tienda especificada "+shop+" "+idshop);
                System.out.println(items+" "+items.getTienda()+" "+items.getTienda().getId());
                return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
            }
        } catch (CheapestPriceException | SQLException | NullPointerException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="/{idProducto}/imagen")
    public ResponseEntity<?> getPictureById(@PathVariable long idProducto) {
        try {
            Producto pro = is.loadProductById(idProducto);
            return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType("image/png"))
                        .body(new InputStreamResource(pro.getImagen().getBinaryStream()));
        }catch (CheapestPriceException | SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
    Post sin imagen
    @RequestMapping(value="/{id}/shop/{shop}/items" ,method = RequestMethod.POST)
    public ResponseEntity<?> postItem(@RequestBody Item item,@PathVariable int id,@PathVariable int shop){
        try {
            int idshop=item.getTienda().getId();
            int user=item.getTienda().getTendero().getId();
            Account acc=cs.load(id);
            if(id==user && idshop==shop) {
                is.addItem(item);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>(new CheapestPriceException("Acceso denegado"),HttpStatus.FORBIDDEN);
            }
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
    */
}
