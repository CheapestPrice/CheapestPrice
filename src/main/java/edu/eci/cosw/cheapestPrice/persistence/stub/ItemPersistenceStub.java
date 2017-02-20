package edu.eci.cosw.cheapestPrice.persistence.stub;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.entities.Tienda;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ItemPersistence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Julián David Devia Serna on 2/20/17.
 */
public class ItemPersistenceStub implements ItemPersistence{

    private List<Item> items;

    public ItemPersistenceStub(){
        items= new CopyOnWriteArrayList<>();
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
        items.add(item);
    }

    public static void poblarStub(ItemPersistenceStub ips){
        Producto p1=new Producto(1,"Queso crema",3000,"Alqueria","Queso");
        Tienda t1= new Tienda("calle 184 #52 A13", 4.7649271,-74.0476042,"Donde pepe","1234567-2","6699132",true);
        Item i1= new Item(t1,p1);
        try {
            ips.addItem(i1);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
        }
    }
}
