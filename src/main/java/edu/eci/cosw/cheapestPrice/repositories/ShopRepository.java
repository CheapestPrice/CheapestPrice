package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.Tienda;
import edu.eci.cosw.cheapestPrice.entities.TiendaId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Daniela on 14/03/17.
 */
public interface ShopRepository extends JpaRepository<Tienda,TiendaId>{

    
}
