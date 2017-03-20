package edu.eci.cosw.cheapestPrice.repositories;


import edu.eci.cosw.cheapestPrice.entities.Producto;
import edu.eci.cosw.cheapestPrice.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by masterhugo on 3/20/17.
 */
public interface ProductRepository extends JpaRepository<Producto, Long> {
    @Query("select p from Producto p")
    public List<Producto> loadAllProductos();
    @Query("update Producto p set p.nombre=:producto.nombre where p.id=:producto.id")
    public List<Producto> updateByName(@Param("producto") Producto producto);
    @Query("update Producto p set p.marca=:producto.marca where p.id=:producto.id")
    public List<Producto> updateByMarca(@Param("producto") Producto producto);
    @Query("update Producto p set p.categoria=:producto.categoria where p.id=:producto.id")
    public List<Producto> updateByCategoria(@Param("producto") Producto producto);

}
