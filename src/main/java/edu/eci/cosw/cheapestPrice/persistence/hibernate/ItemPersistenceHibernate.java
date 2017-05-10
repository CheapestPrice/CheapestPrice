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
    public List<Item> loadItemByShop(int tiendaId) throws CheapestPriceException {
        return ir.loadItemsByShop(tiendaId);
    }

    @Override
    public List<Item> loadItemsByCategory(String category) throws CheapestPriceException {
        return ir.loadItemsByCategory(category);
    }

    @Override
    public Item loadItemById(int id) throws CheapestPriceException {
        return ir.findOne(id);
    }

    @Override
    public void addItem(Item item) throws CheapestPriceException {
        Producto p= (Producto) pr.loadProduct(item.getProducto().getNombre(),item.getProducto().getMarca(),item.getProducto().getCategoria());
        if(p==null)
            pr.save(p);
        ir.save(item);
    }

    @Override
    public void deleteItem(int idShop,int idItem) throws CheapestPriceException {
        ir.delete(idItem);
    }

    @Override
    public void updateItem(Item item) throws CheapestPriceException {
        ir.delete(item.getId());
        ir.save(item);
    }

    @Override
    public void updateProductImage(Blob imagen, String nombre, String marca, String categoria) throws CheapestPriceException {
        pr.updateByImage(nombre,marca,categoria,imagen);
    }

    @Override
    public List<Producto> getProducts() {
        return pr.findAll();
    }

    @Override
    public Item loadItem(int shop, int idItem) throws CheapestPriceException {
        return ir.loadItem(shop,idItem);
    }

    @Override
    public List<String> loadCategories() {
        return ir.loadCategories();
    }

    @Override
    public Producto loadProductById(long idProducto) {
        return pr.findOne(idProducto);
    }
}
