package edu.eci.cosw.cheapestPrice.persistence.hibernate;

import edu.eci.cosw.cheapestPrice.persistence.ProductPersistence;
import edu.eci.cosw.cheapestPrice.persistence.SessionFactoryPersistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by masterhugo on 2/16/17.
 */
public class SessionFactoryPersistenceHibernate extends SessionFactoryPersistence{

    private static SessionFactory sf;
    private Session s;
    private Transaction tx;

    public static SessionFactory getSessionFactory(String xml) {
        Configuration configuration = new Configuration().configure(xml);
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public SessionFactoryPersistenceHibernate(String xml){
        sf = getSessionFactory(xml);
    }

    @Override
    public void beginSessionAndBeginTransaction() {
        s = sf.openSession();
        tx = s.beginTransaction();
    }

    @Override
    public void commitTransaction() {
        tx.commit();
    }

    @Override
    public void rollbackTransaction() {
        tx.rollback();
    }

    @Override
    public void endSession() {
        s.close();
    }

    @Override
    public ProductPersistence getProductPersistence() {
        return new ProductPersistenceHibernate(s);
    }

}
