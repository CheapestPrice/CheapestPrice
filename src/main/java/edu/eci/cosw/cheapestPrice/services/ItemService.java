package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.entities.TiendaId;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;

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
     * @param shopName el nombre de la tienda relacionada con el item
     * @param id el id del producto relacionado con el item
     * @return el item deseado
     * @throws CheapestPriceException si el item solicitado no existe o los parametros son nulos
     */
    public Item loadItem(String shopName,long id) throws CheapestPriceException;

    /**
     * Carga todos los items registrados a nombre de una tienda dada
     * @param tiendaId el identificador de la tienda
     * @return todos los items registrados a nombre de la tienda solicitada
     * @throws CheapestPriceException si shopName es vacío o de longitud 0
     */
    public List<Item> loadItemByShop(TiendaId tiendaId) throws CheapestPriceException;

    /**
     * Carga todos los items con una categoría dada
     * @param category la categoria con la cual se quieren buscar los items
     * @return todos los items con una categoría dada
     * @throws CheapestPriceException si  category es vacío o de longitud 0
     */
    public List<Item> loadItemByCategory(String category) throws CheapestPriceException;

    /**
     * Carga el item con el id especificado
     * @param id el id del item solicitado
     * @return todas las apariciones del item deseado
     * @throws CheapestPriceException si el id es menor a 0
     */
    public List<Item> loadItemById(long id) throws CheapestPriceException;

    /**
     * Carga un producto con el id del producto especifico
     * @param id el id del producto solicitado
     * @return el producto encontrado por el id
     * @throws CheapestPriceException si el id es menor a 0
     */
    public Producto loadProductById(long id) throws CheapestPriceException;

    /**
     * Registra un item
     * @param item el item a registrar
     * @throws CheapestPriceException si el item es nulo
     */
    public void addItem(Item item) throws CheapestPriceException;

    /**
     * Elimina un item registrado
     * @param id el id con el que el item se encuentra registrado
     * @param shopName el nombre de la tienda donde se encuentra registrado el item
     * @throws CheapestPriceException si el item es nulo o los parametros son nulos
     */
    public void deleteItem(String shopName,long id) throws CheapestPriceException;

    /**
     * Actualiza un item dado el id con el que se encuentra registrado
     * @param oldId el id con el que el item se encuentra registrado
     * @param item el item con los datos actuales
     * @param oldShop el nombre de la tienda donde se encuentra registrado el item
     * @throws CheapestPriceException si alguno de los parametros es nulo o no hay ningun item registrado con oldId o los nuevos datos de item no son validos
     */
    public void updateItem(long oldId,String oldShop,Item item) throws CheapestPriceException;
}
