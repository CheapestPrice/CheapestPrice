package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.ItemLista;
import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by daniela on 18/03/17.
 */
public interface ShoppingListRepository extends JpaRepository<ListaDeMercado,Integer> {

    @Query("select i from ItemLista i where i.id=:ilId and i.lista.id=:lId")
    public ItemLista loadItemListaByLista(int lId,int ilId);

}
