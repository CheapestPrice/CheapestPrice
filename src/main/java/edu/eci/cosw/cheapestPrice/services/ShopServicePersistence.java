package edu.eci.cosw.cheapestPrice.services;

import com.mysql.jdbc.Blob;
import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Daniela on 18/03/17.
 */
@Service
public class ShopServicePersistence implements ShopService {

    private ItemService itemService;
    @Autowired
    private ShopPersistence persistence;

    @Override
    public void addTienda(Tienda tienda) throws CheapestPriceException {

    }

    @Override
    public void modifyTienda(TiendaId id, Tienda tienda) throws CheapestPriceException {

    }

    @Override
    public List<Item> loadItems() {
        return null;
    }

    @Override
    public Item loadItem(long id) throws CheapestPriceException {
        return null;
    }

    @Override
    public void addProduct(Producto producto) throws CheapestPriceException {

    }

    @Override
    public void deleteProduct(long idproducto) throws CheapestPriceException {

    }

    @Override
    public void modifyProduct(long idproducto, Producto producto) throws CheapestPriceException {

    }

    @Override
    public void modifyHorary(String dia, Horario horario) throws CheapestPriceException {

    }

    @Override
    public void modifyTelephone(String telefono) throws CheapestPriceException {

    }

    @Override
    public boolean isOpen(Timestamp fecha) throws CheapestPriceException {
        return false;
    }

    @Override
    public void addOpinion(Opinion opinion) throws CheapestPriceException {

    }

    @Override
    public void modifyLogo(Blob logo) throws CheapestPriceException {

    }

    @Override
    public Tienda getTienda(String nickname) throws CheapestPriceException {
        return null;
    }
}
