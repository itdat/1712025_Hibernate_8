package com.ntdat.hibernateproject.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Vector;

@Entity
@Table(name = "sinh_vien", schema = "hibernate-database", catalog = "")
public class SinhVienEntity implements Serializable {
    private String mssv;
    private String hoVaTen;
    private String gioiTinh;
    private String cmnd;
    private String maLop;

    public SinhVienEntity() {}

    public SinhVienEntity(Vector<String> values) {
        if (values.size() != 5) return;
        this.mssv = values.get(0);
        this.hoVaTen = values.get(1);
        this.gioiTinh = values.get(2);
        this.cmnd = values.get(3);
        this.maLop = values.get(4);
    }

    public SinhVienEntity(String mssv, String hoVaTen, String gioiTinh, String cmnd, String maLop) {
        this.mssv = mssv;
        this.hoVaTen = hoVaTen;
        this.gioiTinh = gioiTinh;
        this.cmnd = cmnd;
        this.maLop = maLop;
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

    @Basic
    @Column(name = "MaLop")
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
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
