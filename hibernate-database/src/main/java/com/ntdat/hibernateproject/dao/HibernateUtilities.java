package com.ntdat.hibernateproject.dao;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class HibernateUtilities {
    private static SessionFactory sessionFactory = null;
    static {
        try {
            sessionFactory = new
                    Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}