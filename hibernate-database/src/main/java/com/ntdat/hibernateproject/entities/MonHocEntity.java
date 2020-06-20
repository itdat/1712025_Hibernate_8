package com.ntdat.hibernateproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mon_hoc", schema = "hibernate-database", catalog = "")
public class MonHocEntity {
    private String maMon;
    private String tenMon;

    public MonHocEntity() {}

    public MonHocEntity(String maMon, String tenMon) {
        this.maMon = maMon;
        this.tenMon = tenMon;
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
    @Column(name = "TenMon")
    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MonHocEntity that = (MonHocEntity) o;
        return Objects.equals(maMon, that.maMon) &&
                Objects.equals(tenMon, that.tenMon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maMon, tenMon);
    }
}
