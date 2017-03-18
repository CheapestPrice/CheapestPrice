package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Horario;
import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Opinion;
import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by daniela on 18/03/17.
 */
public interface ShopService {

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
     *  @throws CheapestPriceException
     */
    public boolean isOpen() throws CheapestPriceException;

    /**
     * Agregar opinion a la tienda
     * @param opinion
     * @throws CheapestPriceException
     */
    public void addOpinion(Opinion opinion) throws CheapestPriceException;

    /***
     * Modificar el logo de la tienda
     *
     */
    public void modifyLogo() throws CheapestPriceException;

}
