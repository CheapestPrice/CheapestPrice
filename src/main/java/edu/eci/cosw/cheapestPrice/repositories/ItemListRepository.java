package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.ItemLista;
import edu.eci.cosw.cheapestPrice.entities.ItemListaId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by ger9410 on 20/03/17.
 */
public interface ItemListRepository extends JpaRepository<ItemLista, ItemListaId> {
}
