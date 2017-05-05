package edu.eci.cosw.cheapestPrice.test;
import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.stub.ItemPersistenceStub;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julián David Devia Serna on 2/20/17.
 */
public class ItemsPersistenceStubTest {
/*
    @Test
    public void CE1DeberiaAgregarItem(){
        ItemPersistenceStub ips= new ItemPersistenceStub();
        Producto p1=new Producto(7,"Lecherita","Nestle","Leche condensada");
        TiendaId id=new TiendaId("1234567-2",4.7649271,-74.0476042);
        Tienda t1= new Tienda("calle 184 #52 A13",id,"Donde Juancho","6699132",true);
        Item i1= new Item(p1,t1,2000);
        try {
            ips.addItem(i1);
            List<Item> items=ips.loadItemById(i1.getProducto().getId());
            Assert.assertEquals("No agrega el item correctamente",i1,items.get(0));
        } catch (CheapestPriceException e) {
            Assert.fail("arroja excepcion inesperada al agregar item");
        }
    }

    @Test
    public void CE2DeberiaCargarItemPorTienda(){
        ItemPersistenceStub ips= new ItemPersistenceStub();
        Producto p1=new Producto(7,"Lecherita","Nestle","Leche condensada");
        Producto p2=new Producto(8,"Leche","Colanta","Leche");
        TiendaId id=new TiendaId("1234567-2",4.7649271,-74.0476042);
        Tienda t1= new Tienda("calle 184 #52 A13",id,"Donde Juancho","6699132",true);
        Item i1= new Item(p1,t1,2000);
        Item i2= new Item(p2,t1,2000);
        TiendaId id2=new TiendaId("7891211-2",4.7649271,-74.0476042);
        Tienda t2= new Tienda("calle 184 #52 A13",id2,"Donde Roberto","6699132",true);
        Item i3 = new Item(p1,t1,2000);
        List<Item> lista= new ArrayList<>();
        lista.add(i1);lista.add(i2);lista.add(i3);
        try {
            ips.addItem(i1);
            ips.addItem(i2);
            ips.addItem(i3);
            List<Item> items=ips.loadItemByShop(t1.getId());
            Assert.assertEquals("No consulta correctamente por tienda",lista,items);
        } catch (CheapestPriceException e) {
            Assert.fail("arroja excepcion inesperada al consultar item por tienda");
        }
    }
    @Test
    public void CE3DeberiaCargarItemPorCategoria(){
        ItemPersistenceStub ips= new ItemPersistenceStub();
        Producto p1=new Producto(7,"Lecherita","Nestle","Leche condensada");
        Producto p2=new Producto(8,"Pan arabe","Bimbo","Pan");
        Producto p3=new Producto(8,"Tortillas","Bimbo","Pan");
        Producto p4=new Producto(8,"Tostadas","Bimbo","Pan");
        TiendaId id=new TiendaId("1234567-2",4.7649271,-74.0476042);
        Tienda t1= new Tienda("calle 184 #52 A13",id,"Donde Juancho","6699132",true);
        Item i1= new Item(p1,t1,2000);
        Item i2= new Item(p2,t1,2000);
        Item i3= new Item(p3,t1,2000);
        Tienda t2= new Tienda("calle 184 #52 A13",id,"Donde Roberto","6699132",true);
        Item i4= new Item(p2,t2,2000);
        Item i5 = new Item(p3,t2,2000);
        List<Item> lista= new ArrayList<>();
        lista.add(i2);lista.add(i3);lista.add(i4);lista.add(i5);
        try {
            ips.addItem(i1);
            ips.addItem(i2);
            ips.addItem(i3);
            ips.addItem(i4);
            ips.addItem(i5);
            List<Item> items=ips.loadItemByCategory(p2.getCategoria());
            Assert.assertEquals("No consulta correctamente por categoria",lista,items);
        } catch (CheapestPriceException e) {
            Assert.fail("arroja excepcion inesperada al consultar item por categoria");
        }
    }

    @Test
    public void CE4DeberiaEliminarItem(){
        ItemPersistenceStub ips= new ItemPersistenceStub();
        Producto p1=new Producto(7,"Lecherita","Nestle","Leche condensada");
        TiendaId id=new TiendaId("1234567-2",4.7649271,-74.0476042);
        Tienda t1= new Tienda("calle 184 #52 A13",id,"Donde Juancho","6699132",true);
        Item i1= new Item(p1,t1,2000);
        try {
            ips.addItem(i1);
            List<Item> items=ips.loadItemById(p1.getId());
            ips.deleteItem(t1.getNombre(),p1.getId());
            List<Item> items2=ips.loadItemById(p1.getId());
            Assert.assertTrue("No elimina correctamente",items.size()==1 && items2.size()==0);
        } catch (CheapestPriceException e) {
            Assert.fail("arroja excepcion inesperada al eliminar un item");
        }
    }

    @Test
    public void CE5DeberiaCActualizarItem(){
        ItemPersistenceStub ips= new ItemPersistenceStub();
        Producto p1=new Producto(7,"Lecherita","Nestle","Leche condensada");
        TiendaId id=new TiendaId("1234567-2",4.7649271,-74.0476042);
        Tienda t1= new Tienda("calle 184 #52 A13",id,"Donde Juancho","6699132",true);
        Item i1= new Item(p1,t1,2000);
        try {
            ips.addItem(i1);
            List<Item> items=ips.loadItemById(p1.getId());
            Producto a=new Producto(8,"a","b","c");
            Item i2= new Item(a,t1,12);
            ips.updateItem(p1.getId(),t1.getNombre(),i2);
            List<Item> items2=ips.loadItemById(i2.getProducto().getId());
            List<Item> old=new ArrayList<>();old.add(i1);
            List<Item> newl=new ArrayList<>();newl.add(i2);
            Assert.assertTrue("No actualiza correctamente",items.equals(old) && items2.equals(newl));
        } catch (CheapestPriceException e) {
            Assert.fail("arroja excepcion inesperada al actualiza un item");
        }
    }*/
}
