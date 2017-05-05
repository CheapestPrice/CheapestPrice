package edu.eci.cosw.cheapestPrice.repositories;


import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Blob;
import java.util.List;

/**
 * Created by masterhugo on 3/20/17.
 */
public interface ProductRepository extends JpaRepository<Producto, Long> {
    @Query("select count(p) from Producto p")
    public long countProductos();
    @Query("select p from Producto p where p.nombre=:nombre")
    public List<Producto> loadProductsByName(@Param("nombre") String nombre);
    @Query("select p from Producto p where p.categoria=:categoria")
    public List<Producto> loadProductsByCategoria(@Param("categoria") String categoria);
    @Query("select p from Producto p where p.marca=:marca")
    public List<Producto> loadProductsByMarca(@Param("marca") String marca);
    @Query("update Producto p set p.nombre=:nombre where p.id=:#{#producto.id}")
    public void updateByName(@Param("producto") Producto producto, @Param("nombre") String nombre);
    @Query("update Producto p set p.marca=:marca where p.id=:#{#producto.id}")
    public void updateByMarca(@Param("producto") Producto producto,@Param("marca") String marca);
    @Query("update Producto p set p.categoria=:categoria where p.id=:#{#producto.id}")
    public void updateByCategoria(@Param("producto") Producto producto,@Param("categoria") String categoria);
    @Modifying
    @Transactional
    @Query("update Producto p set p.imagen=:logo where p.nombre=:nombre and p.marca=:marca and p.categoria=:categoria")
    public void updateByImage(@Param("nombre") String nombre,@Param("marca") String marca,@Param("categoria") String categoria , @Param("logo") Blob logo);
    @Modifying
    @Transactional
    @Query("update Producto p set p.imagen=:logo where p.id=:id")
    public void updateImage(@Param("id") int id , @Param("logo") Blob logo);
}
