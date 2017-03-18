package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import edu.eci.cosw.cheapestPrice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 2105403 on 3/17/17.
 */
@Service
public class UsuarioService implements UserPersistence{
    @Autowired
    UserRepository us;


    @Override
    public List<Usuario> loadAllUsuarios() {

        return us.loadAllUsers();
    }


    @Override
    public List<ListaDeMercado> loadShopListByEmail(String correo) throws CheapestPriceException {
        return us.loadShoppingListByUserEmail(correo);
    }

    @Override
    public Usuario loadUserByEmail(String correo) throws CheapestPriceException {
      return  us.loadUserByEmail(correo);
    }


    @Override
    public void addUser(Usuario usuario) throws CheapestPriceException {
        us.save(usuario);
    }

    @Override
    public void updateUser(String oldEmail, Usuario usuario) throws CheapestPriceException {
        us.deleteUser(oldEmail);
        us.save(usuario);
    }
}
