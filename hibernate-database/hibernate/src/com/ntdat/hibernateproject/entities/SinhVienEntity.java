package com.ntdat.hibernateproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sinh_vien", schema = "hibernate-database", catalog = "")
public class SinhVienEntity {
    private String mssv;
    private String hoVaTen;
    private String gioiTinh;
    private String cmnd;

    @Id
    @Column(name = "MSSV")
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    @Basic
    @Column(name = "HoVaTen")
    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    @Basic
    @Column(name = "GioiTinh")
    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Basic
    @Column(name = "CMND")
    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhVienEntity that = (SinhVienEntity) o;
        return Objects.equals(mssv, that.mssv) &&
                Objects.equals(hoVaTen, that.hoVaTen) &&
                Objects.equals(gioiTinh, that.gioiTinh) &&
                Objects.equals(cmnd, that.cmnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mssv, hoVaTen, gioiTinh, cmnd);
    }
}
