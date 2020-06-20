package com.ntdat.hibernateproject;

import com.ntdat.hibernateproject.dao.ClassroomDAO;
import com.ntdat.hibernateproject.dao.StudentDAO;
import com.ntdat.hibernateproject.dao.SubjectDAO;
import com.ntdat.hibernateproject.entities.LopHocEntity;
import com.ntdat.hibernateproject.entities.SinhVienEntity;
import com.ntdat.hibernateproject.entities.compound.ClassSubject;

import java.util.List;

public class Main {
    public static void main(String args[]) {
//        SinhVienEntity s = new SinhVienEntity("1000000", "John Doe", "Nam", "121212121","17CTT3");
//        SinhVienEntity t = StudentDAO.getStudent(s.getMssv());
//        System.out.println(t);
//        System.out.println(String.valueOf(StudentDAO.addStudent(s)));
//        List<SinhVienEntity> sinhVienEntityList = StudentDAO.getStudents("17CTT1");
//        for (SinhVienEntity s : sinhVienEntityList) {
//            System.out.println(s.getHoVaTen());
//        }
        List<ClassSubject> classSubjectList = SubjectDAO.getClassSubjects("17CTT5");
        for (ClassSubject subject : classSubjectList) {
            System.out.println(subject.getId() + " " + subject.getName() + " " + subject.getRoom());
        }
    }
}
