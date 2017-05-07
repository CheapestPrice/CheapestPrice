package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Blob;

/**
 * Created by Daniela on 14/03/17.
 */
public interface ShopRepository extends JpaRepository<Tienda,Integer>{

    @Modifying
    @Transactional
    @Query("update Tienda t set t.logo=:logo where t.id=:idtienda")
    public void modifyLogo(@Param("idtienda") int idtienda, @Param("logo") Blob logo);

    @Modifying
    @Transactional
    @Query("update Tienda t set t.telefono=:telefono where t.id=:idtienda")
    public void modifyTelephone(@Param("idtienda") int idtienda, @Param("telefono") String telefono);

    @Query("select t from Tienda t where t.nit=:nit and t.direccion=:direccion and t.nombre=:nombre and t.telefono=:telefono")
    public Tienda findOneByAll(@Param("nit")String nit,@Param("direccion")String direccion,@Param("nombre") String nombre,@Param("telefono") String telefono);

}
