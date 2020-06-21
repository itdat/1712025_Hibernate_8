package com.ntdat.hibernateproject.dao;

import com.ntdat.hibernateproject.entities.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import java.util.List;

public class ReExaminationDAO {
    public static PhucKhaoEntity getReExamination(PhucKhaoEntityPK pk) {
        PhucKhaoEntity reExamination = null;
        Session session = HibernateUtilities.getSessionFactory().openSession();
        try {
            reExamination = session.get(PhucKhaoEntity.class, pk);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return reExamination;
    }

    public static List<PhucKhaoEntity> getReExaminations() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        List<PhucKhaoEntity> phucKhaoEntityList = null;
        String hql = "FROM PhucKhaoEntity ";
        try {
            Query query = session.createQuery(hql);
            phucKhaoEntityList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return phucKhaoEntityList;
    }

    public static boolean addReExamination(PhucKhaoEntity reExam) {
        if (getReExamination(new PhucKhaoEntityPK(reExam.getMssv(), reExam.getMaMon(), reExam.getCotDiem())) != null) return false;

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(reExam);
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
