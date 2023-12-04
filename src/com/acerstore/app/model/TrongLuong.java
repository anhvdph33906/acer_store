/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author ADMON
 */
public class TrongLuong {
    private int trongLuongID;
    private float loaiTrongLuong;

    public TrongLuong() {
    }

    public TrongLuong(int trongLuongID, float loaiTrongLuong) {
        this.trongLuongID = trongLuongID;
        this.loaiTrongLuong = loaiTrongLuong;
    }

    public int getTrongLuongID() {
        return trongLuongID;
    }

    public void setTrongLuongID(int trongLuongID) {
        this.trongLuongID = trongLuongID;
    }

    public float getLoaiTrongLuong() {
        return loaiTrongLuong;
    }

    public void setLoaiTrongLuong(float loaiTrongLuong) {
        this.loaiTrongLuong = loaiTrongLuong;
    }

    @Override
    public String toString() {
        return "TrongLuong{" + "trongLuongID=" + trongLuongID + ", loaiTrongLuong=" + loaiTrongLuong + '}';
    }
    
    
}
