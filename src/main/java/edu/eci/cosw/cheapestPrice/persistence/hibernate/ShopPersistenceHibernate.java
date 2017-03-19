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
 * Created by Daniela on 18/03/17.
 */
public class ShopPersistenceHibernate implements ShopPersistence {

    private ShopRepository repository;

    @Override
    public void addTienda(Tienda tienda) throws CheapestPriceException {
        repository.save(tienda);
    }

    @Override
    ///actualizo todo lo referente a llave no primaria ni horario ni opiniones
    public void modifyTienda(TiendaId id, Tienda tienda) throws CheapestPriceException {

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
        Tienda tmp=repository.getOne(id);
        tmp.setTelefono(telefono);
        modifyTienda(id,tmp);
    }

    @Override
    public boolean isOpen(TiendaId id, Timestamp fecha) throws CheapestPriceException {
        return repository.getOne(id).isOpen(fecha);
    }

    @Override
    public void addOpinion(TiendaId id, Opinion opinion) throws CheapestPriceException {

    }

    @Override
    public void modifyLogo(TiendaId id, Blob logo) throws CheapestPriceException {
        Tienda tmp=repository.getOne(id);
        tmp.setLogo(logo);
        modifyTienda(id,tmp);
    }


}
