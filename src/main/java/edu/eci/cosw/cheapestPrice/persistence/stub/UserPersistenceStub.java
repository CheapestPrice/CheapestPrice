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
    public void updateUser(int oldCorreo, Usuario usuario) throws CheapestPriceException{
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
    public void deleteShoppingList(int id) throws CheapestPriceException {
        /*for(Usuario u:usuarios){
            if(u.getCorreo().equals(correo)){
                for(ListaDeMercado lm:u.getListas()){
                    if(lm.getNombre().equals(nombreLista)){
                        u.getListas().remove(lm);
                        break;
                    }
                }
            }
        }*/
    }

    @Override
    public void favoriteShoppingListItem(String correo, String nombreLista, long idProducto, double x,double y, String nit,boolean fav) throws CheapestPriceException {
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(correo)){
                for(ListaDeMercado lm:u.getListas()){
                    if(lm.getNombre().equals(nombreLista)){
                        for(ItemLista itL:lm.getItems()){
                            Tienda t=itL.getItem().getTienda();
                            if(itL.getItem().getProducto().getId()==idProducto && t.getX()==x && t.getY()==y && t.getNit().equals(nit)){
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
    public void deleteSelectedItem(int id) throws CheapestPriceException {
        /*for(Usuario u:usuarios){
            if(u.getCorreo().equals(correo)) {
                for(ListaDeMercado lm:u.getListas()){
                    if(lm.getNombre().equals(nombreLista)){
                        for(ItemLista itL:lm.getItems()){
                            Tienda t=itL.getItem().getTienda();
                            if(itL.getItem().getProducto().getId()==idProducto && t.getX()==x && t.getY()==y && t.getNit().equals(nit)){
                                lm.getItems().remove(itL);
                                break;
                            }
                        }
                    }
                }
            }
        }*/
    }

    @Override
    public void sellSelectedItem(String correo, String nombreLista, long idProducto, double x, double y, String nit,boolean comp) throws CheapestPriceException {
        for(Usuario u:usuarios){
            if(u.getCorreo().equals(correo)){
                for(ListaDeMercado lm:u.getListas()){
                    if(lm.getNombre().equals(nombreLista)){
                        for(ItemLista itL:lm.getItems()){
                            Tienda t=itL.getItem().getTienda();
                            if(itL.getItem().getProducto().getId()==idProducto && t.getX()==x && t.getY()==y && t.getNit().equals(nit)){
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

    @Override
    public void addCuenta(Cuenta cuenta) {

    }

    @Override
    public void addTendero(Tendero tendero) {

    }

    @Override
    public List loadAllTenderos() {
        return null;
    }

    public static void poblarStub(UserPersistenceStub ups){
        Producto p1=new Producto(1,"Queso crema","Alqueria","Queso");
        Tienda t1= new Tienda("calle 184 #52 A13",1,"Donde pepe","6699132",true,4.7649271,-74.0476042,"1234567-2");
        Producto p2=new Producto(2,"Leche entera","Alqueria","Leche");
        Tienda t2= new Tienda("Cll 167 #58a-20",2,"Surtir","6699132",true,4.7498466,-74.0623005,"123456456");
        Producto p3=new Producto(3,"Papas BBQ","Margarita","Papas");
        Producto p4=new Producto(4,"Coca-Cola","Coca-Cola","Gaseosa");
        Item i1= new Item(p1,t1,3000);
        Item i2=new Item(p2,t2,3500);
        Item i3=new Item(p1,t2,3000);
        Item i4=new Item(p3,t2,4500);
        Item i6= new Item(p4,t1,4500);
        Usuario u1 = new Usuario("name1","email1",1);
        ListaDeMercado lM1 = new ListaDeMercado(new Date(), false,1);
        ListaDeMercado lM2 = new ListaDeMercado(new Date(), false,2);
        ItemLista tL1 = new ItemLista(1,false,false);
        ItemLista tL2 = new ItemLista(2,false,false);
        ItemLista tL3 = new ItemLista(3,false,false);
        ItemLista tL4 = new ItemLista(4,false,false);
        ItemLista tL6 = new ItemLista(5,false,false);
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
