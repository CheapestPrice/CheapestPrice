package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceExcepciton;

import java.util.Set;

/**
 * Created by
 */
public interface ProductService {
    /**
     * getAllProducts nos devuelve todos los productos almacenados
     * @return un conjunto de los productos almacenas
     */
    public abstract Set<Producto> getAllProducts();

    /**
     * getProductById nos devuelve el producto por id
     * @param id - el identificador el producto
     * @return el producto localizado con el identificador -id-
     * @throws CheapestPriceExcepciton si el id es negativo
     * @throws CheapestPriceExcepciton si el id no es encontrado
     */
    public abstract Producto getProductById(long id) throws CheapestPriceExcepciton;

    /**
     * getAllProductsByName nos devuelve un conjunto con productos encontrados por el nombre
     * @param name - nombre del producto
     * @return un conjunto de productos por el nombre -name-
     * @throws CheapestPriceExcepciton
     */
    public abstract Set<Producto> getAllProductsByName(String name) throws CheapestPriceExcepciton;


    public abstract Set<Producto> getAllProductsByPrice(long price) throws CheapestPriceExcepciton;


    public abstract Set<Producto> getAllProductsByTrademark(String marca)throws CheapestPriceExcepciton;


    public abstract Set<Producto> getAllProductsByCategory(String categoria)throws CheapestPriceExcepciton;


    public abstract boolean addProduct(Producto producto)throws CheapestPriceExcepciton;


    public abstract boolean updateProduct(Producto producto)throws CheapestPriceExcepciton;


    public abstract boolean deleteProduct(long id)throws CheapestPriceExcepciton;

}
