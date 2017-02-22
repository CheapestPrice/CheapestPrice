package edu.eci.cosw.cheapestPrice.persistence.stub;

import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 2105403 on 2/21/17.
 */
@Service
public class UserPersistenceStub implements UserPersistence{

    private Map<String,Usuario> usuarios;

    public UserPersistenceStub(){
        usuarios = new HashMap<>();
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
    public void updateUser(String oldNickname, Usuario usuario) throws CheapestPriceException{
        if(usuario==null && usuarios.get(oldNickname)!=null) throw new CheapestPriceException("El usuario tiene que existir");
        usuarios.remove(usuarios.get(oldNickname));
        usuarios.put(usuario.getNickname(),usuario);
    }
}
