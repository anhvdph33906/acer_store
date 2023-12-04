/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author ADMON
 */
public class HDH {
    private int HDHID;
    private String loaiHDH;

    public HDH() {
    }

    public HDH(int HDHID, String loaiHDH) {
        this.HDHID = HDHID;
        this.loaiHDH = loaiHDH;
    }

    public int getHDHID() {
        return HDHID;
    }

    public void setHDHID(int HDHID) {
        this.HDHID = HDHID;
    }

    public String getLoaiHDH() {
        return loaiHDH;
    }

    public void setLoaiHDH(String loaiHDH) {
        this.loaiHDH = loaiHDH;
    }

    @Override
    public String toString() {
        return "HDH{" + "HDHID=" + HDHID + ", loaiHDH=" + loaiHDH + '}';
    }
    
    
}
