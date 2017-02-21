package edu.eci.cosw.cheapestPrice.persistence.stub;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.entities.Tienda;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ItemPersistence;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Julián David Devia Serna on 2/20/17.
 */
@Service
public class ItemPersistenceStub implements ItemPersistence{

    private List<Item> items;

    public ItemPersistenceStub(){
        items= new CopyOnWriteArrayList<>();
        ItemPersistenceStub.poblarStub(this);
    }

    @Override
    public List<Item> loadItems() {
        return items;
    }

    @Override
    public List<Item> loadItemByShop(String shopName) throws CheapestPriceException {
        if(shopName==null || shopName.length()==0){
            throw new CheapestPriceException("El nombre de la tienda no puede ser vacio");
        }
        List<Item> shop= new ArrayList<>();
        for (Item i : items){
            if(i.getTienda().getNombre().equals(shopName)){
                shop.add(i);
            }
        }
        return shop;
    }

    @Override
    public List<Item> loadItemByCategory(String category) throws CheapestPriceException {
        if(category==null || category.length()==0){
            throw new CheapestPriceException("La categoria no puede ser vacia");
        }
        List<Item> categoria = new ArrayList<>();
        for (Item i : items){
            if(i.getProducto().getCategoria().equalsIgnoreCase(category)){
                categoria.add(i);
            }
        }
        return categoria;
    }

    @Override
    public List<Item> loadItemById(long id) throws CheapestPriceException {
        if(id<0){
            throw new CheapestPriceException("El id no puede ser negativo");
        }
        List<Item> item = new ArrayList<>();
        for (Item i : items){
            if(i.getProducto().getId()==id){
                item.add(i);
            }
        }
        return item;
    }

    @Override
    public void addItem(Item item) throws CheapestPriceException {
        if(item==null){
            throw new CheapestPriceException("El item no puede ser nulo");
        }
        for (Item i:items){
            if(item.equals(i)){
                throw new CheapestPriceException("El item ya se encuentra registrado");
            }
        }
        items.add(item);
    }

    public static void poblarStub(ItemPersistenceStub ips){
        Producto p1=new Producto(1,"Queso crema",3000,"Alqueria","Queso");
        Tienda t1= new Tienda("calle 184 #52 A13", 4.7649271,-74.0476042,"Donde pepe","1234567-2","6699132",true);
        Producto p2=new Producto(2,"Leche entera",3500,"Alqueria","Leche");
        Tienda t2= new Tienda("Cll 167 #58a-20", 4.7498466,-74.0623005,"Surtir","123456456","65498765",true);
        Producto p3=new Producto(3,"Papas BBQ",4500,"Margarita","Papas");
        Producto p4=new Producto(4,"Coca-Cola",4500,"Coca-Cola","Gaseosa");
        Item i1= new Item(t1,p1);
        Item i2=new Item(t2,p2);
        Item i3=new Item(t2,p1);
        Item i4=new Item(t2,p3);
        Item i5=new Item(t2,p4);
        Item i6= new Item(t1,p4);
        try {
            ips.addItem(i1);
            ips.addItem(i2);
            ips.addItem(i3);
            ips.addItem(i4);
            ips.addItem(i5);
            ips.addItem(i6);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
        }
    }
}
