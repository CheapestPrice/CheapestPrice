package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import edu.eci.cosw.cheapestPrice.services.CuentaService;
import edu.eci.cosw.cheapestPrice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ger9410 on 21/02/17.
 */
@RestController
@RequestMapping("/api/usuarios")
public class UserController {
    @Autowired
    UserService uP;
    @Autowired
    CuentaService cs;

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<?> getUsuarios(@PathVariable int id){
        try {
            //verificar que se esté solicitando con el id de un usuario que exista
            cs.load(id);
            return new ResponseEntity<>(uP.loadAllUsuarios(), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e, HttpStatus.ACCEPTED);
        }


    }
    @RequestMapping(method = RequestMethod.GET,value="/{id}/tenderos")
    public ResponseEntity<?> getTenderos(@PathVariable int id){
        try {
            //verificar que se esté solicitando con el id de un usuario que exista y sea un tendero
            Account acc=cs.load(id);
            if(acc.getRol().equals(Account.TENDERO)) {
                return new ResponseEntity<>(uP.loadAllTenderos(), HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>(new CheapestPriceException("Acceso denegado"),HttpStatus.FORBIDDEN);
            }
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e, HttpStatus.ACCEPTED);
        }
    }
    @RequestMapping(value="/{id}/me" ,method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarioPorCorreo(@PathVariable int id){
        try{
            return new ResponseEntity<>(uP.loadUser(id),HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }



    @RequestMapping(value="/{id}" ,method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarUsuario(@PathVariable int id, Usuario usuario){
        System.out.println(usuario.getCorreo());
        try{
            //verificar que se esté solicitando con el id de un usuario que exista y sea el mismo que quiere modificar
            Account acc=cs.load(id);
            if(id==usuario.getId()) {
                uP.updateUser(id, usuario);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>(new CheapestPriceException("Acceso denegado"),HttpStatus.FORBIDDEN);
            }
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{id}/lista/{listaId}" ,method = RequestMethod.DELETE)
    public ResponseEntity<?> borrarListaMercado(@PathVariable int id, @PathVariable int listaId){
        try{
            //verificar que se esté solicitando con el id de un usuario que exista y sea el dueño de la lista
            Account acc=cs.load(id);
            ListaDeMercado l=uP.loadListaUsuario(id, listaId);
            if(l!=null) {
                uP.deleteShoppingList(listaId);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>(new CheapestPriceException("La lista no pertenece al usuario"),HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value="/{id}/lista/{listaId}/item/{itemListaId}/favorite/{fav}" ,method = RequestMethod.PUT)
    public ResponseEntity<?> favoritoItemUsuario(@PathVariable int id, @PathVariable int listaId,@PathVariable int itemListaId,@PathVariable boolean fav){
        try{
            Account acc=cs.load(id);
            ListaDeMercado l=uP.loadListaUsuario(id,listaId);
            if(l!=null) {

                uP.favoriteShoppingListItem(itemListaId,fav);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity<>(new CheapestPriceException("La lista no pertenece al usuario"),HttpStatus.NOT_FOUND);
            }
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
