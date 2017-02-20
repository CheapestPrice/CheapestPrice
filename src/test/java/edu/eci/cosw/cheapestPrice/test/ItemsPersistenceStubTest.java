package edu.eci.cosw.cheapestPrice.test;
import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.entities.Tienda;
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

    @Test
    public void CE1DeberiaAgregarItem(){
        ItemPersistenceStub ips= new ItemPersistenceStub();
        Producto p1=new Producto(7,"Lecherita",2000,"Nestle","Leche condensada");
        Tienda t1= new Tienda("calle 184 #52 A13", 4.7649271,-74.0476042,"Donde Juancho","1234567-2","6699132",true);
        Item i1= new Item(t1,p1);
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
        Producto p1=new Producto(7,"Lecherita",2000,"Nestle","Leche condensada");
        Producto p2=new Producto(8,"Leche",2000,"Colanta","Leche");
        Tienda t1= new Tienda("calle 184 #52 A13", 4.7649271,-74.0476042,"Donde Juancho","1234567-2","6699132",true);
        Item i1= new Item(t1,p1);
        Item i2= new Item(t1,p2);
        Tienda t2= new Tienda("calle 184 #52 A13", 4.7649271,-74.0476042,"Donde Roberto","1234567-2","6699132",true);
        Item i3 = new Item(t2,p2);
        List<Item> lista= new ArrayList<>();
        lista.add(i1);lista.add(i2);
        try {
            ips.addItem(i1);
            ips.addItem(i2);
            ips.addItem(i3);
            List<Item> items=ips.loadItemByShop(t1.getNombre());
            Assert.assertEquals("No consulta correctamente por tienda",lista,items);
        } catch (CheapestPriceException e) {
            Assert.fail("arroja excepcion inesperada al consultar item por tienda");
        }
    }
    @Test
    public void CE2DeberiaCargarItemPorCategoria(){
        ItemPersistenceStub ips= new ItemPersistenceStub();
        Producto p1=new Producto(7,"Lecherita",2000,"Nestle","Leche condensada");
        Producto p2=new Producto(8,"Pan arabe",2000,"Bimbo","Pan");
        Producto p3=new Producto(8,"Tortillas",2000,"Bimbo","Pan");
        Producto p4=new Producto(8,"Tostadas",2000,"Bimbo","Pan");
        Tienda t1= new Tienda("calle 184 #52 A13", 4.7649271,-74.0476042,"Donde Juancho","1234567-2","6699132",true);
        Item i1= new Item(t1,p1);
        Item i2= new Item(t1,p2);
        Item i3= new Item(t1,p3);
        Tienda t2= new Tienda("calle 184 #52 A13", 4.7649271,-74.0476042,"Donde Roberto","1234567-2","6699132",true);
        Item i4 = new Item(t2,p2);
        Item i5 = new Item(t2,p4);
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
}
