package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by daniela on 14/03/17.
 */
public interface StoreRepository extends JpaRepository<Tienda,Integer>{

}