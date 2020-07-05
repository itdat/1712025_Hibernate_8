package com.ntdat.hibernateproject.dao;

import com.ntdat.hibernateproject.entities.ChiTietLopHocEntity;
import com.ntdat.hibernateproject.entities.LopHocEntity;
import com.ntdat.hibernateproject.entities.MonHocEntity;
import com.ntdat.hibernateproject.entities.compound.ClassSubject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.PersistenceException;
import java.util.List;

public class SubjectDAO {
    public static List<MonHocEntity> getSubjects() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        List<MonHocEntity> monHocEntityList = null;
        String hql = "FROM MonHocEntity";
        try {
            Query query = session.createQuery(hql);
            monHocEntityList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return monHocEntityList;
    }

    public static MonHocEntity getSubject(String subjectID) {
        MonHocEntity subject = null;
        Session session = HibernateUtilities.getSessionFactory().openSession();
        try {
            subject = session.get(MonHocEntity.class, subjectID);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return subject;
    }

    public static boolean addSubject(MonHocEntity subject) {
        if (getSubject(subject.getMaMon()) != null) return false;

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(subject);
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

    public static List<ClassSubject> getClassSubjects() {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        List<ClassSubject> classSubjectList = null;
        String hql = "SELECT new com.ntdat.hibernateproject.entities.compound.ClassSubject(mh.tenMon, mh.maMon, ctlh.phongHoc, ctlh.maLop) FROM MonHocEntity mh, ChiTietLopHocEntity ctlh WHERE mh.maMon = ctlh.maMon";
        try {
            Query query = session.createQuery(hql);
            classSubjectList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return classSubjectList;
    }

    public static List<ClassSubject> getClassSubjects(String classID) {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        List<ClassSubject> classSubjectList = null;
        String hql = "SELECT new com.ntdat.hibernateproject.entities.compound.ClassSubject(mh.maMon, mh.tenMon, ctlh.phongHoc, ctlh.maLop) FROM MonHocEntity mh, ChiTietLopHocEntity ctlh WHERE ctlh.maLop = '" + classID + "' AND mh.maMon = ctlh.maMon";
        try {
            Query query = session.createQuery(hql);
            classSubjectList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return classSubjectList;
    }

    public static List<ClassSubject> getClassSubjectsStudent(String studentID) {
        Session session = HibernateUtilities.getSessionFactory().openSession();
        List<ClassSubject> classSubjectList = null;
        String hql = "SELECT new com.ntdat.hibernateproject.entities.compound.ClassSubject(mh.maMon, mh.tenMon, ctlh.phongHoc, ctlh.maLop) FROM MonHocEntity mh, ChiTietLopHocEntity ctlh, ChiTietMonHocEntity ctmh WHERE ctmh.mssv = '" + studentID + "' AND mh.maMon = ctlh.maMon AND ctmh.maMon = mh.maMon";
        try {
            Query query = session.createQuery(hql);
            classSubjectList = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return classSubjectList;
    }

    public static boolean addClassSubject(ClassSubject subject) {
        if (getSubject(subject.getId()) != null) return false;
        SubjectDAO.addSubject(new MonHocEntity(subject.getId(), subject.getName()));
        ClassroomDAO.addClassroom(new LopHocEntity(subject.getClassID()));
        ClassroomDetailDAO.addClassroomDetail(new ChiTietLopHocEntity(subject.getClassID(), subject.getId(), subject.getRoom()));
        return true;
    }


}
