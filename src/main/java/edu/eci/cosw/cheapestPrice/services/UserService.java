package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;

import java.util.List;

/**
 * Created by masterhugo on 3/18/17.
 */
public interface UserService {

    /**
     * Retorna a todos los usuarios
     * @return
     */
    public List<Usuario> loadAllUsuarios();


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
     *
     * Agrega un nuevo usuario
     * @param usuario
     */
    public void addUser(Usuario usuario) throws CheapestPriceException;

    /**
     * Actualiza a un usuario existente
     * @param usuario
     */
    public void updateUser(String correo, Usuario usuario)throws CheapestPriceException;

    /**
     * Elimina una lista de mercado de un usuario
     * @param correo
     * @param nombreLista
     * @throws CheapestPriceException
     */
    public void deleteShoppingList(String correo, String nombreLista)throws  CheapestPriceException;

    /**
     * Pone en favorito un item de la lista de mercado de un usuario
     * @param correo
     * @param nombreLista
     * @param productoId
     * @param nombreTienda
     * @throws CheapestPriceException
     */
    public void favoriteShoppingListItem(String correo,String nombreLista,long productoId,String nombreTienda)throws CheapestPriceException;

}
