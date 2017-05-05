package edu.eci.cosw.cheapestPrice.repositories;


import edu.eci.cosw.cheapestPrice.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Created by masterhugo on 3/18/17.
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Query("select i from Item i where i.tienda.id=:id")
    public List<Item> loadItemsByShop(@Param("id") int id);
}
