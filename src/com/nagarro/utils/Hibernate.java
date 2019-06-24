package com.nagarro.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

    private static SessionFactory sessionFactory;

    
    
    
    public static Session getSessionInstance() {
        sessionFactory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
        return sessionFactory.openSession();
    }

}
