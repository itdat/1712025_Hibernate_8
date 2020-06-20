package com.ntdat.hibernateproject.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PhucKhaoEntityPK implements Serializable {
    private String mssv;
    private String maMon;
    private String cotDiem;

    @Column(name = "MSSV")
    @Id
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    @Column(name = "MaMon")
    @Id
    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    @Column(name = "CotDiem")
    @Id
    public String getCotDiem() {
        return cotDiem;
    }

    public void setCotDiem(String cotDiem) {
        this.cotDiem = cotDiem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhucKhaoEntityPK that = (PhucKhaoEntityPK) o;
        return Objects.equals(mssv, that.mssv) &&
                Objects.equals(maMon, that.maMon) &&
                Objects.equals(cotDiem, that.cotDiem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mssv, maMon, cotDiem);
    }
}
