package edu.eci.cosw.cheapestPrice.persistence.hibernate;

import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import edu.eci.cosw.cheapestPrice.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Created by masterhugo on 3/18/17.
 */
@Service
public class UserPersistenceHibernate implements UserPersistence{
    @Autowired
    UserRepository us;
    @Autowired
    ShoppingListRepository slR;
    @Autowired
    ItemListRepository ilR;
    @Autowired
    CuentaRepository cr;
    @Autowired
    TenderoRepository tr;


    @Override
    public List<Usuario> loadAllUsuarios() {

        return us.loadAllUsers();
    }


    @Override
    public List<ListaDeMercado> loadShopListByEmail(String correo) throws CheapestPriceException {
        return us.loadShoppingListByUserEmail(correo);
    }

    @Override
    public Usuario loadUserByEmail(String correo) throws CheapestPriceException {
      return  us.loadUserByEmail(correo);
    }


    @Override
    public void addUser(Usuario usuario) throws CheapestPriceException {
        us.save(usuario);
    }

    @Override
    public void updateUser(int oldEmail, Usuario usuario) throws CheapestPriceException {
        us.delete(oldEmail);
        us.save(usuario);
    }

    @Override
    public void deleteShoppingList(int id) throws CheapestPriceException {
        slR.delete(id);
    }

    @Override
    public void favoriteShoppingListItem(int itemListaId , long idProducto,int id,boolean fav) throws CheapestPriceException {
        ilR.favoriteItemSelected(itemListaId,idProducto,id,fav);
    }

    @Override
    public void deleteSelectedItem(int id) throws CheapestPriceException {
        ilR.delete(id);
    }

    @Override
    public void sellSelectedItem(int itemListaId, long idProducto, int id, boolean comp) throws CheapestPriceException {
        ilR.sellItemSelected(itemListaId,idProducto,id,comp);
    }

    @Override
    public void addShoppingList(ListaDeMercado listaDeMercado) throws CheapestPriceException {
        slR.save(listaDeMercado);
    }

    @Override
    public void addItemListaMercado(ItemLista itemLista) {
        ilR.save(itemLista);
    }

    @Override
    public void addCuenta(Cuenta cuenta) {
        cr.save(cuenta);
    }

    @Override
    public void addTendero(Tendero tendero) {
        tr.save(tendero);
    }

    @Override
    public List<Tendero> loadAllTenderos() {
        return tr.findAll();
    }
}
