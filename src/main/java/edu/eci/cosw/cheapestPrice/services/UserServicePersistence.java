package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;
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
    @Autowired
    ShopPersistence sp;


    @Override
    public List<Usuario> loadAllUsuarios() {
        return us.loadAllUsuarios();
    }

    @Override
    public List<ListaDeMercado> loadShopListByEmail(String email) throws CheapestPriceException {
        return us.loadShopListByEmail(email);
    }

    @Override
    public List<ListaDeMercado> loadShopList(int id) throws CheapestPriceException {
        return us.loadShopList(id);
    }

    @Override
    public Usuario loadUserByEmail(String correo) throws CheapestPriceException {
        return us.loadUserByEmail(correo);
    }

    @Override
    public Usuario loadUser(int id) throws CheapestPriceException {
        return us.load(id);
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
        System.out.println("servicio: "+id);
        us.deleteShoppingList(id);
    }

    @Override
    public void favoriteShoppingListItem(int itemListaId,boolean fav) throws CheapestPriceException {
        us.favoriteShoppingListItem(itemListaId,fav);
    }

    @Override
    public void deleteSelectedItem(int id) throws CheapestPriceException {
        us.deleteSelectedItem(id);
    }

    @Override
    public void sellSelectedItem(int itemListaId, boolean comp) throws CheapestPriceException {
        us.sellSelectedItem(itemListaId,comp);
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
        Usuario u = us.loadUserByEmail(tendero.getUsuario().getCorreo());
        Tienda tmp = tendero.getTienda();
        Tienda t = sp.consultTienda(tmp.getNit(),tmp.getX(),tmp.getY(),tmp.getDireccion(),tmp.getNombre(),tmp.getTelefono());
        tendero.setTiendaid(t.getId());
        tendero.setUsuarioId(u.getId());
        tendero.setTienda(null);
        tendero.setUsuario(null);
        us.addTendero(tendero);
    }

    @Override
    public List<Tendero> loadAllTenderos() {
        return us.loadAllTenderos();
    }

    @Override
    public ListaDeMercado loadListaUsuario(int uId, int lId) {
        return us.loadListaUsuario(uId, lId);
    }

    @Override
    public Tendero loadTendero(int userId) {
        return us.loadTendero(userId);
    }
}
