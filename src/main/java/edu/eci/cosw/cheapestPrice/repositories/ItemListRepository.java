package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.ItemLista;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ger9410 on 20/03/17.
 */
public interface ItemListRepository extends JpaRepository<ItemLista, Integer> {
    @Modifying
    @Transactional
    @Query("update ItemLista il set il.comprado=:comp where il.id.listaCorreo=:correo and il.id.listaNombre=:listaNombre and il.id.productoId=:productoId and il.id.tiendaX=:tiendaX and il.id.tiendaY=:tiendaY and il.id.tiendaNit=:tiendaNit")
    public void sellItemSelected(@Param("correo") String correo,@Param("listaNombre")String listaNombre,@Param("productoId") long productoId,@Param("tiendaX")double tiendaX,@Param("tiendaY")double tiendaY,@Param("tiendaNit")String tiendaNit,@Param("comp") boolean comp);

    @Modifying
    @Transactional
    @Query("update ItemLista il set il.favorito=:fav where il.id.listaCorreo=:correo and il.id.listaNombre=:listaNombre and il.id.productoId=:productoId and il.id.tiendaX=:tiendaX and il.id.tiendaY=:tiendaY and il.id.tiendaNit=:tiendaNit")
    public void favoriteItemSelected(@Param("correo") String correo,@Param("listaNombre")String listaNombre,@Param("productoId") long productoId,@Param("tiendaX")double tiendaX,@Param("tiendaY")double tiendaY,@Param("tiendaNit")String tiendaNit,@Param("fav") boolean fav);
}
