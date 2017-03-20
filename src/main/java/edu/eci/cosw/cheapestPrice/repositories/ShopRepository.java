package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.Item;
import edu.eci.cosw.cheapestPrice.entities.Tienda;
import edu.eci.cosw.cheapestPrice.entities.TiendaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Blob;
import java.util.List;

/**
 * Created by Daniela on 14/03/17.
 */
public interface ShopRepository extends JpaRepository<Tienda,TiendaId>{

    @Query("select t.items from Tienda t where t.id.nit=:idtienda.nit and t.id.x=:idtienda.x and t.id.y=:idtienda.y")
    public List<Item> loadItems(@Param("idtienda") TiendaId idtienda);

    @Query("select i from Item i where i.tienda.id.nit=:idtienda.nit and i.tienda.id.x=:idtienda.x and i.tienda.id.y=:idtienda.y and i.producto.id=:idporducto")
    public Item loadItem(@Param("idtienda") TiendaId idtienda,@Param("idproducto") long idprodcuto);

    @Query("")
    public void updateShop(@Param("idtienda") TiendaId idtienda, @Param("tienda") Tienda tienda);

    @Query("update Tienda t set t.logo=:logo where t.id.nit=:idtienda.nit and t.id.x=:idtienda.x and t.id.y=:idtienda.y")
    public void modifyLogo(@Param("idtienda") TiendaId id, @Param("logo") Blob logo);

    @Query("update Tienda t set t.telefono=:telefono where t.id.nit=:idtienda.nit and t.id.x=:idtienda.x and t.id.y=:idtienda.y")
    public void modifyTelephone(@Param("idtienda") TiendaId id, @Param("telefono") String telefono);

}
