package edu.eci.cosw.cheapestPrice.persistence.stub;

import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by 2105403 on 2/21/17.
 */
@Service
public class UserPersistenceStub implements UserPersistence{

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Map<String, Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    private Map<String,Usuario> usuarios;

    public UserPersistenceStub() throws CheapestPriceException {
        usuarios = new HashMap<>();
        UserPersistenceStub.poblarStub(this);

        prueba(this);
    }

    @Override
    public Map<String,Usuario> loadAllUsuarios(){
        return usuarios;
    }

    @Override
    public Usuario loadUsuarioByNickname(String nickname) throws CheapestPriceException{
        if(nickname.length()==0 || nickname==null) throw  new CheapestPriceException("Favor colocar un nickname apropiado");
        if(usuarios.get(nickname)==null) throw new CheapestPriceException("El usuario con nickname "+nickname+" no esta registrado");
        return usuarios.get(nickname);
    }

    @Override
    public List<ListaDeMercado> loadAllShopList() {
        List<ListaDeMercado> listas = new ArrayList<>();
        for(Usuario u: usuarios.values()){
            for(ListaDeMercado lM : u.getListas()){
                listas.add(lM);
            }
        }
        return listas;
    }

    @Override
    public List<ListaDeMercado> loadShopListByNickname(String nickname) throws CheapestPriceException{
        if(nickname.length()==0 || nickname==null) throw new CheapestPriceException("El nickname del usuario no puede ser nulo");
        List<ListaDeMercado> listas = new ArrayList<>();
        listas=(usuarios.get(nickname).getListas());
        return listas;
    }

    @Override
    public List<ListaDeMercado> loadShopListByEmail(String email) throws CheapestPriceException {
        if(email.length()==0 || email==null) throw new CheapestPriceException("El email del usuario no puede ser nulo");
        List<ListaDeMercado> listas = new ArrayList<>();
        listas=(usuarios.get(email).getListas());
        return listas;
    }

    @Override
    public List<ListaDeMercado> loadShopListByName(String name)throws  CheapestPriceException {
        if(name.length()==0 || name==null) throw new CheapestPriceException("El email del usuario no puede ser nulo");
        List<ListaDeMercado> listas = new ArrayList<>();
        listas=(usuarios.get(name).getListas());
        return listas;
    }
    @Override
    public void addUser(Usuario usuario)throws CheapestPriceException{
        System.out.println("Sirvio!: "+ usuario.getNickname());
        if(usuarios.get(usuario.getNickname())!=null) throw new CheapestPriceException("El usuario "+usuario.getNickname()+" ya está registrado");
        usuarios.put(usuario.getNickname(),usuario);

    }

    @Override
    public void updateUser(String oldNickname, Usuario usuario) throws CheapestPriceException{
        if(usuario==null && usuarios.get(oldNickname)!=null) throw new CheapestPriceException("El usuario tiene que existir");
        usuarios.remove(usuarios.get(oldNickname));
        usuarios.put(usuario.getNickname(),usuario);
    }

    public static void poblarStub(UserPersistenceStub ups){
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
        ItemLista tL1 = new ItemLista(i1.getTienda(), i1.getProducto(),false,false);
        ItemLista tL2 = new ItemLista(i2.getTienda(), i2.getProducto(),false,false);
        ItemLista tL3 = new ItemLista(i3.getTienda(), i3.getProducto(),false,false);
        ItemLista tL4 = new ItemLista(i4.getTienda(), i4.getProducto(),false,false);
        ItemLista tL5 = new ItemLista(i5.getTienda(), i5.getProducto(),false,false);
        ItemLista tL6 = new ItemLista(i6.getTienda(), i6.getProducto(),false,false);
        List<ItemLista> lIL1 = new ArrayList<>();
        List<ItemLista> lIL2 = new ArrayList<>();
        List<ItemLista> lIL3 = new ArrayList<>();
        lIL1.add(tL1);
        lIL1.add(tL2);
        lIL2.add(tL3);
        lIL2.add(tL4);
        lIL3.add(tL5);
        lIL3.add(tL6);
        ListaDeMercado lM1 = new ListaDeMercado("Lista1", new Date(), false);
        lM1.setItems(lIL1); lM1.setItems(lIL2);
        ListaDeMercado lM2 = new ListaDeMercado("Lista2", new Date(), false);
        lM2.setItems(lIL3);
        List<ListaDeMercado> listas = new ArrayList<>();
        listas.add(lM1); listas.add(lM2);
        Usuario u1 = new Usuario("name1","email1","nickname1", listas);
        try{
            ups.addUser(u1);
        }catch (CheapestPriceException e){
            e.printStackTrace();
        }
    }

    private static void prueba(UserPersistenceStub ups) throws CheapestPriceException {

        Usuario u=new Usuario("nombre","prueba@prueba.com","pruebaa");
        ups.addUser(u);

    }
}
