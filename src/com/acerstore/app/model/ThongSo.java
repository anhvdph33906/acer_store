/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author JeongDoo
 */
public class ThongSo {
    private String manHinh,ram,kichThuoc,cPU,heDH,trongLuong,mau;

    public ThongSo() {
    }

    public ThongSo(String manHinh, String ram, String kichThuoc, String cPU, String heDH, String trongLuong, String mau) {
        this.manHinh = manHinh;
        this.ram = ram;
        this.kichThuoc = kichThuoc;
        this.cPU = cPU;
        this.heDH = heDH;
        this.trongLuong = trongLuong;
        this.mau = mau;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
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

    public String getHeDH() {
        return heDH;
    }

    public void setHeDH(String heDH) {
        this.heDH = heDH;
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

    @Override
    public String toString() {
        return "ThongSo{" + "manHinh=" + manHinh + ", ram=" + ram + ", kichThuoc=" + kichThuoc + ", cPU=" + cPU + ", heDH=" + heDH + ", trongLuong=" + trongLuong + ", mau=" + mau + '}';
    }
    
    
}
