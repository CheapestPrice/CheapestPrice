package edu.eci.cosw.cheapestPrice.persistence;

import java.sql.Blob;
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


    /***
     * Registrar la tienda
     * @param tienda
     * @throws CheapestPriceException
     */
    public void deleteTienda(Tienda tienda) throws CheapestPriceException;

    /***
     * Consultar la tienda
     * @param idtienda
     * @throws CheapestPriceException
     */
    public Tienda consultTienda(TiendaId idtienda) throws CheapestPriceException;

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
    public List<Item> loadItems(TiendaId idtienda) throws CheapestPriceException;

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
     * @param  cambio
     * @param producto
     * @throws CheapestPriceException
     */
    public void modifyProductByCategoria(Producto producto, String cambio) throws CheapestPriceException;

    /**
     * Modificar producto registrado en la tienda
     * @param  cambio
     * @param producto
     * @throws CheapestPriceException
     */
    public void modifyProductByMarca(Producto producto, String cambio) throws CheapestPriceException;
    /**
     * Modificar producto registrado en la tienda
     * @param  cambio
     * @param producto
     * @throws CheapestPriceException
     */
    public void modifyProductByImage(Producto producto, Blob cambio) throws CheapestPriceException;

    /**
     * Modificar producto registrado en la tienda
     * @param  cambio
     * @param producto
     * @throws CheapestPriceException
     */
    public void modifyProductByNombre(Producto producto, String cambio) throws CheapestPriceException;

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

    /**
     * Agregar opinion a la tienda
     * @param opinion
     * @throws CheapestPriceException
     */
    public Opinion consultOpinion(TiendaId id,Opinion opinion) throws CheapestPriceException;

    /**
     * consultar lista de opiniones de la tienda
     * @return  opiniones
     * @throws CheapestPriceException
     */
    public List<Opinion> consultOpiniones(TiendaId id) throws CheapestPriceException;

    /***
     * Consultar las tiendas
     * @return  tiendas
     * @throws CheapestPriceException
     */
    public List<Tienda> consultShop() throws CheapestPriceException;

}
