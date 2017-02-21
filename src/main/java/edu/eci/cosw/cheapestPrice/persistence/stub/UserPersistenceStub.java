package edu.eci.cosw.cheapestPrice.persistence.stub;

import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 2105403 on 2/21/17.
 */
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
    public List<ListaDeMercado> loadShopListByEmail(String email) {
        return null;
    }

    @Override
    public List<ListaDeMercado> loadShopListByName(String name) {
        return null;
    }

    @Override
    public void updateUser(Usuario usuario) {

    }
}
