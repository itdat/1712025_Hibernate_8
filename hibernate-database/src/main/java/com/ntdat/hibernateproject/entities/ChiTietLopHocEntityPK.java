package com.ntdat.hibernateproject.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ChiTietLopHocEntityPK implements Serializable {
    private String maLop;
    private String maMon;

    public ChiTietLopHocEntityPK () {}

    public ChiTietLopHocEntityPK(String maLop, String maMon) {
        this.maLop = maLop;
        this.maMon = maMon;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietLopHocEntityPK that = (ChiTietLopHocEntityPK) o;
        return Objects.equals(maLop, that.maLop) &&
                Objects.equals(maMon, that.maMon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maLop, maMon);
    }
}
