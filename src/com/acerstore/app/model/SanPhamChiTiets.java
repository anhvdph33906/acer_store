/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author ASUS
 */
public class SanPhamChiTiets {
    private String maSp;
    private String ten;
    private int soLuong;
    private double gia;
    private String manHinh;
    private String Ram;
    private String kichThuoc;
    private String cPU;
    private String heDieuHanh;
    private String trongLuong;
    private String mau;
    private boolean trangThai;
    private String moTa;

    public SanPhamChiTiets() {
    }

    public SanPhamChiTiets(String maSp, String ten, int soLuong, double gia, String manHinh, String Ram, String kichThuoc, String cPU, String heDieuHanh, String trongLuong, String mau, boolean trangThai, String moTa) {
        this.maSp = maSp;
        this.ten = ten;
        this.soLuong = soLuong;
        this.gia = gia;
        this.manHinh = manHinh;
        this.Ram = Ram;
        this.kichThuoc = kichThuoc;
        this.cPU = cPU;
        this.heDieuHanh = heDieuHanh;
        this.trongLuong = trongLuong;
        this.mau = mau;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getRam() {
        return Ram;
    }

    public void setRam(String Ram) {
        this.Ram = Ram;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getcPU() {
        return cPU;
    }

    public void setcPU(String cPU) {
        this.cPU = cPU;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public String getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(String trongLuong) {
        this.trongLuong = trongLuong;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "SanPhamChiTiets{" + "maSp=" + maSp + ", ten=" + ten + ", soLuong=" + soLuong + ", gia=" + gia + ", manHinh=" + manHinh + ", Ram=" + Ram + ", kichThuoc=" + kichThuoc + ", cPU=" + cPU + ", heDieuHanh=" + heDieuHanh + ", trongLuong=" + trongLuong + ", mau=" + mau + ", trangThai=" + trangThai + ", moTa=" + moTa + '}';
    }
}
