package edu.eci.cosw.cheapestPrice.persistence.stub;

import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by 2105403 on 2/21/17.
 */
//@Service
public class UserPersistenceStub implements UserPersistence{

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    private List<Usuario> usuarios;

    public UserPersistenceStub() throws CheapestPriceException {
        usuarios = new ArrayList<>();
        UserPersistenceStub.poblarStub(this);

        prueba(this);
    }

    @Override
    public List<Usuario> loadAllUsuarios(){
        return usuarios;
    }



    @Override
    public List<ListaDeMercado> loadShopListByEmail(String email) throws CheapestPriceException {
        if(email.length()==0 || email==null) throw new CheapestPriceException("El email del usuario no puede ser nulo");
        List<ListaDeMercado> listas = new ArrayList<>();
        for(Usuario u: usuarios){
            if(u.getCorreo().equals(email)){
                listas=u.getListas();
                break;
            }
        }
        return listas;
    }

    @Override
    public Usuario loadUserByEmail(String correo) throws CheapestPriceException {
        if(correo.length()==0 || correo==null)  throw new CheapestPriceException("El email del usuario no puede ser nulo");
        Usuario user=new Usuario();
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(correo)) {
                user = u;
                break;
            }
        }
        return user;
    }


    @Override
    public void addUser(Usuario usuario)throws CheapestPriceException{
        System.out.println("Sirvio!: "+ usuario.getCorreo());
        if(usuarios.contains(usuario)) throw new CheapestPriceException("El usuario con correo"+usuario.getCorreo()+" ya está registrado");
        usuarios.add(usuario);

    }

    @Override
    public void updateUser(String oldCorreo, Usuario usuario) throws CheapestPriceException{
        if(!usuarios.contains(usuario)) throw new CheapestPriceException("El usuario tiene que existir");
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(oldCorreo)){
                usuarios.remove(u);
                break;
            }
        }
        usuarios.add(usuario);
    }

    public static void poblarStub(UserPersistenceStub ups){
        Producto p1=new Producto(1,"Queso crema","Alqueria","Queso");
        TiendaId id=new TiendaId("1234567-2",4.7649271,-74.0476042);
        Tienda t1= new Tienda("calle 184 #52 A13",id,"Donde pepe","6699132",true);
        Producto p2=new Producto(2,"Leche entera","Alqueria","Leche");
        TiendaId id2=new TiendaId("123456456",4.7498466,-74.0623005);
        Tienda t2= new Tienda("Cll 167 #58a-20",id,"Surtir","6699132",true);
        Producto p3=new Producto(3,"Papas BBQ","Margarita","Papas");
        Producto p4=new Producto(4,"Coca-Cola","Coca-Cola","Gaseosa");
        ItemId iid1=new ItemId(t1,p1);
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
        Usuario u1 = new Usuario("name1","email1");
        ListaMercado_Item lisid1=new ListaMercado_Item("lista1",u1);
        ListaMercado_Item lisid2=new ListaMercado_Item("lista2",u1);
        ListaDeMercado lM1 = new ListaDeMercado(lisid1, new Date(), false);
        ListaDeMercado lM2 = new ListaDeMercado(lisid2, new Date(), false);
        ItemLista tL1 = new ItemLista(new ItemListaId(i1,lM1),false,false);
        ItemLista tL2 = new ItemLista(new ItemListaId(i2,lM1),false,false);
        ItemLista tL3 = new ItemLista(new ItemListaId(i3,lM1),false,false);
        ItemLista tL4 = new ItemLista(new ItemListaId(i4,lM1),false,false);
        ItemLista tL5 = new ItemLista(new ItemListaId(i5,lM2),false,false);
        ItemLista tL6 = new ItemLista(new ItemListaId(i6,lM2),false,false);
        List<ItemLista> lIL1 = new ArrayList<>();
        List<ItemLista> lIL2 = new ArrayList<>();
        List<ItemLista> lIL3 = new ArrayList<>();
        lIL1.add(tL1);
        lIL1.add(tL2);
        lIL2.add(tL3);
        lIL2.add(tL4);
        lIL3.add(tL5);
        lIL3.add(tL6);
        lM1.setItems(lIL1); lM1.setItems(lIL2);

        lM2.setItems(lIL3);
        List<ListaDeMercado> listas = new ArrayList<>();
        listas.add(lM1); listas.add(lM2);

        try{
            ups.addUser(u1);
        }catch (CheapestPriceException e){
            e.printStackTrace();
        }
    }

    private static void prueba(UserPersistenceStub ups) throws CheapestPriceException {

        Usuario u=new Usuario("nombre","prueba@prueba.com");
        ups.addUser(u);

    }
}
