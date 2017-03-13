package edu.eci.cosw.cheapestPrice.persistence;

import edu.eci.cosw.cheapestPrice.entities.ItemLista;
import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import org.eclipse.jetty.server.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 2105403 on 2/20/17.
 */
@Service
public interface UserPersistence {

    /**
     * Retorna a todos los usuarios
     * @return
     */
    public Map<String,Usuario> loadAllUsuarios();

    /**
     * Retorna todas las listas de mercado
     * @return
     */
    public List<ListaDeMercado> loadAllShopList();

    /**
     * Retorna las listas de mercado de un usuario dado su email
     * @param email
     * @return
     */
    public List<ListaDeMercado> loadShopListByEmail(String email) throws CheapestPriceException;

    /**
     * Retorna un usuario especifico por su correo
     * @param correo
     * @return
     * @throws CheapestPriceException
     */
    public Usuario loadUserByEmail(String correo) throws CheapestPriceException;

    /**
     * Retorna las listas de mercado de un usuario dado su nombre
     * @param name
     * @return
     */
    public List<ListaDeMercado> loadShopListByName(String name) throws CheapestPriceException;

    /**
     *
     * Agrega usuarios
     * @param usuario
     */
    public void addUser(Usuario usuario) throws CheapestPriceException;

    /**
     * Agregar un nuevo usuario
     * @param usuario
     */
    public void updateUser(String oldNickname, Usuario usuario)throws CheapestPriceException;
}
