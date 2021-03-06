package edu.eci.cosw.cheapestPrice.persistence;

import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import org.eclipse.jetty.server.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 2105403 on 2/20/17.
 */
//@Service
public interface UserPersistence {

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
    public void updateUser(int correo, Usuario usuario)throws CheapestPriceException;

    /**
     * Elimina una lista de mercado segun su nombre
     * @param id
     * @throws CheapestPriceException
     */
    public void deleteShoppingList(int id)throws CheapestPriceException;

    /**
     * Pone en favorito un elemento de una lista de mercado de un usuario
     * @throws CheapestPriceException
     */
    public void favoriteShoppingListItem(int itemListaId, boolean fav)throws CheapestPriceException;

    /**
     * Elimina un item de la lista de mercado de un usuario
     * @throws CheapestPriceException
     */
    public void deleteSelectedItem(int id)throws CheapestPriceException;

    /**
     * Item comprado
     * @param comp
     * @throws CheapestPriceException
     */
    public void sellSelectedItem(int itemListaId, boolean comp)throws CheapestPriceException;

    /**
     * Agrega una lista de mercado
     * @throws CheapestPriceException
     */
    public void addShoppingList(ListaDeMercado listaDeMercado)throws CheapestPriceException;

    public void addItemListaMercado(ItemLista itemLista)throws CheapestPriceException;
    /**
     *
     * Agrega una cuenta
     * @param cuenta
     */
    void addCuenta(Cuenta cuenta)throws CheapestPriceException;
    /**
     *
     * Agrega un tendero
     * @param tendero
     */
    void addTendero(Tendero tendero)throws CheapestPriceException;

    List<Tendero> loadAllTenderos();

    Usuario load(int id);

    List<ListaDeMercado> loadShopList(int id);

    ListaDeMercado loadListaUsuario(int uId,int lId);

    Cuenta login(String correo, String hash);
    Cuenta loadCuenta(int id);

    Tendero loadTendero(int userId);
}
