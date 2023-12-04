/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author ADMON
 */
public class KichThuoc {
    private int kichThuocID;
    private float loaiKichThuoc;

    public KichThuoc() {
    }

    public KichThuoc(int kichThuocID, float loaiKichThuoc) {
        this.kichThuocID = kichThuocID;
        this.loaiKichThuoc = loaiKichThuoc;
    }

    public int getKichThuocID() {
        return kichThuocID;
    }

    public void setKichThuocID(int kichThuocID) {
        this.kichThuocID = kichThuocID;
    }

    public float getLoaiKichThuoc() {
        return loaiKichThuoc;
    }

    public void setLoaiKichThuoc(float loaiKichThuoc) {
        this.loaiKichThuoc = loaiKichThuoc;
    }

    @Override
    public String toString() {
        return "KichThuoc{" + "kichThuocID=" + kichThuocID + ", loaiKichThuoc=" + loaiKichThuoc + '}';
    }
    
    
}
