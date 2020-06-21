package com.ntdat.hibernateproject.dao;

import com.ntdat.hibernateproject.entities.GiaoVuEntity;
import com.ntdat.hibernateproject.entities.LopHocEntity;
import org.hibernate.Session;

import javax.persistence.PersistenceException;

public class MinistryDAO {
    public static GiaoVuEntity getMinistry() {
        GiaoVuEntity ministry = null;
        Session session = HibernateUtilities.getSessionFactory().openSession();
        String username = "giaovu";
        try {
            ministry = session.get(GiaoVuEntity.class, username);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ministry;
    }
}
