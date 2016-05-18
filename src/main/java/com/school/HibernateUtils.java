package com.school;

/**
 * Created by Максим on 17.05.2016.
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class HibernateUtils {

    private static HibernateUtils instance = new HibernateUtils();
    private SessionFactory sessionFactory;
    private boolean initialized = false;

    private HibernateUtils() {
    }

    public static HibernateUtils getInstance() {
        return instance;
    }

    public void init() throws Exception {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            initialized = true;
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public void shutdown() throws Exception {
        if (initialized) {
            sessionFactory.close();
            initialized = false;
        }
    }

    public SessionFactory getSessionFactory() {
        return initialized ? sessionFactory : null;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    public void beginTransaction() {
        sessionFactory.getCurrentSession().beginTransaction();
    }

    public void commitTransaction() {
        getCurrentSession().getTransaction().commit();
    }

    public void rollbackTransaction() {
        getCurrentSession().getTransaction().rollback();
    }


}