package com.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {

    public static SessionFactory factory;

    public static SessionFactory getFactory() {
        if (factory == null) {
            // Create a new Configuration and load hibernate.cfg.xml
            factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return factory;
    }

    public void closeFactory() {
        if (factory != null && factory.isOpen()) { // Added null check for 'factory' as good practice
            factory.close();
        }
    }
}