package com.klef.fsad.exam;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sf = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Payment.class)
            .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sf;
    }
}