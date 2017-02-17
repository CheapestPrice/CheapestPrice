package edu.eci.cosw.cheapestPrice.persistence;

import edu.eci.cosw.cheapestPrice.persistence.hibernate.SessionFactoryPersistenceHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by masterhugo on 2/16/17.
 */
public abstract class SessionFactoryPersistence {
    private static SessionFactoryPersistence instance = null;

    /**
     * Obtiene una instancia del SessionFactoryPersistence
     *
     * @param xml la configuracion de la instancia
     * @return La SessionFactoryPersistence concerniente a la configuracion
     */
    public static SessionFactoryPersistence getInstance(String xml) {
        if (instance == null) {
            synchronized (SessionFactoryPersistence.class) {
                if (instance == null) {
                    if (xml!=null) {
                        instance = new SessionFactoryPersistenceHibernate(xml);
                    } else {
                        throw new RuntimeException("Wrong configuration: Unsupported xml");
                    }
                }
            }
        }
        return instance;
    }

    /**
     * Inicia una nueva sesion y una nueva transaction
     */
    public abstract void beginSessionAndBeginTransaction();

    /**
     * Hace commit a los cambios hechos
     */
    public abstract void commitTransaction();

    /**
     * Hace rollback de los cambios hechos
     */
    public abstract void rollbackTransaction();

    /**
     * Cierra la sesion actual
     */
    public abstract void endSession();

    /**
     * Obtiene un ProductPersistence
     *
     * @return el ProductPersistence correspondiente a las propiedades del
     * SessionFactoryPersistence
     */
    public abstract ProductPersistence getProductPersistence();
}
