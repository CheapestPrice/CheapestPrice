package edu.eci.cosw.cheapestPrice.persistence;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;

import java.util.List;

/**
 * Created by Julian David Devia Serna on 2/19/17.
 */
public interface ItemPersistence {

    /**
     * Carga todos los items registrados
     * @return todos los items registrados
     */
    public List<Item> loadItems();

    /**
     * Carga todos los items registrados a nombre de una tienda dada
     * @param shopName el nombre de la tienda deseada
     * @return todos los items registrados a nombre de la tienda solicitada
     * @throws CheapestPriceException si shopName es vacío o de longitud 0
     */
    public List<Item> loadItemByShop(String shopName) throws CheapestPriceException;

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
     * Registra un item
     * @param item el item a registrar
     * @throws CheapestPriceException si el item es nulo o ya se encuentra registrado
     */
    public void addItem(Item item) throws CheapestPriceException;

    /**
     * Elimina un item registrado
     * @param item el item a eliminar
     * @throws CheapestPriceException si el item es nulo o no se encuentra registrado
     */
    public void deleteItem(Item item) throws CheapestPriceException;

    /**
     * Actualiza un item dado el id con el que se encuentra registrado
     * @param oldId el id con el que el item se encuentra registrado
     * @param item el item con los datos actuales
     * @param oldShop el nombre de la tienda donde se encuentra registrado el item
     * @throws CheapestPriceException si alguno de los parametros es nulo o no hay ningun item registrado con oldId
     */
    public void updateItem(long oldId,String oldShop,Item item) throws CheapestPriceException;
}
