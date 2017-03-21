package edu.eci.cosw.cheapestPrice.repositories;


import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Blob;
import java.util.List;

/**
 * Created by masterhugo on 3/20/17.
 */
public interface ProductRepository extends JpaRepository<Producto, Long> {
    @Query("select p from Producto p")
    public List<Producto> loadAllProductos();
    @Query("update Producto p set p.nombre=:nombre where p.id=:#{#producto.id}")
    public void updateByName(@Param("producto") Producto producto, @Param("nombre") String nombre);
    @Query("update Producto p set p.marca=:marca where p.id=:#{#producto.id}")
    public void updateByMarca(@Param("producto") Producto producto,@Param("marca") String marca);
    @Query("update Producto p set p.categoria=:categoria where p.id=:#{#producto.id}")
    public void updateByCategoria(@Param("producto") Producto producto,@Param("categoria") String categoria);
    @Query("update Producto p set p.imagen=:logo where p.id=:#{#producto.id}")
    public void updateByImage(@Param("producto") Producto producto, @Param("logo") Blob logo);
}