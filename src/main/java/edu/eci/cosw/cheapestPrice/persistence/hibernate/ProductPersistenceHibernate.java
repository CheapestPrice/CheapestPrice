package edu.eci.cosw.cheapestPrice.persistence.hibernate;

import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ProductPersistence;
import edu.eci.cosw.cheapestPrice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Blob;
import java.util.List;
import java.util.Set;

/**
 * Created by masterhugo on 2/16/17.
 */
public class ProductPersistenceHibernate implements ProductPersistence {

    @Autowired
    ProductRepository pr;

    @Override
    public List<Producto> loadProducts() {
        return pr.findAll();
    }

    @Override
    public Producto loadProductById(long id) throws CheapestPriceException {
        return pr.findOne(id);
    }

    @Override
    public List<Producto> loadAllProductsByName(String name) throws CheapestPriceException {
        return pr.loadProductsByName(name);
    }

    @Override
    public List<Producto> loadAllProductsByTrademark(String marca) throws CheapestPriceException {
        return pr.loadProductsByMarca(marca);
    }

    @Override
    public List<Producto> loadAllProductsByCategory(String categoria) throws CheapestPriceException {
        return pr.loadProductsByCategoria(categoria);
    }

    @Override
    public void addProduct(Producto producto) throws CheapestPriceException {
        pr.save(producto);
    }

    @Override
    public void updateProductByMarca(Producto producto, String marca) throws CheapestPriceException {
        pr.updateByMarca(producto,marca);
    }

    @Override
    public void updateProductByCategoria(Producto producto, String categoria) throws CheapestPriceException {
        pr.updateByCategoria(producto, categoria);
    }

    @Override
    public void updateProductByName(Producto producto, String name) throws CheapestPriceException {
        pr.updateByName(producto, name);
    }

    @Override
    public void updateProductByImage(Producto producto, Blob image) throws CheapestPriceException {
        pr.updateByImage(producto, image);
    }

    @Override
    public void deleteProduct(Producto producto) throws CheapestPriceException {
        pr.delete(producto);
    }
}
