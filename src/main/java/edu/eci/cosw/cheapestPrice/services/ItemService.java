package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;

import java.sql.Blob;
import java.util.List;

/**
 * Created by Julian David Devia Serna on 2/20/17.
 */
public interface ItemService {

    /**
     * Carga todos los items registrados
     * @return todos los items registrados
     */
    public List<Item> loadItems();

    /**
     * Retorna el item deseado
     * @param shop el id de la tienda relacionada con el item
     * @param idItem el ide del item
     * @return el item deseado
     * @throws CheapestPriceException si el item solicitado no existe o los parametros son nulos
     */
    public Item loadItem(int shop,int idItem) throws CheapestPriceException;

    /**
     * Carga todos los items registrados a nombre de una tienda dada
     * @param tiendaId el identificador de la tienda
     * @return todos los items registrados a nombre de la tienda solicitada
     * @throws CheapestPriceException si shopName es vacío o de longitud 0
     */
    public List<Item> loadItemByShop(int tiendaId) throws CheapestPriceException;

    /**
     * Carga todos los items con una categoría dada
     * @param category la categoria con la cual se quieren buscar los items
     * @return todos los items con una categoría dada
     * @throws CheapestPriceException si  category es vacío o de longitud 0
     */
    public List<Item> loadItemsByCategory(String category) throws CheapestPriceException;

    /**
     * Carga el item con el id especificado
     * @param id el id del item solicitado
     * @return todas las apariciones del item deseado
     * @throws CheapestPriceException si el id es menor a 0
     */
    public Item loadItemById(int id) throws CheapestPriceException;

    /**
     * Registra un item
     * @param item el item a registrar
     * @throws CheapestPriceException si el item es nulo
     */
    public void addItem(Item item) throws CheapestPriceException;

    /**
     * Elimina un item registrado
     * @param idItem el id con el que el item se encuentra registrado
     * @param idShop el nombre de la tienda donde se encuentra registrado el item
     * @throws CheapestPriceException si el item es nulo o los parametros son nulos
     */
    public void deleteItem(int idShop,int idItem) throws CheapestPriceException;

    /**
     * Actualiza un item de la tienda en la que se encuentra registrado
     * @param item el item con los datos actuales
     * @throws CheapestPriceException si alguno de los parametros es nulo o no hay ningun item registrado con oldId o los nuevos datos de item no son validos
     */
    public void updateItem(Item item) throws CheapestPriceException;

    /**
     * Actualiza la imagen del producto bajo el nombre, la marca y categoria
     * @param imagen la imagen a actualizar
     * @param nombre el nombre del producto
     * @param marca la marca del producto
     * @param categoria la categoria del producto
     * @throws CheapestPriceException si alguno de los parametros es nulo o no hay ningun producto registrado
     */
    void updateProductImage(Blob imagen, String nombre, String marca, String categoria) throws CheapestPriceException;

    /**
     * Carga todos los productos registrados
     * @return todos los productos registrados
     */
    public List<Producto> getProducts();
}
