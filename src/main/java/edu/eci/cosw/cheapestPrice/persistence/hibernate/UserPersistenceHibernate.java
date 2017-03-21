package edu.eci.cosw.cheapestPrice.persistence.hibernate;

import edu.eci.cosw.cheapestPrice.entities.ItemListaId;
import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.ListaMercado_Item;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import edu.eci.cosw.cheapestPrice.repositories.ItemListRepository;
import edu.eci.cosw.cheapestPrice.repositories.ShopRepository;
import edu.eci.cosw.cheapestPrice.repositories.ShoppingListRepository;
import edu.eci.cosw.cheapestPrice.repositories.UserRepository;
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
        ListaMercado_Item lmI=new ListaMercado_Item(correo,nombreLista);
        slR.delete(lmI);
    }

    @Override
    public void favoriteShoppingListItem(String correo, String nombreLista, long idProducto, String nombreTienda) throws CheapestPriceException {
    }

    @Override
    public void deleteSelectedItem(String correo, String nombreLista, long idProducto, double x, double y, String nit) throws CheapestPriceException {
        ItemListaId iLId = new ItemListaId(correo,nombreLista,nit,x,y,idProducto);
        ilR.delete(iLId);
    }


}
