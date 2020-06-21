package com.ntdat.hibernateproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "giao_vu", schema = "hibernate-database", catalog = "")
public class GiaoVuEntity implements Serializable {
    private String taiKhoan;
    private String matKhau;

    public GiaoVuEntity() {}

    @Id
    @Column(name = "TaiKhoan")
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiaoVuEntity that = (GiaoVuEntity) o;
        return Objects.equals(taiKhoan, that.taiKhoan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taiKhoan);
    }

    @Column(name = "MatKhau")
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
