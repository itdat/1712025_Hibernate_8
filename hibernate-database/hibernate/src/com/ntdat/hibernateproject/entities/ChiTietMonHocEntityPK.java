package com.ntdat.hibernateproject.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ChiTietMonHocEntityPK implements Serializable {
    private String maLop;
    private String maMon;
    private String mssv;

    @Column(name = "MaLop")
    @Id
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    @Column(name = "MaMon")
    @Id
    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    @Column(name = "MSSV")
    @Id
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietMonHocEntityPK that = (ChiTietMonHocEntityPK) o;
        return Objects.equals(maLop, that.maLop) &&
                Objects.equals(maMon, that.maMon) &&
                Objects.equals(mssv, that.mssv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLop, maMon, mssv);
    }
}
