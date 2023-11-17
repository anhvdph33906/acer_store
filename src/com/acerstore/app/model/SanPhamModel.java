package com.acerstore.app.model;

import javax.management.ObjectName;

public class SanPhamModel {

    private String maSP, xuatXu, dongSP;
    private String tenSP, moTa;
    private long giaBan;
    private int soLuong;
    private byte trangThai;

    public SanPhamModel() {
    }

    public SanPhamModel(String maSP, String xuatXu, String dongSP, String tenSP, byte trangThai, String moTa, long giaBan, int soLuong) {
        this.maSP = maSP;
        this.xuatXu = xuatXu;
        this.dongSP = dongSP;
        this.tenSP = tenSP;
        this.trangThai = trangThai;
        this.moTa = moTa;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public String getDongSP() {
        return dongSP;
    }

    public void setDongSP(String dongSP) {
        this.dongSP = dongSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public byte getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(byte trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Object[] toDataRow() {
//        String trangThai;
//        if (this.trangThai == 1) {
//            trangThai = "Còn hàng";
//        } else {
//            trangThai = "Hết hàng";
//        }
        return new Object[]{maSP, tenSP, soLuong, giaBan, dongSP, xuatXu, trangThai, moTa};
    }
}
