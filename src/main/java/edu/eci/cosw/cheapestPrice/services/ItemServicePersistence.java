package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ItemPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Item loadItem(String shopName, long id) throws CheapestPriceException {
        return ip.loadItem(shopName,id);
    }

    @Override
    public List<Item> loadItemByShop(String shopName) throws CheapestPriceException {
        return ip.loadItemByShop(shopName);
    }

    @Override
    public List<Item> loadItemByCategory(String category) throws CheapestPriceException {
        return ip.loadItemByCategory(category);
    }

    @Override
    public List<Item> loadItemById(long id) throws CheapestPriceException {
        return ip.loadItemById(id);
    }

    @Override
    public void addItem(Item item) throws CheapestPriceException {
        ip.addItem(item);
    }

    @Override
    public void deleteItem(String shopName, long id) throws CheapestPriceException {
        ip.deleteItem(shopName,id);
    }

    @Override
    public void updateItem(long oldId, String oldShop, Item item) throws CheapestPriceException {
        ip.updateItem(oldId,oldShop,item);
    }
}
