/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

import java.math.BigDecimal;

/**
 *
 * @author ADMON
 */
public class HoaDon {
    private int hoaDonId;
    private String  ghiChu;
    private BigDecimal tongTien;
    private String thanhToan;
    private boolean trangThai;

    public HoaDon() {
    }

    public HoaDon(int hoaDonId, String ghiChu, BigDecimal tongTien, String thanhToan, boolean trangThai) {
        this.hoaDonId = hoaDonId;
        this.ghiChu = ghiChu;
        this.tongTien = tongTien;
        this.thanhToan = thanhToan;
        this.trangThai = trangThai;
    }

    public int getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(int hoaDonId) {
        this.hoaDonId = hoaDonId;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "hoaDonId=" + hoaDonId + ", ghiChu=" + ghiChu + ", tongTien=" + tongTien + ", thanhToan=" + thanhToan + ", trangThai=" + trangThai + '}';
    }
    
    
    
}
