package edu.eci.cosw.cheapestPrice.persistence.stub;

import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ProductPersistence;

import java.util.Set;

/**
 * Created by root on 2/16/17.
 */
public class ProductPersistenceStub implements ProductPersistence {

    @Override
    public Set<Producto> loadProducts() {
        return null;
    }

    @Override
    public Producto loadProductById(long id) throws CheapestPriceException {
        return null;
    }

    @Override
    public Set<Producto> loadAllProductsByName(String name) throws CheapestPriceException {
        return null;
    }

    @Override
    public Set<Producto> loadAllProductsByPrice(long price) throws CheapestPriceException {
        return null;
    }

    @Override
    public Set<Producto> loadAllProductsByTrademark(String marca) throws CheapestPriceException {
        return null;
    }

    @Override
    public Set<Producto> loadAllProductsByCategory(String categoria) throws CheapestPriceException {
        return null;
    }

    @Override
    public void addProduct(Producto producto) throws CheapestPriceException {

    }

    @Override
    public void updateProduct(Producto producto) throws CheapestPriceException {

    }

    @Override
    public void deleteProduct(long id) throws CheapestPriceException {

    }
}
