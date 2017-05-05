package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import edu.eci.cosw.cheapestPrice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ger9410 on 21/02/17.
 */
@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    UserService uP;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarios(){
        return new ResponseEntity<>(uP.loadAllUsuarios(), HttpStatus.ACCEPTED);
    }
    @RequestMapping(method = RequestMethod.GET,value="/tenderos")
    public ResponseEntity<?> getTenderos(){
        return new ResponseEntity<>(uP.loadAllTenderos(), HttpStatus.ACCEPTED);
    }
    @RequestMapping(value="/{correo:.+}" ,method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarioPorCorreo(@PathVariable String correo){
        try{
            return new ResponseEntity<>(uP.loadUserByEmail(correo),HttpStatus.ACCEPTED);
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
    @RequestMapping(method = RequestMethod.POST, value = "/cuenta")
    public ResponseEntity<?> agregarCuenta(@RequestBody Cuenta cuenta){
        try{
            uP.addCuenta(cuenta);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(method = RequestMethod.POST, value = "/tendero")
    public ResponseEntity<?> agregarTendero(@RequestBody Tendero tendero){
        try{
            uP.addTendero(tendero);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{correo}" ,method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarUsuario(@PathVariable int correo, Usuario usuario){
        System.out.println(usuario.getCorreo());
        try{
            uP.updateUser(correo, usuario);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{correo:.+}/{listaNombre}" ,method = RequestMethod.DELETE)
    public ResponseEntity<?> borrarListaMercado(@PathVariable int correo, @PathVariable String listaNombre){
        try{
            uP.deleteShoppingList(correo);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value="/favorito/{itemListaId}/favorite/{fav}" ,method = RequestMethod.PUT)
    public ResponseEntity<?> favoritoItemUsuario(@PathVariable int itemListaId,@PathVariable boolean fav){
        try{
            uP.favoriteShoppingListItem(itemListaId,fav);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{correo}/{listaNombre}/{productoId}/id" ,method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarItemSeleccionado(@PathVariable int correo, @PathVariable String listaNombre,@PathVariable long productoId,@PathVariable int id){
        try{
            uP.deleteSelectedItem(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{itemListaId}/comprado/{comp}" ,method = RequestMethod.PUT)
    public ResponseEntity<?> eliminarItemSeleccionado(@PathVariable int itemListaId,@PathVariable boolean comp){
        try{
            uP.sellSelectedItem(itemListaId,comp);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/listaMercado" ,method = RequestMethod.POST)
    public ResponseEntity<?> agregarListaMercado(@RequestBody ListaDeMercado listaDeMercado){
        //System.out.println(correo+" "+listaNombre);
        try{
            uP.addShoppingList(listaDeMercado);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value="/itemlistamercado" ,method = RequestMethod.POST)
    public ResponseEntity<?> agregarItemListaMercado(@RequestBody ItemLista itemLista){
        System.out.println("ASDADASD AS ASD FDZ GDFSFS "+ itemLista);
        try{
            uP.addItemListaMercado(itemLista);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }



}
