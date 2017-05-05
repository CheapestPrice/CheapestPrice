package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Opinion;
import edu.eci.cosw.cheapestPrice.entities.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Blob;
import java.util.List;

/**
 * Created by Daniela on 14/03/17.
 */
public interface ShopRepository extends JpaRepository<Tienda,Integer>{

    @Query("select t.items from Tienda t where t.id=:idtienda")
    public List<Item> loadItems(@Param("idtienda") int idtienda);

    @Query("select i from Item i where i.tienda.id=:idtienda and i.producto.id=:iditem")
    public Item loadItem(@Param("idtienda") int idtienda,@Param("iditem") long iditem);
    @Modifying
    @Transactional
    @Query("update Tienda t set t.logo=:logo where t.id=:idtienda")
    public void modifyLogo(@Param("idtienda") int idtienda, @Param("logo") Blob logo);

    @Modifying
    @Transactional
    @Query("update Tienda t set t.telefono=:telefono where t.id=:idtienda")
    public void modifyTelephone(@Param("idtienda") int idtienda, @Param("telefono") String telefono);

    @Query("select o from Opinion o where o.tienda.id=:idtienda")
    public List<Opinion> loadOpinions(@Param("idtienda") int idtienda);

    @Query("select o from Opinion o where o.tienda.id=:idtienda and o.id=:#{#opinion.id}")
    public Opinion loadOpinion(@Param("idtienda") int idtienda,@Param("opinion") Opinion opinion);



}
