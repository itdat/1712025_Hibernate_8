package com.ntdat.hibernateproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chi_tiet_mon_hoc", schema = "hibernate-database", catalog = "")
@IdClass(ChiTietMonHocEntityPK.class)
public class ChiTietMonHocEntity {
    private String maLop;
    private String maMon;
    private String mssv;
    private Double diemGk;
    private Double diemCk;
    private Double diemKhac;
    private Double diemTong;

    public ChiTietMonHocEntity() {}

    public ChiTietMonHocEntity(String maLop, String maMon, String mssv, Double diemGk, Double diemCk, Double diemKhac, Double diemTong) {
        this.maLop = maLop;
        this.maMon = maMon;
        this.mssv = mssv;
        this.diemGk = diemGk;
        this.diemCk = diemCk;
        this.diemKhac = diemKhac;
        this.diemTong = diemTong;
    }

    @Id
    @Column(name = "MaLop")
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    @Id
    @Column(name = "MaMon")
    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    @Id
    @Column(name = "MSSV")
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    @Basic
    @Column(name = "DiemGK")
    public Double getDiemGk() {
        return diemGk;
    }

    public void setDiemGk(Double diemGk) {
        this.diemGk = diemGk;
    }

    @Basic
    @Column(name = "DiemCK")
    public Double getDiemCk() {
        return diemCk;
    }

    public void setDiemCk(Double diemCk) {
        this.diemCk = diemCk;
    }

    @Basic
    @Column(name = "DiemKhac")
    public Double getDiemKhac() {
        return diemKhac;
    }

    public void setDiemKhac(Double diemKhac) {
        this.diemKhac = diemKhac;
    }

    @Basic
    @Column(name = "DiemTong")
    public Double getDiemTong() {
        return diemTong;
    }

    public void setDiemTong(Double diemTong) {
        this.diemTong = diemTong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietMonHocEntity that = (ChiTietMonHocEntity) o;
        return Objects.equals(maLop, that.maLop) &&
                Objects.equals(maMon, that.maMon) &&
                Objects.equals(mssv, that.mssv) &&
                Objects.equals(diemGk, that.diemGk) &&
                Objects.equals(diemCk, that.diemCk) &&
                Objects.equals(diemKhac, that.diemKhac) &&
                Objects.equals(diemTong, that.diemTong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLop, maMon, mssv, diemGk, diemCk, diemKhac, diemTong);
    }
}
