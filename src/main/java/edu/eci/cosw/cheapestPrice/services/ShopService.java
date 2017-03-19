package edu.eci.cosw.cheapestPrice.services;

import java.sql.Blob;
import edu.eci.cosw.cheapestPrice.entities.*;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Daniela on 18/03/17.
 */
public interface ShopService {

    /***
     * Registrar la tienda
     * @param tienda
     * @throws CheapestPriceException
     */
    public void addTienda(Tienda tienda) throws CheapestPriceException;

    /**
     * Modificar la tienda
     * @param id
     * @param tienda
     * @throws CheapestPriceException
     */
    public void modifyTienda(TiendaId id, Tienda tienda) throws CheapestPriceException;

    /**
     * Carga todos los items registrados en la tienda
     * @return todos los items de la tienda
     */
    public List<Item> loadItems(TiendaId idtienda,long idproducto);

    /**
     * Carga un item de la tienda
     * @param idproducto
     * @param idtienda
     * @return item
     */
    public Item loadItem(TiendaId idtienda,long idproducto)throws CheapestPriceException;

    /**
     * Registrar un nuevo producto a la tienda
     * @param producto
     * @throws CheapestPriceException
     */
    public void addProduct(TiendaId id,Producto producto) throws CheapestPriceException;

    /**
     * Eliminar producto registrado en la tienda
     * @param idproducto
     * @throws CheapestPriceException
     */
    public void deleteProduct(TiendaId id,long idproducto) throws CheapestPriceException;

    /**
     * Modificar producto registrado en la tienda
     * @param  idproducto
     * @param producto
     * @throws CheapestPriceException
     */
    public void modifyProduct(TiendaId id,long idproducto, Producto  producto)throws CheapestPriceException;

    /**
     * Modificar horario de la tienda
     * @param dia
     * @param horario
     * @throws CheapestPriceException
     */
    public void modifyHorary(TiendaId id,String dia, Horario horario) throws CheapestPriceException;

    /**
     * Modificar telefono de la tienda
     * @param telefono
     * @throws CheapestPriceException
     */
    public void modifyTelephone(TiendaId id,String telefono) throws CheapestPriceException;

    /**
     *  Verificar si la tienda esta abierta
     *  @param fecha
     *  @throws CheapestPriceException
     */
    public boolean isOpen(TiendaId id,Timestamp fecha) throws CheapestPriceException;

    /**
     * Agregar opinion a la tienda
     * @param opinion
     * @throws CheapestPriceException
     */
    public void addOpinion(TiendaId id,Opinion opinion) throws CheapestPriceException;

    /***
     * Modificar el logo de la tienda
     * @param logo
     * @throws CheapestPriceException
     */

    public void modifyLogo(TiendaId id,Blob logo) throws CheapestPriceException;


}
