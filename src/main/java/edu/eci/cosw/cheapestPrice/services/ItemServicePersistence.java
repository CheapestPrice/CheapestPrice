package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ItemPersistence;
//import edu.eci.cosw.cheapestPrice.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.List;

/**
 * Created by Julian David Devia Serna on 2/20/17.
 */
@Service
public class ItemServicePersistence implements ItemService{

    @Autowired
    private ItemPersistence ip;

    public ItemServicePersistence(){}

    @Override
    public List<Item> loadItems() {
        return ip.loadItems();
    }

    @Override
    public Item loadItem(int shop, int idItem) throws CheapestPriceException {
        return ip.loadItem(shop,idItem);
    }

    @Override
    public List<Item> loadItemByShop(int tiendaId) throws CheapestPriceException {
        return ip.loadItemByShop(tiendaId);
    }

    @Override
    public List<Item> loadItemsByCategory(String category) throws CheapestPriceException {
        return ip.loadItemsByCategory(category);
    }

    @Override
    public Item loadItemById(int id) throws CheapestPriceException {
        return ip.loadItemById(id);
    }

    @Override
    public Producto loadProductById(long id) throws CheapestPriceException {
        return ip.loadProductById(id);
    }

    @Override
    public void addItem(Item item) throws CheapestPriceException {
        ip.addItem(item);
    }

    @Override
    public void deleteItem(int idShop, int idItem) throws CheapestPriceException {
        ip.deleteItem(idShop,idItem);
    }

    @Override
    public void updateItem(Item item) throws CheapestPriceException {
        ip.updateItem(item);
    }

    @Override
    public void updateProductImage(Blob imagen, String nombre, String marca, String categoria) throws CheapestPriceException {
        ip.updateProductImage(imagen, nombre, marca, categoria);
    }

    @Override
    public List<Producto> getProducts() {
        return ip.getProducts();
    }
}
