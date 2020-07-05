package com.ntdat.hibernateproject.dao;

import com.ntdat.hibernateproject.entities.ChiTietMonHocEntity;
import com.ntdat.hibernateproject.entities.ChiTietMonHocEntityPK;
import com.ntdat.hibernateproject.entities.LopHocEntity;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import java.util.List;

public class SubjectDetailDAO {
    public static ChiTietMonHocEntity getSubjectDetail(ChiTietMonHocEntityPK pk) {
        ChiTietMonHocEntity subjectDetail = null;
        Session session = HibernateUtilities.getSessionFactory().openSession();
        try {
            subjectDetail = session.get(ChiTietMonHocEntity.class, pk);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return subjectDetail;
    }

    public static List<ChiTietMonHocEntity> getSubjectDetails() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        List<ChiTietMonHocEntity> chiTietMonHocEntityList = null;
        String hql = "FROM SinhVienEntity";
        try {
            Query query = session.createQuery(hql);
            chiTietMonHocEntityList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return chiTietMonHocEntityList;
    }

    public static List<ChiTietMonHocEntity> getSubjectDetails(String compoundClassID) {
        String classID = "", subjectID = "";
        if (compoundClassID.contains("-")) {
            String[] token = compoundClassID.split("-");
            classID = token[0];
            subjectID = token[1];
            if (classID.equals("") || subjectID.equals("")) return null;
        }

        Session session = HibernateUtilities.getSessionFactory().openSession();
        List<ChiTietMonHocEntity> chiTietMonHocEntityList = null;
        String hql = "SELECT new ChiTietMonHocEntity(ctmh.maLop, ctmh.maMon, ctmh.mssv, ctmh.diemGk, ctmh.diemCk, ctmh.diemKhac, ctmh.diemTong) FROM ChiTietMonHocEntity ctmh WHERE ctmh.maLop = '" + classID +"' AND ctmh.maMon = '" + subjectID + "'";
        try {
            Query query = session.createQuery(hql);
            chiTietMonHocEntityList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return chiTietMonHocEntityList;
    }

    public static boolean addSubjectDetail(ChiTietMonHocEntity subjectDetail) {
        if (getSubjectDetail(new ChiTietMonHocEntityPK(subjectDetail.getMaLop(), subjectDetail.getMaMon(), subjectDetail.getMssv())) != null) return false;

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(subjectDetail);
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

    public static boolean deleteSubjectDetail(ChiTietMonHocEntity subjectDetail) {
        if (getSubjectDetail(new ChiTietMonHocEntityPK(subjectDetail.getMaLop(), subjectDetail.getMaMon(), subjectDetail.getMssv())) == null) return false;

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(subjectDetail);
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

    public static boolean updateSubjectDetail(ChiTietMonHocEntity subjectDetail) {
        if (getSubjectDetail(new ChiTietMonHocEntityPK(subjectDetail.getMaLop(), subjectDetail.getMaMon(), subjectDetail.getMssv())) == null) return false;

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(subjectDetail);
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
