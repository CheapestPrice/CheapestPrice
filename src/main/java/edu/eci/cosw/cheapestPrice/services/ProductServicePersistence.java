package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ProductPersistence;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by masterhugo on 2/16/17.
 */
public class ProductServicePersistence implements ProductService {
    @Autowired
    ProductPersistence productoPersistence;

    public ProductServicePersistence() {

    }

    @Override
    public Set<Producto> getAllProducts() {
        return productoPersistence.loadProducts();
    }

    @Override
    public Producto getProductById(long id) throws CheapestPriceException {
        return productoPersistence.loadProductById(id);
    }

    @Override
    public Set<Producto> getAllProductsByName(String name) throws CheapestPriceException {
        return productoPersistence.loadAllProductsByName(name);
    }

    @Override
    public Set<Producto> getAllProductsByPrice(long price) throws CheapestPriceException {
        return productoPersistence.loadAllProductsByPrice(price);
    }

    @Override
    public Set<Producto> getAllProductsByTrademark(String marca) throws CheapestPriceException {
        return productoPersistence.loadAllProductsByTrademark(marca);
    }

    @Override
    public Set<Producto> getAllProductsByCategory(String categoria) throws CheapestPriceException {
        return productoPersistence.loadAllProductsByCategory(categoria);
    }

    @Override
    public void addProduct(Producto producto) throws CheapestPriceException {
        productoPersistence.addProduct(producto);
    }

    @Override
    public void updateProduct(Producto producto) throws CheapestPriceException {
        productoPersistence.updateProduct(producto);
    }

    @Override
    public void deleteProduct(Producto producto) throws CheapestPriceException {
        productoPersistence.deleteProduct(producto);
    }
}
