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
    @Query("update ItemLista il set il.comprado=:comp where il.id=:itemListaId ")
    public void sellItemSelected(@Param("itemListaId") int itemListaId,@Param("comp") boolean comp);

    @Modifying
    @Transactional
    @Query("update ItemLista il set il.favorito=:fav where il.id=:itemListaId")
    public void favoriteItemSelected(@Param("itemListaId") int itemListaId,@Param("fav") boolean fav);
}
