package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Daniela on 20/03/17.
 */
public interface OpinionRepository extends JpaRepository<Opinion,Integer> {

    @Query("select o from Opinion o where o.tienda.id=:idtienda")
    public List<Opinion> loadOpinions(@Param("idtienda") int idtienda);

    @Query("select o from Opinion o where o.tienda.id=:idtienda and o.id=:#{#opinion.id}")
    public Opinion loadOpinion(@Param("idtienda") int idtienda,@Param("opinion") Opinion opinion);
}
