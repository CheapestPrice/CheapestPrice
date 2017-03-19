package edu.eci.cosw.cheapestPrice.services;

import java.sql.Blob;
import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Created by Daniela on 18/03/17.
 */
@Service
public class ShopServicePersistence implements ShopService {


    private ShopPersistence persistence;


    @Override
    public void addTienda(Tienda tienda) throws CheapestPriceException {
        persistence.addTienda(tienda);
    }

    @Override
    public void modifyTienda(TiendaId id, Tienda tienda) throws CheapestPriceException {
        persistence.modifyTienda(id, tienda);
    }

    @Override
    public List<Item> loadItems(TiendaId idtienda, long idproducto) {
        return null;
    }

    @Override
    public Item loadItem(TiendaId idtienda, long idproducto) throws CheapestPriceException {
        return null;
    }

    @Override
    public void addProduct(TiendaId id, Producto producto) throws CheapestPriceException {

    }

    @Override
    public void deleteProduct(TiendaId id, long idproducto) throws CheapestPriceException {

    }

    @Override
    public void modifyProduct(TiendaId id, long idproducto, Producto producto) throws CheapestPriceException {

    }

    @Override
    public void modifyHorary(TiendaId id, String dia, Horario horario) throws CheapestPriceException {

    }

    @Override
    public void modifyTelephone(TiendaId id, String telefono) throws CheapestPriceException {

    }

    @Override
    public boolean isOpen(TiendaId id, Timestamp fecha) throws CheapestPriceException {
        return false;
    }

    @Override
    public void addOpinion(TiendaId id, Opinion opinion) throws CheapestPriceException {

    }

    @Override
    public void modifyLogo(TiendaId id, Blob logo) throws CheapestPriceException {

    }

}
