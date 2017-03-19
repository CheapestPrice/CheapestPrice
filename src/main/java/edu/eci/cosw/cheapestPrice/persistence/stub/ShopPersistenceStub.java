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
                tiendas.get(i).modifyHorary(dia,horario);
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
        boolean ans=false;
        for (int i = 0; i < tiendas.size(); i++) {
            if(tiendas.get(i).getId().equals(id)){
                ans=tiendas.get(i).isOpen(fecha);
            }
        }
        return ans;
    }

    @Override
    public void addOpinion(TiendaId id, Opinion opinion) throws CheapestPriceException {
        for (int i = 0; i < tiendas.size(); i++) {
            if(tiendas.get(i).getId().equals(id)){
                tiendas.get(i).addOpinion(opinion);
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

    /**
     *Poblar stub tiendas
     * @param shopPersistence
     */
    public static void poblarStub(ShopPersistenceStub shopPersistence){
        TiendaId id=new TiendaId("1234567-2",4.7649271,-74.0476042);
        Tienda t1= new Tienda("calle 184 #52 A13",id,"Donde pepe","6699132",true);
        TiendaId id2=new TiendaId("123456456",4.7498466,-74.0623005);
        Tienda t2= new Tienda("Cll 167 #58a-20",id,"Surtir","6699132",true);
        TiendaId id3=new TiendaId("123456789-2",4.7649271,-74.0476042);
        Tienda t3= new Tienda("calle 184 #52 A13",id,"Donde aaaa","6699132",true);
        TiendaId id4=new TiendaId("1234567782-2",4.7649271,-74.0476042);
        Tienda t4= new Tienda("calle 184 #52 A13",id,"Donde bbbb","6699132",true);
        try {
            shopPersistence.addTienda(t1);
            shopPersistence.addTienda(t2);
            shopPersistence.addTienda(t3);
            shopPersistence.addTienda(t4);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
        }

    }
}
