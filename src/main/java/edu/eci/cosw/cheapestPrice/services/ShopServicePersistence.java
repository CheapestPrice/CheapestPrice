package edu.eci.cosw.cheapestPrice.services;

import com.mysql.jdbc.Blob;
import edu.eci.cosw.cheapestPrice.entities.Horario;
import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Opinion;
import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by daniela on 18/03/17.
 */
public class ShopServicePersistence implements ShopService {

    private ItemService itemService;
    private ProductService productService;
    private ShopPersistence persistence;

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
}
