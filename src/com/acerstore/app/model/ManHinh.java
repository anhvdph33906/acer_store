/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author JeongDoo
 */
public class ManHinh {
    private int idMh;
    private String tenMh;
    private boolean trangThai;

    public ManHinh() {
    }

    public ManHinh(int idMh, String tenMh, boolean trangThai) {
        this.idMh = idMh;
        this.tenMh = tenMh;
        this.trangThai = trangThai;
    }

    public int getIdMh() {
        return idMh;
    }

    public void setIdMh(int idMh) {
        this.idMh = idMh;
    }

    public String getTenMh() {
        return tenMh;
    }

    public void setTenMh(String tenMh) {
        this.tenMh = tenMh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "ManHinh{" + "idMh=" + idMh + ", tenMh=" + tenMh + ", trangThai=" + trangThai + '}';
    }
}
