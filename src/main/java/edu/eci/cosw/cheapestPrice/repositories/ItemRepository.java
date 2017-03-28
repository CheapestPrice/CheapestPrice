package edu.eci.cosw.cheapestPrice.repositories;


import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.ItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Created by masterhugo on 3/18/17.
 */
public interface ItemRepository extends JpaRepository<Item, ItemId> {
    @Query("select i from Item i where i.tienda.id.nit=:nit and i.tienda.id.x=:x and i.tienda.id.y=:y")
    public List<Item> loadItemsByShop(@Param("nit") String nit, @Param("x") double x, @Param("y") double y);
}
