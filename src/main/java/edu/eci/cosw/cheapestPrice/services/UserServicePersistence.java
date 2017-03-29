package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.ItemLista;
import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 2105403 on 3/17/17.
 */
@Service
public class UserServicePersistence implements UserService{
    @Autowired
    UserPersistence us;


    @Override
    public List<Usuario> loadAllUsuarios() {
        return us.loadAllUsuarios();
    }

    @Override
    public List<ListaDeMercado> loadShopListByEmail(String email) throws CheapestPriceException {
        return us.loadShopListByEmail(email);
    }

    @Override
    public Usuario loadUserByEmail(String correo) throws CheapestPriceException {
        return us.loadUserByEmail(correo);
    }

    @Override
    public void addUser(Usuario usuario) throws CheapestPriceException {
        us.addUser(usuario);
    }

    @Override
    public void updateUser(String correo, Usuario usuario) throws CheapestPriceException {
        us.updateUser(correo,usuario);
    }

    @Override
    public void deleteShoppingList(String correo, String nombreLista) throws CheapestPriceException {
        us.deleteShoppingList(correo,nombreLista);
    }

    @Override
    public void favoriteShoppingListItem(String correo, String nombreLista, long productoId,double x,double y,String nit,boolean fav) throws CheapestPriceException {
        us.favoriteShoppingListItem(correo,nombreLista,productoId,x,y,nit,fav);
    }

    @Override
    public void deleteSelectedItem(String correo, String nombreLista, long idProducto, double x, double y, String nit) throws CheapestPriceException {
        us.deleteSelectedItem(correo,nombreLista,idProducto,x,y,nit);
    }

    @Override
    public void sellSelectedItem(String correo, String nombreLista, long idProducto, double x, double y, String nit, boolean comp) throws CheapestPriceException {
        us.sellSelectedItem(correo,nombreLista,idProducto,x,y,nit,comp);
    }

    @Override
    public void addShoppingList(ListaDeMercado listaDeMercado) throws CheapestPriceException {
        us.addShoppingList(listaDeMercado);
    }

    @Override
    public void addItemListaMercado(ItemLista itemLista) throws CheapestPriceException {
        us.addItemListaMercado(itemLista);
    }
}
