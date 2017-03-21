package edu.eci.cosw.cheapestPrice.persistence.stub;

import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ProductPersistence;

import java.sql.Blob;
import java.util.List;
import java.util.Set;

/**
 * Created by masterhugo on 2/16/17.
 */
public class ProductPersistenceStub implements ProductPersistence {

    @Override
    public List<Producto> loadProducts() {
        return null;
    }

    @Override
    public Producto loadProductById(long id) throws CheapestPriceException {
        return null;
    }

    @Override
    public List<Producto> loadAllProductsByName(String name) throws CheapestPriceException {
        return null;
    }

    @Override
    public List<Producto> loadAllProductsByTrademark(String marca) throws CheapestPriceException {
        return null;
    }

    @Override
    public List<Producto> loadAllProductsByCategory(String categoria) throws CheapestPriceException {
        return null;
    }

    @Override
    public void addProduct(Producto producto) throws CheapestPriceException {

    }

    @Override
    public void updateProductByMarca(Producto producto, String marca) throws CheapestPriceException {
        
    }

    @Override
    public void updateProductByCategoria(Producto producto, String categoria) throws CheapestPriceException {

    }

    @Override
    public void updateProductByName(Producto producto, String name) throws CheapestPriceException {

    }

    @Override
    public void updateProductByImage(Producto producto, Blob image) throws CheapestPriceException {

    }

    @Override
    public void deleteProduct(Producto producto) throws CheapestPriceException {

    }
}
