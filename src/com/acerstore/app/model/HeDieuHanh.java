/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author JeongDoo
 */
public class HeDieuHanh {
    private int idHDH;
    private String tenHDH;
    private boolean ttHDH;

    public HeDieuHanh() {
    }

    public HeDieuHanh(int idHDH, String tenHDH, boolean ttHDH) {
        this.idHDH = idHDH;
        this.tenHDH = tenHDH;
        this.ttHDH = ttHDH;
    }

    public int getIdHDH() {
        return idHDH;
    }

    public void setIdHDH(int idHDH) {
        this.idHDH = idHDH;
    }

    public String getTenHDH() {
        return tenHDH;
    }

    public void setTenHDH(String tenHDH) {
        this.tenHDH = tenHDH;
    }

    public boolean isTtHDH() {
        return ttHDH;
    }

    public void setTtHDH(boolean ttHDH) {
        this.ttHDH = ttHDH;
    }

    @Override
    public String toString() {
        return "HeDieuHanh{" + "idHDH=" + idHDH + ", tenHDH=" + tenHDH + ", ttHDH=" + ttHDH + '}';
    }
    
}
