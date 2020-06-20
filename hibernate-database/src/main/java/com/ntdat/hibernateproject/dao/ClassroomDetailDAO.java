package com.ntdat.hibernateproject.dao;

import com.ntdat.hibernateproject.entities.ChiTietLopHocEntity;
import com.ntdat.hibernateproject.entities.ChiTietLopHocEntityPK;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;

public class ClassroomDetailDAO {
    public static ChiTietLopHocEntity getClassroomDetail(ChiTietLopHocEntityPK pk){
        ChiTietLopHocEntity classroomDetail = null;
        Session session = HibernateUtilities.getSessionFactory().openSession();
        try {
            classroomDetail = session.get(ChiTietLopHocEntity.class, pk);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return classroomDetail;
    }

    public static boolean addClassroomDetail(ChiTietLopHocEntity classroomDetail) {
        if (getClassroomDetail(new ChiTietLopHocEntityPK(classroomDetail.getMaLop(), classroomDetail.getMaMon())) != null) return false;

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(classroomDetail);
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
