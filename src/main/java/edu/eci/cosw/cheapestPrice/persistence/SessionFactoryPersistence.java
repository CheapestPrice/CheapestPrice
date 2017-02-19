package edu.eci.cosw.cheapestPrice.persistence;

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
    private static SessionFactory sf = null;
    private Session s;
    private Transaction tx;

    /**
     * Declara la sesion para ser utilizada
     *
     * @param xml la configuracion de la instancia
     */
    public static void declareSessionFactory(String xml) {
        if (sf == null) {
            synchronized (SessionFactoryPersistence.class) {
                if (sf == null) {
                    Configuration configuration = new Configuration().configure(xml);
                    ServiceRegistry serviceRegistry
                            = new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties()).build();

                    // builds a session factory from the service registry
                    SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                    sf = sessionFactory;
                }
            }
        }
    }

    /**
     * Inicia una nueva sesion y una nueva transaction
     */
    public void beginSessionAndBeginTransaction(){
        s = sf.openSession();
        tx = s.beginTransaction();
    }

    /**
     * Hace commit a los cambios hechos
     */
    public void commitTransaction() {
        tx.commit();
    }

    /**
     * Hace rollback de los cambios hechos
     */
    public void rollbackTransaction()  {
        tx.rollback();
    }

    /**
     * Cierra la sesion actual
     */
    public void endSession()  {
        s.close();
    }

}
