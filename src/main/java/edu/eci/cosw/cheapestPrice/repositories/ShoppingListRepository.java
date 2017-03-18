package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.ListaMercado_Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by daniela on 18/03/17.
 */
public interface ShoppingListRepository extends JpaRepository<ListaDeMercado,ListaMercado_Item> {
}
