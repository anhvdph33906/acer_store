/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class SanPhamNew {
    private String maSP;
    private String tenSP;
    private String xuatXu;
    private Date ngayRaMat;
    private boolean trangThai;
    private String hinhAnh;

    public SanPhamNew() {
    }

    public SanPhamNew(String maSP, String tenSP, String xuatXu, Date ngayRaMat, boolean trangThai, String hinhAnh) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.xuatXu = xuatXu;
        this.ngayRaMat = ngayRaMat;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public Date getNgayRaMat() {
        return ngayRaMat;
    }

    public void setNgayRaMat(Date ngayRaMat) {
        this.ngayRaMat = ngayRaMat;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "SanPhamNew{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", xuatXu=" + xuatXu + ", ngayRaMat=" + ngayRaMat + ", trangThai=" + trangThai + ", hinhAnh=" + hinhAnh + '}';
    }
}
