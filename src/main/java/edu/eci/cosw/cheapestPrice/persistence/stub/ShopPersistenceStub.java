package edu.eci.cosw.cheapestPrice.persistence.stub;

import com.mysql.jdbc.Blob;
import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ShopPersistence;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Daniela on 21/02/2017.
 */
@Service
public class ShopPersistenceStub implements ShopPersistence {

    private List<Tienda> tiendas;
    private Map<TiendaId, ArrayList<Item>> items;


    public ShopPersistenceStub(){
        tiendas=new ArrayList<Tienda>();
        items=new HashMap<TiendaId,ArrayList<Item>>();
    }
    /**
     * Consultar las tiendas
     * @return tiendas
     */
    public List<Tienda> getTiendas() {
        return tiendas;
    }

    /**
     * Registrar tiendas
     * @param tiendas
     */
    public void setTiendas(List<Tienda> tiendas) {
        this.tiendas = tiendas;

    }
    /**
     * Consultar las tiendas
     * @return items
     */
    public Map<TiendaId, ArrayList<Item>> getItems() {
        return items;
    }

    /**
     * Registrar tiendas
     * @param items
     */
    public void setTiendas( Map<TiendaId, ArrayList<Item>> items) {
        this.items=items;
    }

    @Override
    public void addTienda(Tienda tienda) throws CheapestPriceException {
        tiendas.add(tienda);
    }

    @Override
    public void modifyTienda(TiendaId id, Tienda tienda) throws CheapestPriceException {
        for (int i = 0; i < tiendas.size(); i++) {
            if(tiendas.get(i).getId().equals(id)){
                tiendas.remove(i);
                tiendas.add(i,tienda);
            }
        }
    }

    @Override
    public List<Item> loadItems(TiendaId idtienda, long idproducto) {
        return items.get(idtienda);
    }

    @Override
    public Item loadItem(TiendaId idtienda, long idproducto) throws CheapestPriceException {
        Item tmp=null;
        for (Item i: items.get(idtienda)) {
            if(i.getId().getProducto().getId()==idproducto){
                tmp=i;
            }
        }
        if(tmp==null) throw new CheapestPriceException("No se encontro el item con este identificado");
        return tmp;
    }

    @Override
    public void addProduct(TiendaId id, Producto producto) throws CheapestPriceException {
        Tienda tmp=null;
        for (int i = 0; i < tiendas.size(); i++) {
            if(tiendas.get(i).getId().equals(id)){
                tmp=tiendas.get(i);
            }
        }
        ItemId idt=new ItemId(tmp,producto);
        Item item=new Item(idt);
        ArrayList<Item> ite=new ArrayList<>();
        ite.add(item);
        items.put(id,ite);
    }

    @Override
    public void deleteProduct(TiendaId id, long idproducto) throws CheapestPriceException {
        Tienda tmp=null;
        for (int i = 0; i < tiendas.size(); i++) {
            if(tiendas.get(i).getId().equals(id)){
                tmp=tiendas.get(i);
            }
        }
        ArrayList<Item> a=items.get(id);
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i).getId().getProducto().getId()==idproducto){
                items.remove(i);
            }
        }
    }

    @Override
    public void modifyProduct(TiendaId id, long idproducto, Producto producto) throws CheapestPriceException {
        for (Item i: items.get(id)) {
            if(i.getId().getProducto().getId()==idproducto){
                i.getId().setProducto(producto);
            }
        }
    }

    @Override
    public void modifyHorary(TiendaId id, String dia, Horario horario) throws CheapestPriceException {
        for (int i = 0; i < tiendas.size(); i++) {
            if(tiendas.get(i).getId().equals(id)){
                List<Horario> horar=tiendas.get(i).getHorario();


            }
        }

    }

    @Override
    public void modifyTelephone(TiendaId id, String telefono) throws CheapestPriceException {
        for (int i = 0; i < tiendas.size(); i++) {
            if(tiendas.get(i).getId().equals(id)){
                tiendas.get(i).setTelefono(telefono);
            }
        }
    }

    @Override
    public boolean isOpen(TiendaId id, Timestamp fecha) throws CheapestPriceException {
        return false;
    }

    @Override
    public void addOpinion(TiendaId id, Opinion opinion) throws CheapestPriceException {
        for (int i = 0; i < tiendas.size(); i++) {
            if(tiendas.get(i).getId().equals(id)){
                /////////////////////
            }
        }
    }

    @Override
    public void modifyLogo(TiendaId id, Blob logo) throws CheapestPriceException {
        for (int i = 0; i < tiendas.size(); i++) {
            if(tiendas.get(i).getId().equals(id)){
                tiendas.get(i).setLogo(logo);
            }
        }
    }


}
