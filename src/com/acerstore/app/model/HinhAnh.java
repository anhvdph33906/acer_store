/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author JeongDoo
 */
public class HinhAnh {
    private int HinhAnhid;
    private byte[] tenHinhAnh;

    public HinhAnh() {
    }

    public HinhAnh(int HinhAnhid, byte[] tenHinhAnh) {
        this.HinhAnhid = HinhAnhid;
        this.tenHinhAnh = tenHinhAnh;
    }

    public int getHinhAnhid() {
        return HinhAnhid;
    }

    public void setHinhAnhid(int HinhAnhid) {
        this.HinhAnhid = HinhAnhid;
    }

    public byte[] getTenHinhAnh() {
        return tenHinhAnh;
    }

    public void setTenHinhAnh(byte[] tenHinhAnh) {
        this.tenHinhAnh = tenHinhAnh;
    }

    @Override
    public String toString() {
        return "HinhAnh{" + "HinhAnhid=" + HinhAnhid + ", tenHinhAnh=" + tenHinhAnh + '}';
    }
    
    
}
