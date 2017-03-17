package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import edu.eci.cosw.cheapestPrice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by 2105403 on 3/17/17.
 */
public class UsuarioService implements UserPersistence{
    @Autowired
    UserRepository us;


    @Override
    public Map<String, Usuario> loadAllUsuarios() {
        return null;
    }

    @Override
    public List<ListaDeMercado> loadAllShopList() {
        return null;
    }

    @Override
    public List<ListaDeMercado> loadShopListByEmail(String email) throws CheapestPriceException {
        return null;
    }

    @Override
    public Usuario loadUserByEmail(String correo) throws CheapestPriceException {
        return null;
    }

    @Override
    public List<ListaDeMercado> loadShopListByName(String name) throws CheapestPriceException {
        return null;
    }

    @Override
    public void addUser(Usuario usuario) throws CheapestPriceException {
        us.save(usuario);
    }

    @Override
    public void updateUser(String oldNickname, Usuario usuario) throws CheapestPriceException {

    }
}
