package com.ntdat.hibernateproject.dao;

import com.ntdat.hibernateproject.entities.LopHocEntity;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import java.util.List;

public class StudentDAO {
    public static SinhVienEntity getStudent(String studentID) {
        SinhVienEntity student = null;
        Session session = HibernateUtilities.getSessionFactory().openSession();
        try {
            student = session.get(SinhVienEntity.class, studentID);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return student;
    }

    public static List<SinhVienEntity> getStudents() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        List<SinhVienEntity> sinhVienEntityList = null;
        String hql = "FROM SinhVienEntity";
        try {
            Query query = session.createQuery(hql);
            sinhVienEntityList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return sinhVienEntityList;
    }

    public static List<SinhVienEntity> getStudents(String compoundClassID) {
        String classID = "", subjectID = "";
        if (compoundClassID.contains("-")) {
            String[] token = compoundClassID.split("-");
            classID = token[0];
            subjectID = token[1];
            if (classID.equals("")) return null;
        } else {
            classID = compoundClassID;
        }

        Session session = HibernateUtilities.getSessionFactory().openSession();
        List<SinhVienEntity> sinhVienEntityList = null;
        String hql = "SELECT new SinhVienEntity(sv.mssv,sv.hoVaTen,sv.gioiTinh, sv.cmnd, sv.maLop) FROM SinhVienEntity sv WHERE sv.maLop = '"+ classID + "'";

        System.out.println(classID + " " + subjectID);

        if (!subjectID.equals("")) {
            hql = "SELECT new SinhVienEntity(sv.mssv,sv.hoVaTen,sv.gioiTinh, sv.cmnd, sv.maLop) FROM SinhVienEntity sv, ChiTietMonHocEntity ctmh WHERE sv.mssv = ctmh.mssv AND sv.maLop = '"+ classID + "' AND ctmh.maMon ='"+ subjectID +"'";
        }
        try {
            Query query = session.createQuery(hql);
            sinhVienEntityList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return sinhVienEntityList;
    }

    public static boolean addStudent(SinhVienEntity student) {
        if (StudentDAO.getStudent(student.getMssv()) != null) return false;

        ClassroomDAO.addClassroom(new LopHocEntity(student.getMaLop()));

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(student);
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
