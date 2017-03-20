package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Daniela on 20/03/17.
 */
public interface OpinionRepository extends JpaRepository<Opinion,Integer> {

}
