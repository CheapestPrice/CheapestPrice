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
        System.out.println("oldCorreo: "+oldCorreo+" "+"Usuario.correo: "+usuario.getCorreo());
        //if(!usuarios.contains(usuario)) throw new CheapestPriceException("El usuario tiene que existir");
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(oldCorreo)){
                usuarios.remove(u);
                break;
            }
        }
        usuarios.add(usuario);
    }

    @Override
    public void deleteShoppingList(String correo, String nombreLista) throws CheapestPriceException {
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(correo)){
                for(ListaDeMercado lm:u.getListas()){
                    if(lm.getListaid().getNombre().equals(nombreLista)){
                        u.getListas().remove(lm);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void favoriteShoppingListItem(String correo, String nombreLista, long idProducto, double x,double y, String nit,boolean fav) throws CheapestPriceException {
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(correo)){
                for(ListaDeMercado lm:u.getListas()){
                    if(lm.getListaid().getNombre().equals(nombreLista)){
                        for(ItemLista itL:lm.getItems()){
                            Tienda t=itL.getItem().getTienda();
                            if(itL.getItem().getProducto().getId()==idProducto && t.getId().getX()==x && t.getId().getY()==y && t.getId().getNit().equals(nit)){
                                itL.setFavorito(fav);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void deleteSelectedItem(String correo, String nombreLista, long idProducto, double x,double y, String nit) throws CheapestPriceException {
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(correo)) {
                for(ListaDeMercado lm:u.getListas()){
                    if(lm.getListaid().getNombre().equals(nombreLista)){
                        for(ItemLista itL:lm.getItems()){
                            Tienda t=itL.getItem().getTienda();
                            if(itL.getItem().getProducto().getId()==idProducto && t.getId().getX()==x && t.getId().getY()==y && t.getId().getNit().equals(nit)){
                                lm.getItems().remove(itL);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void sellSelectedItem(String correo, String nombreLista, long idProducto, double x, double y, String nit,boolean comp) throws CheapestPriceException {
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(correo)){
                for(ListaDeMercado lm:u.getListas()){
                    if(lm.getListaid().getNombre().equals(nombreLista)){
                        for(ItemLista itL:lm.getItems()){
                            Tienda t=itL.getItem().getTienda();
                            if(itL.getItem().getProducto().getId()==idProducto && t.getId().getX()==x && t.getId().getY()==y && t.getId().getNit().equals(nit)){
                                itL.setComprado(comp);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void addShoppingList(ListaDeMercado listaDeMercado) throws CheapestPriceException {
        ListaDeMercado lm = listaDeMercado;
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(lm.getUsuario().getCorreo())){
                u.getListas().add(lm);
                break;
            }
        }
    }

    @Override
    public void addItemListaMercado(ItemLista itemLista) {

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
        Item i1= new Item(p1,t1,3000);
        Item i2=new Item(p2,t2,3500);
        Item i3=new Item(p1,t2,3000);
        Item i4=new Item(p3,t2,4500);
        Item i6= new Item(p4,t1,4500);
        Usuario u1 = new Usuario("name1","email1");
        ListaMercado_Item lisid1=new ListaMercado_Item("lista1",u1.getNombre());
        ListaMercado_Item lisid2=new ListaMercado_Item("lista2",u1.getNombre());
        ListaDeMercado lM1 = new ListaDeMercado(new Date(), false);
        ListaDeMercado lM2 = new ListaDeMercado(new Date(), false);
        lM1.setListaid(lisid1); lM2.setListaid(lisid2);
        ItemLista tL1 = new ItemLista(new ItemListaId(i1,lM1),false,false);
        ItemLista tL2 = new ItemLista(new ItemListaId(i2,lM1),false,false);
        ItemLista tL3 = new ItemLista(new ItemListaId(i3,lM1),false,false);
        ItemLista tL4 = new ItemLista(new ItemListaId(i4,lM1),false,false);
        ItemLista tL6 = new ItemLista(new ItemListaId(i6,lM2),false,false);
        tL1.setItem(i1);tL2.setItem(i2);tL3.setItem(i3);
        tL4.setItem(i4);tL6.setItem(i6);
        List<ItemLista> lIL1 = new ArrayList<>();
        List<ItemLista> lIL2 = new ArrayList<>();
        List<ItemLista> lIL3 = new ArrayList<>();
        lIL1.add(tL1);
        lIL1.add(tL2);
        lIL2.add(tL3);
        lIL2.add(tL4);
        lIL3.add(tL6);
        lM1.setItems(lIL1); lM1.setItems(lIL2);
        lM2.setItems(lIL3);
        List<ListaDeMercado> listas = new ArrayList<>();
        listas.add(lM1); listas.add(lM2);

        try{
            u1.setListas(listas);
            ups.addUser(u1);
        }catch (CheapestPriceException e){
            e.printStackTrace();
        }
    }



}
