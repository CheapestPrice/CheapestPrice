package edu.eci.cosw.cheapestPrice.persistence.hibernate;

import java.sql.Blob;
import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;
import edu.eci.cosw.cheapestPrice.repositories.ShopRepository;
import edu.eci.cosw.cheapestPrice.services.ShopServicePersistence;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Daniela on 18/03/17.
 */
public class ShopPersistenceHibernate implements ShopPersistence {

    @Autowired
    private ShopRepository repositoryshop;

    @Override
    ///actualizo todo lo referente a llave no primaria ni horario ni opiniones
    public void modifyTienda(TiendaId id, Tienda tienda) throws CheapestPriceException {

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
    public void addOpinion(TiendaId id, Opinion opinion) throws CheapestPriceException {

    }


    @Override
    public Opinion consultOpinion(TiendaId id, Opinion opinion) throws CheapestPriceException {
        return null;
    }

    @Override
    public void modifyTelephone(TiendaId id, String telefono) throws CheapestPriceException {
        repositoryshop.modifyTelephone(id,telefono);
    }

    @Override
    public boolean isOpen(TiendaId id, Timestamp fecha) throws CheapestPriceException {
        return repositoryshop.getOne(id).isOpen(fecha);
    }


    @Override
    public void modifyLogo(TiendaId id, Blob logo) throws CheapestPriceException {
        repositoryshop.modifyLogo(id,logo);
    }

    @Override
    public List<Item> loadItems(TiendaId idtienda) throws CheapestPriceException {
        return repositoryshop.loadItems(idtienda);
    }

    @Override
    public Item loadItem(TiendaId idtienda, long idproducto) throws CheapestPriceException {
        return repositoryshop.loadItem(idtienda,idproducto);
    }

    @Override
    public void addTienda(Tienda tienda) throws CheapestPriceException {
        repositoryshop.save(tienda);
    }

    @Override
    public void deleteTienda(Tienda tienda) throws CheapestPriceException {
        repositoryshop.delete(tienda.getId());
    }

    @Override
    public Tienda consultTienda(TiendaId idtienda) throws CheapestPriceException {
        return repositoryshop.getOne(idtienda);
    }
}
