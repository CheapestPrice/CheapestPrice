package edu.eci.cosw.cheapestPrice.repositories;


import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.ItemId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by masterhugo on 3/18/17.
 */
public interface ItemRepository extends JpaRepository<Item, ItemId> {

}
