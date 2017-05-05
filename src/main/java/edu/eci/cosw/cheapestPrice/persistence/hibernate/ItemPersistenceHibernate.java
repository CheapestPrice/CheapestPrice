package edu.eci.cosw.cheapestPrice.persistence.hibernate;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ItemPersistence;
import edu.eci.cosw.cheapestPrice.repositories.ItemRepository;
import edu.eci.cosw.cheapestPrice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.List;

/**
 * Created by masterhugo on 3/20/17.
 */
@Service
public class ItemPersistenceHibernate implements ItemPersistence {

    @Autowired
    private ItemRepository ir;
    @Autowired
    private ProductRepository pr;

    @Override
    public List<Item> loadItems() {
        return ir.findAll();
    }

    @Override
    public Item loadItem(String shopName, long id) throws CheapestPriceException {
        return null;
    }

    @Override
    public List<Item> loadItemByShop(int tiendaId) throws CheapestPriceException {
        return ir.loadItemsByShop(tiendaId);
    }

    @Override
    public List<Item> loadItemByCategory(String category) throws CheapestPriceException {
        return null;
    }

    @Override
    public List<Item> loadItemById(long id) throws CheapestPriceException {
        return null;
    }

    @Override
    public Producto loadProductById(long id) throws CheapestPriceException {
        return pr.findOne(id);
    }

    @Override
    public void addItem(Item item) throws CheapestPriceException {
        ir.save(item);
    }

    @Override
    public void deleteItem(String shopName, long id) throws CheapestPriceException {

    }

    @Override
    public void updateItem(long oldId, String oldShop, Item item) throws CheapestPriceException {

    }

    @Override
    public void updateProductImage(Blob imagen, String nombre, String marca, String categoria) throws CheapestPriceException {
        pr.updateByImage(nombre,marca,categoria,imagen);
    }

    @Override
    public List<Producto> getProducts() {
        return pr.findAll();
    }
}
