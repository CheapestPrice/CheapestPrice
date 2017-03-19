package edu.eci.cosw.cheapestPrice.persistence.hibernate;

import com.mysql.jdbc.Blob;
import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;
import edu.eci.cosw.cheapestPrice.repositories.ShopRepository;
import edu.eci.cosw.cheapestPrice.services.ShopServicePersistence;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by daniela on 18/03/17.
 */
public class ShopPersistenceHibernate implements ShopPersistence {

    private ShopRepository repository;

    @Override
    public void addTienda(Tienda tienda) {
        repository.save(tienda);
    }

    @Override
    public void modifyTienda(TiendaId id, Tienda tienda) throws CheapestPriceException {
        repository.delete(id);
        addTienda(tienda);
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
        Tienda old=repository.getOne(id);
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
