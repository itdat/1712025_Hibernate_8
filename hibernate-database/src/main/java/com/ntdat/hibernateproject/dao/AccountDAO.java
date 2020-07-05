package com.ntdat.hibernateproject.dao;

import com.ntdat.hibernateproject.entities.LopHocEntity;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
import com.ntdat.hibernateproject.entities.TaiKhoanEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceException;

public class AccountDAO {
    public static TaiKhoanEntity getAccount(String username) {
        TaiKhoanEntity account = null;
        Session session = HibernateUtilities.getSessionFactory().openSession();
        try {
            account = session.get(TaiKhoanEntity.class, username);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return account;
    }

    public static boolean addAccount(TaiKhoanEntity account) {
        if (AccountDAO.getAccount(account.getTaiKhoan()) != null) return false;

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(account);
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

    public static boolean updateAccount(TaiKhoanEntity account) {
        if (AccountDAO.getAccount(account.getTaiKhoan()) == null) return false;

        Session session = HibernateUtilities.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(account);
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
