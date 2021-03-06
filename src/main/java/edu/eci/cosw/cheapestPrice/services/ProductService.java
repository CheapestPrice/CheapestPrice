package edu.eci.cosw.cheapestPrice.services;

import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;

import java.sql.Blob;
import java.util.List;
import java.util.Set;

/**
 * Created by Hugo Alvarez
 */
public interface ProductService {
    /**
     * getAllProducts nos devuelve todos los productos almacenados
     * @return un conjunto de los productos almacenas
     */
    public abstract List<Producto> getAllProducts();

    /**
     * getProductById nos devuelve el producto por id
     * @param id - el identificador el producto
     * @return el producto localizado con el identificador -id-
     * @throws CheapestPriceException si el id es negativo
     * @throws CheapestPriceException si el id no es encontrado
     */
    public abstract Producto getProductById(long id) throws CheapestPriceException;

    /**
     * getAllProductsByName nos devuelve un conjunto con productos encontrados por el nombre
     * @param name - nombre del producto
     * @return un conjunto de productos por el nombre -name-
     * @throws CheapestPriceException si name es vacio o de longitud 0
     */
    public abstract List<Producto> getAllProductsByName(String name) throws CheapestPriceException;


    /**
     * getAllProductsByTrademark nos devuelve un conjunto con productos encontrados por su marca
     * @param marca - la marca del producto
     * @return un conjunto de productos por la marca -marca-
     * @throws CheapestPriceException si marca es vacio o de longitud 0
     */
    public abstract List<Producto> getAllProductsByTrademark(String marca)throws CheapestPriceException;

    /**
     * getAllProductsByCategory nos devuelve un conjunto con productos encontrados por la categoria
     * @param categoria - la categoria del producto
     * @return un conjunto de productos por la categoria -categoria-
     * @throws CheapestPriceException si categoria es vacio o de longitud 0
     */
    public abstract List<Producto> getAllProductsByCategory(String categoria)throws CheapestPriceException;

    /**
     * addProduct nos agrega el producto en el almacen
     * @param producto - el producto a agregar al almacen
     * @throws CheapestPriceException si el producto es incompleto(falta alguna caracteristica)
     * @throws CheapestPriceException si el producto existe
     * @throws CheapestPriceException si el producto es nulo
     */
    public abstract void addProduct(Producto producto)throws CheapestPriceException;

    /**
     * * updateProduct nos actualiza un producto EXISTENTE
     * @param producto - el prodcuto a actualizar
     * @throws CheapestPriceException si el producto no existe
     * @throws CheapestPriceException si el producto es incompleto(falta alguna caracteristica)
     * @throws CheapestPriceException si el producto es nulo
     */
    public abstract void updateProductByMarca(Producto producto, String marca)throws CheapestPriceException;

    /**
     * updateProduct nos actualiza un producto EXISTENTE
     * @param producto - el prodcuto a actualizar
     * @throws CheapestPriceException si el producto no existe
     * @throws CheapestPriceException si el producto es incompleto(falta alguna caracteristica)
     * @throws CheapestPriceException si el producto es nulo
     */
    public abstract void updateProductByCategoria(Producto producto, String categoria)throws CheapestPriceException;

    /**
     * updateProduct nos actualiza un producto EXISTENTE
     * @param producto - el prodcuto a actualizar
     * @throws CheapestPriceException si el producto no existe
     * @throws CheapestPriceException si el producto es incompleto(falta alguna caracteristica)
     * @throws CheapestPriceException si el producto es nulo
     */
    public abstract void updateProductByName(Producto producto, String name)throws CheapestPriceException;

    /**
     * updateProduct nos actualiza un producto EXISTENTE
     * @param producto - el prodcuto a actualizar
     * @throws CheapestPriceException si el producto no existe
     * @throws CheapestPriceException si el producto es incompleto(falta alguna caracteristica)
     * @throws CheapestPriceException si el producto es nulo
     */
    public abstract void updateProductByImage(Producto producto, Blob image)throws CheapestPriceException;

    /**
     * deleteProduct nos elimina un producto existente
     * @param producto - el producto a eliminar
     * @throws CheapestPriceException si el producto no existe
     * @throws CheapestPriceException si el producto es incompleto(falta alguna caracteristica)
     * @throws CheapestPriceException si el producto es nulo
     */
    public abstract void deleteProduct(Producto producto)throws CheapestPriceException;

}
