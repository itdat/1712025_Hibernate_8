package com.ntdat.hibernateproject.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tai_khoan", schema = "hibernate-database", catalog = "")
public class TaiKhoanEntity {
    private String taiKhoan;
    private String matKhau;

    @Id
    @Column(name = "TaiKhoan")
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    @Basic
    @Column(name = "MatKhau")
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaiKhoanEntity that = (TaiKhoanEntity) o;
        return Objects.equals(taiKhoan, that.taiKhoan) &&
                Objects.equals(matKhau, that.matKhau);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taiKhoan, matKhau);
    }
}
