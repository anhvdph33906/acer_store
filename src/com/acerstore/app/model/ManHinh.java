/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author ADMON
 */
public class ManHinh {
    private int maHinhID;
    private String loaiManHinh;

    public ManHinh() {
    }

    public ManHinh(int maHinhID, String loaiManHinh) {
        this.maHinhID = maHinhID;
        this.loaiManHinh = loaiManHinh;
    }

    public int getMaHinhID() {
        return maHinhID;
    }

    public void setMaHinhID(int maHinhID) {
        this.maHinhID = maHinhID;
    }

    public String getLoaiManHinh() {
        return loaiManHinh;
    }

    public void setLoaiManHinh(String loaiManHinh) {
        this.loaiManHinh = loaiManHinh;
    }

    @Override
    public String toString() {
        return "ManHinh{" + "maHinhID=" + maHinhID + ", loaiManHinh=" + loaiManHinh + '}';
    }
    
    
}
