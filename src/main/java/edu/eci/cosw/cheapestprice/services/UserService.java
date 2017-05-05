package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.*;
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
     *
     * Agrega Cuenta
     * @param cuenta
     */
    public void addCuenta(Cuenta cuenta) throws CheapestPriceException;

    /**
     * Actualiza a un usuario existente
     * @param usuario
     */
    public void updateUser(int correo, Usuario usuario)throws CheapestPriceException;

    /**
     * Elimina una lista de mercado de un usuario
     * @throws CheapestPriceException
     */
    public void deleteShoppingList(int id)throws  CheapestPriceException;

    /**
     * Pone en favorito un item de la lista de mercado de un usuario
     * @param correo
     * @param nombreLista
     * @param productoId
     * @throws CheapestPriceException
     */
    public void favoriteShoppingListItem(int itemListaId,long productoId,int tiendaId,boolean fav)throws CheapestPriceException;

    /**
     * Elimina un item de la lista de mercado de un usuario
     * @throws CheapestPriceException
     */
    public void deleteSelectedItem(int id)throws CheapestPriceException;

    /**
     * Marca como comprado un item de la lista de mercado de un usuario
     * @param idProducto
     * @throws CheapestPriceException
     */
    public void sellSelectedItem(int itemListaId,long idProducto,int tiendaId, boolean comp)throws CheapestPriceException;

    /**
     * Agrega una lista de mercado
     * @throws CheapestPriceException
     */
    public void addShoppingList(ListaDeMercado listaDeMercado)throws CheapestPriceException;

    /**
     * Agrega una lista de mercado
     * @throws CheapestPriceException
     */
    public void addItemListaMercado(ItemLista itemLista)throws CheapestPriceException;
    /**
     *
     * Agrega un nuevo tendero
     * @param tendero
     */
    public void  addTendero(Tendero tendero)throws CheapestPriceException;

    List<Tendero> loadAllTenderos();
}
