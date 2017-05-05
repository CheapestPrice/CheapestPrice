package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.*;
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
    public void updateUser(int correo, Usuario usuario) throws CheapestPriceException {
        us.updateUser(correo,usuario);
    }

    @Override
    public void deleteShoppingList(int id) throws CheapestPriceException {
        us.deleteShoppingList(id);
    }

    @Override
    public void favoriteShoppingListItem(int itemListaId, long productoId,int tiendaId,boolean fav) throws CheapestPriceException {
        us.favoriteShoppingListItem(itemListaId,productoId,tiendaId,fav);
    }

    @Override
    public void deleteSelectedItem(int id) throws CheapestPriceException {
        us.deleteSelectedItem(id);
    }

    @Override
    public void sellSelectedItem(int itemListaId, long idProducto, int tiendaId, boolean comp) throws CheapestPriceException {
        us.sellSelectedItem(itemListaId,idProducto,tiendaId,comp);
    }

    @Override
    public void addShoppingList(ListaDeMercado listaDeMercado) throws CheapestPriceException {
        us.addShoppingList(listaDeMercado);
    }

    @Override
    public void addItemListaMercado(ItemLista itemLista) throws CheapestPriceException {
        us.addItemListaMercado(itemLista);
    }

    @Override
    public void addCuenta(Cuenta cuenta) throws CheapestPriceException {
        us.addCuenta(cuenta);
    }

    @Override
    public void addTendero(Tendero tendero)throws CheapestPriceException {
        us.addTendero(tendero);
    }

    @Override
    public List<Tendero> loadAllTenderos() {
        return us.loadAllTenderos();
    }
}
