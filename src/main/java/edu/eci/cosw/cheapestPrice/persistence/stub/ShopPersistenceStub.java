package edu.eci.cosw.cheapestPrice.persistence.stub;

import com.mysql.jdbc.Blob;
import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Paula on 21/02/2017.
 */
@Service
public class ShopPersistenceStub implements ShopPersistence {

    private Map<String,Tienda> tiendas;

    public ShopPersistenceStub(){ tiendas=new HashMap<>();}


    @Override
    public void addTienda(Tienda tienda) {
        System.out.println("Si entro!: "+tienda.tendero.getCorreo());
        tiendas.put(tienda.tendero.getCorreo(),tienda);


    }

    @Override
    public Tienda getTienda(String nickname) {
        return tiendas.get(nickname);
    }

    @Override
    public Item loadItem(long id) throws CheapestPriceException {
        return null;
    }

    @Override
    public List<Item> loadItems() {
        return null;
    }

    @Override
    public void addProduct(Producto producto) throws CheapestPriceException {

    }

    @Override
    public void deleteProduct(long idproducto) throws CheapestPriceException {

    }

    @Override
    public void modifyProduct(long idproducto, Producto producto) throws CheapestPriceException {

    }

    @Override
    public void modifyHorary(String dia, Horario horario) throws CheapestPriceException {

    }

    @Override
    public void modifyTelephone(String telefono) throws CheapestPriceException {

    }

    @Override
    public boolean isOpen(Timestamp fecha) throws CheapestPriceException {
        return false;
    }

    @Override
    public void addOpinion(Opinion opinion) throws CheapestPriceException {

    }

    @Override
    public void modifyLogo(Blob logo) throws CheapestPriceException {

    }

    public Map<String, Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(Map<String, Tienda> tiendas) {
        this.tiendas = tiendas;
    }
}
