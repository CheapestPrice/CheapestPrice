package edu.eci.cosw.cheapestPrice.persistence;

import com.mysql.jdbc.Blob;
import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Daniela on 19/02/2017.
 */
public interface ShopPersistence {
    /***
     * Registrar la tienda
     * @param tienda
     * @throws CheapestPriceException
     */
    public void addTienda(Tienda tienda) throws CheapestPriceException;

    /**
     * Carga un item de la tienda
     * @param id
     * @return item
     */
    public Item loadItem(long id)throws CheapestPriceException;

    /**
     * Carga todos los items registrados en la tienda
     * @return todos los items de la tienda
     */
    public List<Item> loadItems();

    /**
     * Registrar un nuevo producto a la tienda
     * @param producto
     * @throws CheapestPriceException
     */
    public void addProduct(Producto producto) throws CheapestPriceException;

    /**
     * Eliminar producto registrado en la tienda
     * @param idproducto
     * @throws CheapestPriceException
     */
    public void deleteProduct(long idproducto) throws CheapestPriceException;

    /**
     * Modificar producto registrado en la tienda
     * @param  idproducto
     * @param producto
     * @throws CheapestPriceException
     */
    public void modifyProduct(long idproducto, Producto  producto)throws CheapestPriceException;

    /**
     * Modificar horario de la tienda
     * @param dia
     * @param horario
     * @throws CheapestPriceException
     */
    public void modifyHorary(String dia, Horario horario) throws CheapestPriceException;

    /**
     * Modificar telefono de la tienda
     * @param telefono
     * @throws CheapestPriceException
     */
    public void modifyTelephone(String telefono) throws CheapestPriceException;

    /**
     *  Verificar si la tienda esta abierta
     *  @param fecha
     *  @throws CheapestPriceException
     */
    public boolean isOpen(Timestamp fecha) throws CheapestPriceException;

    /**
     * Agregar opinion a la tienda
     * @param opinion
     * @throws CheapestPriceException
     */
    public void addOpinion(Opinion opinion) throws CheapestPriceException;

    /***
     * Modificar el logo de la tienda
     * @param logo
     * @throws CheapestPriceException
     */
    public void modifyLogo(Blob logo) throws CheapestPriceException;

}
