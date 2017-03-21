package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ProductPersistence;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Blob;
import java.util.List;
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
    public List<Producto> getAllProducts() {
        return productoPersistence.loadProducts();
    }

    @Override
    public Producto getProductById(long id) throws CheapestPriceException {
        return productoPersistence.loadProductById(id);
    }

    @Override
    public List<Producto> getAllProductsByName(String name) throws CheapestPriceException {
        return productoPersistence.loadAllProductsByName(name);
    }

    @Override
    public List<Producto> getAllProductsByTrademark(String marca) throws CheapestPriceException {
        return productoPersistence.loadAllProductsByTrademark(marca);
    }

    @Override
    public List<Producto> getAllProductsByCategory(String categoria) throws CheapestPriceException {
        return productoPersistence.loadAllProductsByCategory(categoria);
    }

    @Override
    public void addProduct(Producto producto) throws CheapestPriceException {
        productoPersistence.addProduct(producto);
    }

    @Override
    public void updateProductByMarca(Producto producto, String marca) throws CheapestPriceException {
        productoPersistence.updateProductByMarca(producto,marca);
    }

    @Override
    public void updateProductByCategoria(Producto producto, String categoria) throws CheapestPriceException {
        productoPersistence.updateProductByCategoria(producto, categoria);
    }

    @Override
    public void updateProductByName(Producto producto, String name) throws CheapestPriceException {
        productoPersistence.updateProductByName(producto, name);
    }

    @Override
    public void updateProductByImage(Producto producto, Blob image) throws CheapestPriceException {
        productoPersistence.updateProductByImage(producto, image);
    }

    @Override
    public void deleteProduct(Producto producto) throws CheapestPriceException {
        productoPersistence.deleteProduct(producto);
    }
}
