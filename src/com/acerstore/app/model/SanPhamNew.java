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
    private int spid;
    private String maSP;
    private String tenSP;
    private String xuatXu;
    private String ngayRaMat;
    private boolean trangThai;
    private byte[] hinhAnh;
    private String Mota;
    DanhMucs danhmuc;

    public SanPhamNew() {
    }

    public SanPhamNew(int spid, String maSP, String tenSP, String xuatXu, String ngayRaMat, boolean trangThai, byte[] hinhAnh, String Mota) {
        this.spid = spid;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.xuatXu = xuatXu;
        this.ngayRaMat = ngayRaMat;
        this.trangThai = trangThai;
        this.hinhAnh = hinhAnh;
        this.Mota = Mota;
    }

    public int getSpid() {
        return spid;
    }

    public void setSpid(int spid) {
        this.spid = spid;
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

    public String getNgayRaMat() {
        return ngayRaMat;
    }

    public void setNgayRaMat(String ngayRaMat) {
        this.ngayRaMat = ngayRaMat;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public DanhMucs getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(DanhMucs danhmuc) {
        this.danhmuc = danhmuc;
    }

    @Override
    public String toString() {
        return "SanPhamNew{" + "spid=" + spid + ", maSP=" + maSP + ", tenSP=" + tenSP + ", xuatXu=" + xuatXu + ", ngayRaMat=" + ngayRaMat + ", trangThai=" + trangThai + ", hinhAnh=" + hinhAnh + ", Mota=" + Mota + ", danhmuc=" + danhmuc + '}';
    }

    
}
