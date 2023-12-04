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
    private int sanPhamChiTietId;
    private String ten;
    private int soLuong;
    private double gia;
    private String manHinh;
    private int Ram;
    private float kichThuoc;
    private String cPU;
    private String heDieuHanh;
    private float trongLuong;
    private String mau;
    private boolean trangThai;
    private String moTa;

    public SanPhamChiTiets() {
    }

    public SanPhamChiTiets(int sanPhamChiTietId, String ten, int soLuong, double gia, String manHinh, int Ram, float kichThuoc, String cPU, String heDieuHanh, float trongLuong, String mau, boolean trangThai, String moTa) {
        this.sanPhamChiTietId = sanPhamChiTietId;
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

    public int getSanPhamChiTietId() {
        return sanPhamChiTietId;
    }

    public void setSanPhamChiTietId(int sanPhamChiTietId) {
        this.sanPhamChiTietId = sanPhamChiTietId;
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

    public int getRam() {
        return Ram;
    }

    public void setRam(int Ram) {
        this.Ram = Ram;
    }

    public float getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(float kichThuoc) {
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

    public float getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(float trongLuong) {
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
        return "SanPhamChiTiets{" + "sanPhamChiTietId=" + sanPhamChiTietId + ", ten=" + ten + ", soLuong=" + soLuong + ", gia=" + gia + ", manHinh=" + manHinh + ", Ram=" + Ram + ", kichThuoc=" + kichThuoc + ", cPU=" + cPU + ", heDieuHanh=" + heDieuHanh + ", trongLuong=" + trongLuong + ", mau=" + mau + ", trangThai=" + trangThai + ", moTa=" + moTa + '}';
    }

 
}
