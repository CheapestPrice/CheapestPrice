package edu.eci.cosw.cheapestPrice.persistence.stub;

import edu.eci.cosw.cheapestPrice.entities.Tienda;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    public Map<String, Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(Map<String, Tienda> tiendas) {
        this.tiendas = tiendas;
    }
}
