/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author ASUS
 */
public class DanhMucs {
    private String maDm;
    private String tenDm;

    public DanhMucs() {
    }

    public DanhMucs(String maDm, String tenDm) {
        this.maDm = maDm;
        this.tenDm = tenDm;
    }

    public String getMaDm() {
        return maDm;
    }

    public void setMaDm(String maDm) {
        this.maDm = maDm;
    }

    public String getTenDm() {
        return tenDm;
    }

    public void setTenDm(String tenDm) {
        this.tenDm = tenDm;
    }

    @Override
    public String toString() {
        return "DanhMuc{" + "maDm=" + maDm + ", tenDm=" + tenDm + '}';
    }
    
}
