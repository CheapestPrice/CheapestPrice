package edu.eci.cosw.cheapestPrice.persistence.hibernate;

import java.sql.Blob;
import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;
import edu.eci.cosw.cheapestPrice.repositories.*;
import edu.eci.cosw.cheapestPrice.services.ShopServicePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Daniela on 18/03/17.
 */
@Service
public class ShopPersistenceHibernate implements ShopPersistence {

    @Autowired
    private ShopRepository repositoryshop;

    @Autowired
    private OpinionRepository opinionRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private HoraryRepository horarioRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    ///actualizo todo lo referente a llave no primaria ni horario ni opiniones
    public void modifyTienda(int id, Tienda tienda) throws CheapestPriceException {
            repositoryshop.modifyLogo(id,tienda.getLogo());
            repositoryshop.modifyTelephone(id,tienda.getTelefono());
    }

    @Override
    public void addProduct(int id, Producto producto) throws CheapestPriceException {
        productRepository.save(producto);

    }

    @Override
    public void deleteProduct(int id, long idproducto) throws CheapestPriceException {
        itemRepository.delete(id);
        productRepository.delete(idproducto);
    }

    @Override
    public void modifyProductByCategoria(Producto producto, String cambio) throws CheapestPriceException {
        productRepository.updateByCategoria(producto,cambio);
    }
    @Override
    public void modifyProductByMarca(Producto producto, String cambio) throws CheapestPriceException {
        productRepository.updateByMarca(producto, cambio);
    }

    @Override
    public void modifyProductByNombre(Producto producto, String cambio) throws CheapestPriceException {
        productRepository.updateByName(producto,cambio);
    }

    @Override
    public void modifyProductByImage(Producto producto, Blob cambio) throws CheapestPriceException {
        productRepository.updateByImage(producto.getNombre(),producto.getMarca(),producto.getCategoria(),cambio);
    }


    @Override
    public void modifyHorary(int id, String dia, Horario horario) throws CheapestPriceException {
        horarioRepository.delete(id);
        horarioRepository.save(horario);
    }

    @Override
    public void addOpinion(int id, Opinion opinion) throws CheapestPriceException {
        opinionRepository.save(opinion);
    }


    @Override
    public Opinion consultOpinion(int id, Opinion opinion) throws CheapestPriceException {
        return opinionRepository.loadOpinion(id, opinion);
    }

    @Override
    public List<Opinion> consultOpiniones(int id) throws CheapestPriceException {
        return opinionRepository.loadOpinions(id);
    }

    @Override
    public List<Tienda> consultShop() throws CheapestPriceException {
        return repositoryshop.findAll();
    }

    @Override
    public void modifyTelephone(int id, String telefono) throws CheapestPriceException {
        repositoryshop.modifyTelephone(id,telefono);
    }

    @Override
    public boolean isOpen(int id, Timestamp fecha) throws CheapestPriceException {
        return repositoryshop.getOne(id).isOpen(fecha);
    }


    @Override
    public void modifyLogo(int id, Blob logo) throws CheapestPriceException {
        repositoryshop.modifyLogo(id,logo);
    }

    @Override
    public List<Item> loadItems(int idtienda) throws CheapestPriceException {
        return itemRepository.loadItemsByShop(idtienda);
    }

    @Override
    public Item loadItem(int idShop, int idItem) throws CheapestPriceException {
        return itemRepository.loadItem(idShop,idItem);
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
    public Tienda consultTienda(int idtienda) throws CheapestPriceException {
        return repositoryshop.findOne(idtienda);
    }
}
