package edu.eci.cosw.cheapestPrice.services;

import java.sql.Blob;
import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Daniela on 18/03/17.
 */
@Service
public class ShopServicePersistence implements ShopService {

    @Autowired
    private ShopPersistence persistence;


    @Override
    public void addTienda(Tienda tienda) throws CheapestPriceException {
        persistence.addTienda(tienda);
    }

    @Override
    public List<Tienda> consultShop() throws CheapestPriceException {
        return persistence.consultShop();
    }

    @Override
    public void deleteTienda(Tienda tienda) throws CheapestPriceException {
        persistence.deleteTienda(tienda);
    }

    @Override
    public void modifyTienda(int id, Tienda tienda) throws CheapestPriceException {
        persistence.modifyTienda(id, tienda);
    }

    @Override
    public List<Item> loadItems(int idtienda) throws CheapestPriceException{
        return persistence.loadItems(idtienda);
    }

    @Override
    public Item loadItem(int id, int idItem) throws CheapestPriceException {
        return persistence.loadItem(id,idItem);
    }

    @Override
    public void addProduct(int id, Producto producto) throws CheapestPriceException {
        persistence.addProduct(id, producto);
    }

    @Override
    public void deleteProduct(int id, long idproducto) throws CheapestPriceException {
        persistence.deleteProduct(id,idproducto);
    }

    @Override
    public void modifyProductByCategoria(Producto producto, String cambio) throws CheapestPriceException {
        persistence.modifyProductByCategoria(producto,cambio);
    }
    @Override
    public void modifyProductByImage(Producto producto, Blob cambio) throws CheapestPriceException {
        persistence.modifyProductByImage(producto,cambio);
    }
    @Override
    public void modifyProductByMarca(Producto producto, String cambio) throws CheapestPriceException {
        persistence.modifyProductByMarca(producto,cambio);
    }
    @Override
    public void modifyProductByNombre(Producto producto, String cambio) throws CheapestPriceException {
        persistence.modifyProductByNombre(producto,cambio);
    }
    @Override
    public void modifyHorary(int id, String dia, Horario horario) throws CheapestPriceException {
        persistence.modifyHorary(id, dia, horario);
    }

    @Override
    public void modifyTelephone(int id, String telefono) throws CheapestPriceException {
        persistence.modifyTelephone(id,telefono);
    }

    @Override
    public boolean isOpen(int id, Timestamp fecha) throws CheapestPriceException {
        return persistence.isOpen(id, fecha);
    }

    @Override
    public void addOpinion(int id, Opinion opinion) throws CheapestPriceException {
        persistence.addOpinion(id, opinion);
    }

    @Override
    public void modifyLogo(int id, Blob logo) throws CheapestPriceException {
        persistence.modifyLogo(id, logo);
    }

    @Override
    public Opinion consultOpinion(int id, Opinion opinion) throws CheapestPriceException {
        return persistence.consultOpinion(id,opinion);
    }

    @Override
    public List<Opinion> consultOpiniones(int id) throws CheapestPriceException {
        return persistence.consultOpiniones(id);
    }

    @Override
    public Tienda consultTienda(int idtienda) throws CheapestPriceException {
        return persistence.consultTienda(idtienda);
    }
}
