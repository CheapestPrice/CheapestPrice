package edu.eci.cosw.cheapestPrice.persistence.hibernate;

import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ProductPersistence;
import edu.eci.cosw.cheapestPrice.persistence.SessionFactoryPersistence;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Set;

/**
 * Created by masterhugo on 2/16/17.
 */
public class ProductPersistenceHibernate extends SessionFactoryPersistence implements ProductPersistence {
    private Session sesion;

    public ProductPersistenceHibernate(Session s) {
        this.sesion=s;
    }

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
        sesion.update(producto);
    }

    @Override
    public void deleteProduct(Producto producto) throws CheapestPriceException {
        sesion.delete(producto);
    }
}
