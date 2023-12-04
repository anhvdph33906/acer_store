/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author ADMON
 */
public class MauSac {
    private int mauSacID;
    private String loaiMauSac;

    public MauSac() {
    }

    public MauSac(int mauSacID, String loaiMauSac) {
        this.mauSacID = mauSacID;
        this.loaiMauSac = loaiMauSac;
    }

    public int getMauSacID() {
        return mauSacID;
    }

    public void setMauSacID(int mauSacID) {
        this.mauSacID = mauSacID;
    }

    public String getLoaiMauSac() {
        return loaiMauSac;
    }

    public void setLoaiMauSac(String loaiMauSac) {
        this.loaiMauSac = loaiMauSac;
    }

    @Override
    public String toString() {
        return "MauSac{" + "mauSacID=" + mauSacID + ", loaiMauSac=" + loaiMauSac + '}';
    }
    
    
}
