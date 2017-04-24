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
    public void updateUser(String oldEmail, Usuario usuario) throws CheapestPriceException {
        us.delete(oldEmail);
        us.save(usuario);
    }

    @Override
    public void deleteShoppingList(String correo, String nombreLista) throws CheapestPriceException {
        ListaMercado_Item lmI=new ListaMercado_Item(nombreLista,correo);
        slR.delete(lmI);
    }

    @Override
    public void favoriteShoppingListItem(String correo, String nombreLista, long idProducto,double x,double y,String nit,boolean fav) throws CheapestPriceException {
        ilR.favoriteItemSelected(correo,nombreLista,idProducto,x,y,nit,fav);
    }

    @Override
    public void deleteSelectedItem(String correo, String nombreLista, long idProducto, double x, double y, String nit) throws CheapestPriceException {
        ItemListaId iLId = new ItemListaId(correo,nombreLista,nit,x,y,idProducto);
        ilR.delete(iLId);
    }

    @Override
    public void sellSelectedItem(String correo, String nombreLista, long idProducto, double x, double y, String nit, boolean comp) throws CheapestPriceException {
        ilR.sellItemSelected(correo,nombreLista,idProducto,x,y,nit,comp);
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
}
