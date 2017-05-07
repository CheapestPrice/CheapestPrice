package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Paula on 20/03/2017.
 */
public interface CuentaRepository extends JpaRepository<Cuenta,Integer> {
    @Query("select c from Cuenta c where c.usuario.correo=:email and c.hash=:hash")
    Cuenta Login(@Param(value = "email")String email,@Param(value = "hash")String hash);

}
