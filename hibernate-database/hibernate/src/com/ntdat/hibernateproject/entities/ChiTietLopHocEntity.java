package com.ntdat.hibernateproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chi_tiet_lop_hoc", schema = "hibernate-database", catalog = "")
@IdClass(ChiTietLopHocEntityPK.class)
public class ChiTietLopHocEntity {
    private String maLop;
    private String maMon;
    private String phongHoc;

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

    @Basic
    @Column(name = "PhongHoc")
    public String getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietLopHocEntity that = (ChiTietLopHocEntity) o;
        return Objects.equals(maLop, that.maLop) &&
                Objects.equals(maMon, that.maMon) &&
                Objects.equals(phongHoc, that.phongHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLop, maMon, phongHoc);
    }
}
