package com.ntdat.hibernateproject.dao;

import com.ntdat.hibernateproject.entities.LopHocEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;

public class ClassroomDAO {
    public static LopHocEntity getClassroom(String classID) {
        LopHocEntity classroom = null;
        Session session = HibernateUtilities.getSessionFactory().openSession();
        try {
            classroom = session.get(LopHocEntity.class, classID);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return classroom;
    }

    public static boolean addClassroom(LopHocEntity classroom) {
        if (getClassroom(classroom.getMaLop()) != null) return false;

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(classroom);
            transaction.commit();
        } catch (PersistenceException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return true;
    }
}
