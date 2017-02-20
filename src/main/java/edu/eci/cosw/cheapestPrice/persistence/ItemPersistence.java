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
     *
     * @param item
     */
    public void addItem(Item item);
}
