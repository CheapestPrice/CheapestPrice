package edu.eci.cosw.cheapestPrice.persistence;

import edu.eci.cosw.cheapestPrice.entities.ItemLista;
import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import org.eclipse.jetty.server.Authentication;

import java.util.List;

/**
 * Created by 2105403 on 2/20/17.
 */
public interface UserPersistence {

    /**
     * Retorna todas las listas de mercado
     * @return
     */
    public List<ListaDeMercado> loadAllShopList();

    /**
     * Retorna las listas de mercado de un usuario dado su nickname
     * @param nickname
     * @return
     */
    public List<ListaDeMercado> loadShopListByNickname(String nickname);

    /**
     * Retorna las listas de mercado de un usuario dado su email
     * @param email
     * @return
     */
    public List<ListaDeMercado> loadShopListByEmail(String email);

    /**
     * Retorna las listas de mercado de un usuario dado su nombre
     * @param name
     * @return
     */
    public List<ListaDeMercado> loadShopListByName(String name);

    /**
     * Agregar un nuevo usuario
     * @param usuario
     */
    public void saveUser(Usuario usuario);
}
