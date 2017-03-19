package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * Created by 2105403 on 3/16/17.
 */
public interface UserRepository extends JpaRepository<Usuario,String> {

    @Query("select u from Usuario u where u.correo = ?1")
    public Usuario loadUserByEmail(String correo);

    @Query("delete from Usuario u where u.correo=?1")
    public void deleteUser(String correo);

    @Query("select u.listas from Usuario u where u.correo=?1")
    public List<ListaDeMercado> loadShoppingListByUserEmail(String correo);

    @Query("select u from Usuario u")
    public List<Usuario> loadAllUsers();
}
