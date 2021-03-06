package edu.eci.cosw.cheapestPrice.controllers;

import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.services.CuentaService;
import edu.eci.cosw.cheapestPrice.services.ShoppingListService;
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

    @Autowired
    ShoppingListService sls;

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<?> getUsuarios(@PathVariable int id){
        try {
            //verificar que se esté solicitando con el id de un usuario que exista
            cs.load(id);
            return new ResponseEntity<>(uP.loadAllUsuarios(), HttpStatus.ACCEPTED);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
                System.out.println("Acceso denegado id:"+acc.getId()+" rol: "+acc.getRol());
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
    }
    @RequestMapping(method = RequestMethod.GET,value="/{id}/tendero/{userId}")
    public ResponseEntity<?> getTenderos(@PathVariable int id,@PathVariable int userId){
        try {
            //verificar que se esté solicitando con el id de un usuario que exista y sea un tendero
            Account acc=cs.load(id);
            if(acc.getRol().equals(Account.TENDERO)) {
                return new ResponseEntity<>(uP.loadTendero(userId), HttpStatus.ACCEPTED);
            }else{
                System.out.println("Acceso denegado id:"+acc.getId()+" rol: "+acc.getRol());
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (CheapestPriceException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
    }
    /*@RequestMapping(value="/{correo:.+}/me" ,method = RequestMethod.GET)
    public ResponseEntity<?> getUsuarioPorCorreo(@PathVariable String correo){
        try{
            return new ResponseEntity<>(uP.loadUserByEmail(correo),HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }*/

    @RequestMapping(value="/me/{id}" ,method = RequestMethod.GET)
    public ResponseEntity<?> getUsuario(@PathVariable int id){
        try{
            return new ResponseEntity<>(uP.loadUser(id),HttpStatus.ACCEPTED);
        }catch (CheapestPriceException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
                System.out.println("Acceso denegado id:"+acc.getId()+" rol: "+acc.getRol());
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{id}/lista/{listaId}" ,method = RequestMethod.DELETE)
    public ResponseEntity<?> borrarListaMercado(@PathVariable int id, @PathVariable int listaId){
        try{
            //verificar que se esté solicitando con el id de un usuario que exista y sea el dueño de la lista
            System.out.println("------->>>>>Entro al delete: "+id+" "+listaId);
            Account acc=cs.load(id);
            ListaDeMercado l=uP.loadListaUsuario(id, listaId);
            if(l!=null) {
                System.out.println("lista no nula");
                uP.deleteShoppingList(listaId);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }else{
                System.out.println(new CheapestPriceException("La lista no pertenece al usuario"));
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value="/{id}/lista/{listaId}/item/{itemListaId}/favorite/{fav}" ,method = RequestMethod.PUT)
    public ResponseEntity<?> favoritoItemUsuario(@PathVariable int id, @PathVariable int listaId,@PathVariable int itemListaId,@PathVariable boolean fav){
        try{
            Account acc=cs.load(id);
            ListaDeMercado l=uP.loadListaUsuario(id,listaId);
            if(l!=null) {
                ItemLista il=sls.loadItemListaByLista(listaId,itemListaId);
                if(il!=null) {
                    uP.favoriteShoppingListItem(itemListaId, fav);
                    return new ResponseEntity<>(HttpStatus.ACCEPTED);
                }else{
                    System.out.println(new CheapestPriceException("El producto no pertenece a la lista"));
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }else{
                System.out.println(new CheapestPriceException("La lista no pertenece al usuario"));
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{id}/lista/{listaId}/item/{idItem}" ,method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarItemSeleccionado(@PathVariable int id, @PathVariable int listaId,@PathVariable int idItem){
        try{
            Account acc=cs.load(id);
            ListaDeMercado l=uP.loadListaUsuario(id,listaId);
            if(l!=null) {
                ItemLista il = sls.loadItemListaByLista(listaId, idItem);
                if (il != null) {
                    uP.deleteSelectedItem(idItem);
                    return new ResponseEntity<>(HttpStatus.ACCEPTED);
                } else {
                    System.out.println(new CheapestPriceException("El producto no pertenece a la lista"));
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }else{
                System.out.println(new CheapestPriceException("La lista no pertenece al usuario"));
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{id}/lista/{lId}/item/{ILId}/comprado/{com}" ,method = RequestMethod.PUT)
    public ResponseEntity<?> compradoItemUsuario(@PathVariable int id, @PathVariable int lId,@PathVariable int ILId,@PathVariable boolean com){
        try{
            Account acc=cs.load(id);
            ListaDeMercado l=uP.loadListaUsuario(id,lId);
            if(l!=null) {
                ItemLista il=sls.loadItemListaByLista(lId,ILId);
                if(il!=null) {
                    uP.sellSelectedItem(ILId,com);
                    return new ResponseEntity<>(HttpStatus.ACCEPTED);
                }else{
                    System.out.println(new CheapestPriceException("El producto no pertenece a la lista"));
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }else{
                System.out.println(new CheapestPriceException("La lista no pertenece al usuario"));
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (CheapestPriceException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{id}/lista" ,method = RequestMethod.POST)
    public ResponseEntity<?> agregarListaMercado(@RequestBody ListaDeMercado listaDeMercado, @PathVariable int id){
        try{
            cs.load(id);
            Account acc=cs.load(id);
            listaDeMercado.setUsuario(uP.loadUser(id));
            uP.addShoppingList(listaDeMercado);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);


        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="{id}/lista/{lId}" ,method = RequestMethod.POST)
    public ResponseEntity<?> agregarItemListaMercado(@RequestBody ItemLista itemLista, @PathVariable int id,@PathVariable int lId){
        try{
            Account acc=cs.load(id);
            ListaDeMercado l=uP.loadListaUsuario(id,lId);
            if(l!=null) {
                uP.addItemListaMercado(itemLista);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }else{
                System.out.println(new CheapestPriceException("La lista no pertenece al usuario"));
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
