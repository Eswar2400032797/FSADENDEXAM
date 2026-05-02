package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ClientDemo {

    public static void main(String[] args) {

        // ================= INSERT =================
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Payment p = new Payment();
        p.setId(1);
        p.setName("Eswar");
        p.setDate("2026-05-02");
        p.setStatus("SUCCESS");
        p.setAmount(5000);

        session.save(p);

        tx.commit();
        session.close();

        System.out.println("Inserted Successfully");

        // ================= DELETE USING HQL =================
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx2 = session2.beginTransaction();

        String hql = "delete from Payment where id = :pid";

        // ✅ FIX: use typed Query for Hibernate 5+
        Query<?> query = session2.createQuery(hql);
        query.setParameter("pid", 1);

        int result = query.executeUpdate();

        tx2.commit();
        session2.close();

        System.out.println("Deleted rows: " + result);
    }
}