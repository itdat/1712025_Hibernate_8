package com.ntdat.hibernateproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phuc_khao", schema = "hibernate-database", catalog = "")
@IdClass(PhucKhaoEntityPK.class)
public class PhucKhaoEntity {
    private String mssv;
    private String maMon;
    private String cotDiem;
    private double diemMongMuon;
    private String liDo;
    private String tinhTrang;

    @Id
    @Column(name = "MSSV")
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
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
    @Column(name = "CotDiem")
    public String getCotDiem() {
        return cotDiem;
    }

    public void setCotDiem(String cotDiem) {
        this.cotDiem = cotDiem;
    }

    @Basic
    @Column(name = "DiemMongMuon")
    public double getDiemMongMuon() {
        return diemMongMuon;
    }

    public void setDiemMongMuon(double diemMongMuon) {
        this.diemMongMuon = diemMongMuon;
    }

    @Basic
    @Column(name = "LiDo")
    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }

    @Basic
    @Column(name = "TinhTrang")
    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhucKhaoEntity that = (PhucKhaoEntity) o;
        return Double.compare(that.diemMongMuon, diemMongMuon) == 0 &&
                Objects.equals(mssv, that.mssv) &&
                Objects.equals(maMon, that.maMon) &&
                Objects.equals(cotDiem, that.cotDiem) &&
                Objects.equals(liDo, that.liDo)&&
                Objects.equals(tinhTrang, that.tinhTrang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mssv, maMon, cotDiem, diemMongMuon, liDo, tinhTrang);
    }
}
