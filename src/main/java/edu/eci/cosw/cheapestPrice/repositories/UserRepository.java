package edu.eci.cosw.cheapestPrice.repositories;

import edu.eci.cosw.cheapestPrice.entities.ListaDeMercado;
import edu.eci.cosw.cheapestPrice.entities.Usuario;
import edu.eci.cosw.cheapestPrice.exception.CheapestPriceException;
import edu.eci.cosw.cheapestPrice.persistence.UserPersistence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * Created by 2105403 on 3/16/17.
 */
public interface UserRepository extends JpaRepository<Usuario,Integer> {

    //Cargar usuario por correo
    //Agregar un usuario
    //Actualizar usuario
    //Cargar listas por correo

}
