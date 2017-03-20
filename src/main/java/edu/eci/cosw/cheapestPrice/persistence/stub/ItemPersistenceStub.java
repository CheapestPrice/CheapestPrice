package edu.eci.cosw.cheapestPrice.persistence.stub;

import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.ItemPersistence;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Julián David Devia Serna on 2/20/17.
 */
//@Service
public class ItemPersistenceStub implements ItemPersistence{

    private List<Item> items;
    private long id;

    public ItemPersistenceStub(){
        items= new CopyOnWriteArrayList<>();
        id=0;
        ItemPersistenceStub.poblarStub(this);
    }

    @Override
    public List<Item> loadItems() {
        return items;
    }

    @Override
    public Item loadItem(String shopName, long id) throws CheapestPriceException {
        if(shopName==null || shopName.length()==0){
            throw new CheapestPriceException("El nombre de la tienda no puede ser vacio");
        }
        if(id<0){
            throw new CheapestPriceException("El id no puede ser menor a 0");
        }
        Item item=null;
        for (Item i : items){
            if(i.getTienda().getNombre().equals(shopName) && i.getProducto().getId()==id){
                item=i;
            }
        }
        if(item==null){
            throw new CheapestPriceException("El item solicitado no se encuentra registrado");
        }
        return item;
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
    public Producto loadProductById(long id) throws CheapestPriceException {
        return null;
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
        id++;
        item.getProducto().setId(id);
        items.add(item);
    }

    @Override
    public void deleteItem(String shopName,long id) throws CheapestPriceException {
        if(shopName==null || shopName.length()==0){
            throw new CheapestPriceException("El nombre de la tienda no puede ser vacio");
        }
        if(id<0){
            throw new CheapestPriceException("El id no puede ser menor a 0");
        }
        Item item=loadItem(shopName,id);
        boolean removed=items.remove(item);
        if(!removed){
            throw new CheapestPriceException("El item no se encuentra registrado");
        }
    }

    @Override
    public void updateItem(long oldId,String oldshop, Item item) throws CheapestPriceException {
        if(oldId<0 ){
            throw new CheapestPriceException("El id con el que esta registrado el producto no puede ser negativo");
        }
        if(oldshop==null || oldshop.length()==0 ){
            throw new CheapestPriceException("El nombre de la tienda no puede ser vacio");
        }
        if(item==null){
            throw new CheapestPriceException("el item no puede ser vacio");
        }
        Item old=null;
        for (Item i:items){
            if(i.getProducto().getId()==oldId && i.getTienda().getNombre().equals(oldshop)){
                old=i;
                break;
            }
        }
        if(old!=null){
            addItem(item);
            items.remove(old);
        }else{
            throw new CheapestPriceException("No hay ningun item registrado con el id suministrado");
        }
    }

    public static void poblarStub(ItemPersistenceStub ips){
        TiendaId id=new TiendaId("1234567-2",4.7649271,-74.0476042);
        List<Horario> hor=new ArrayList<>();
        hor.add(new Horario(8, 15, 9, 0,"Lunes"));
        hor.add(new Horario(7, 15, 8, 15,"Martes"));
        hor.add(new Horario(8, 15, 9, 0,"Miercoles"));
        hor.add(new Horario(7, 15, 8, 15,"Jueves"));
        hor.add(new Horario(8, 15, 9, 0,"Viernes"));
        hor.add(new Horario(7, 15, 8, 15,"Sabado"));
        hor.add(new Horario(8, 15, 9, 0,"Domingo"));
        Tienda t1= new Tienda("calle 184 #52 A13",id,"Donde pepe","6699132",true);
        t1.setHorarios(hor);
        TiendaId id2=new TiendaId("123456456",4.7498466,-74.0623005);
        Tienda t2= new Tienda("Cll 167 #58a-20",id,"Surtir","6699132",true);
        t1.setHorarios(hor);
        Producto p1=new Producto(1,"Queso crema","Alqueria","Queso");
        Producto p2=new Producto(2,"Leche entera","Alqueria","Leche");
        Producto p3=new Producto(3,"Papas BBQ","Margarita","Papas");
        Producto p4=new Producto(4,"Coca-Cola","Coca-Cola","Gaseosa");
        /*ItemId iid1=new ItemId(t1,p1);
        ItemId iid2=new ItemId(t2,p2);
        ItemId iid3=new ItemId(t2,p1);
        ItemId iid4=new ItemId(t2,p3);
        ItemId iid5=new ItemId(t2,p4);
        ItemId iid6=new ItemId(t1,p4);
        Item i1= new Item(iid1,3000);
        Item i2=new Item(iid2,3500);
        Item i3=new Item(iid3,3000);
        Item i4=new Item(iid4,4500);
        Item i5=new Item(iid5,4500);
        Item i6= new Item(iid6,4500);
        try {
            ips.addItem(i1);
            ips.addItem(i2);
            ips.addItem(i3);
            ips.addItem(i4);
            ips.addItem(i5);
            ips.addItem(i6);
        } catch (CheapestPriceException e) {
            e.printStackTrace();
        }*/
    }
}
