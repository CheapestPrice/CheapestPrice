package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Opinion;
import edu.eci.cosw.cheapestPrice.entities.Tienda;
import edu.eci.cosw.cheapestPrice.entities.TiendaId;
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
public interface ShopRepository extends JpaRepository<Tienda,TiendaId>{

    @Query("select t.items from Tienda t where t.id.nit=:#{#idtienda.nit} and t.id.x=:#{#idtienda.x} and t.id.y=:#{#idtienda.y}")
    public List<Item> loadItems(@Param("idtienda") TiendaId idtienda);

    @Query("select i from Item i where i.tienda.id.nit=:#{#idtienda.nit} and i.tienda.id.x=:#{#idtienda.x} and i.tienda.id.y=:#{#idtienda.y} and i.producto.id=:idproducto")

    public Item loadItem(@Param("idtienda") TiendaId idtienda,@Param("idproducto") long idprodcuto);
    @Modifying
    @Transactional
    @Query("update Tienda t set t.logo=:logo where t.id.nit=:#{#idtienda.nit} and t.id.x=:#{#idtienda.x} and t.id.y=:#{#idtienda.y}")
    public void modifyLogo(@Param("idtienda") TiendaId idtienda, @Param("logo") Blob logo);

    @Modifying
    @Transactional
    @Query("update Tienda t set t.telefono=:telefono where t.id.nit=:#{#idtienda.nit} and t.id.x=:#{#idtienda.x} and t.id.y=:#{#idtienda.y}")
    public void modifyTelephone(@Param("idtienda") TiendaId idtienda, @Param("telefono") String telefono);

    @Query("select o from Opinion o where o.tienda.id.nit=:#{#idtienda.nit} and o.tienda.id.x=:#{#idtienda.x} and o.tienda.id.y=:#{#idtienda.y}")
    public List<Opinion> loadOpinions(@Param("idtienda") TiendaId idtienda);

    @Query("select o from Opinion o where o.tienda.id.nit=:#{#idtienda.nit} and o.tienda.id.x=:#{#idtienda.x} and o.tienda.id.y=:#{#idtienda.y} and o.id=:#{#opinion.id}")
    public Opinion loadOpinion(@Param("idtienda") TiendaId idtienda,@Param("opinion") Opinion opinion);

    @Query("select i from Item i where i.tienda.id.nit=:nit and i.tienda.id.x=:x and i.tienda.id.y=:y and i.producto.id=:idproducto")
    public Item loadItem(@Param("nit") String nit, @Param("x") double x,@Param("y") double y,@Param("idproducto") long idprodcuto);


}
