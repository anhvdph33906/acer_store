/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class KhuyenMaiModel {
    private String maKM, tenKM, kieuKM;
    private double triGia;
    private Date thoiGianBatDau, thoiGianKetThuc;
    private String trangThai;

    public KhuyenMaiModel() {
    }

    public KhuyenMaiModel(String maKM, String tenKM, String kieuKM, double triGia, Date thoiGianBatDau, Date thoiGianKetThuc, String trangThai) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.kieuKM = kieuKM;
        this.triGia = triGia;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.trangThai = trangThai;
    }

    

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public double getTriGia() {
        return triGia;
    }

    public void setTriGia(double triGia) {
        this.triGia = triGia;
    }

    public String getKieuKM() {
        return kieuKM;
    }

    public void setKieuKM(String kieuKM) {
        this.kieuKM = kieuKM;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    

    @Override
    public String toString() {
        return "KhuyenMai{" + "maKM=" + maKM + ", tenKM=" + tenKM + ", kieuKM=" + kieuKM + ", triGia=" + triGia + ", thoiGianBatDau=" + thoiGianBatDau + ", thoiGianKetThuc=" + thoiGianKetThuc + ", trangThai=" + trangThai + '}';
    }
}
