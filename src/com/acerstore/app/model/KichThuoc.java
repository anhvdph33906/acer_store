/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author JeongDoo
 */
public class KichThuoc {
    private int idKT;
    private String tenKT;
    private boolean ttKT;

    public KichThuoc() {
    }

    public KichThuoc(int idKT, String tenKT, boolean ttKT) {
        this.idKT = idKT;
        this.tenKT = tenKT;
        this.ttKT = ttKT;
    }

    public int getIdKT() {
        return idKT;
    }

    public void setIdKT(int idKT) {
        this.idKT = idKT;
    }

    public String getTenKT() {
        return tenKT;
    }

    public void setTenKT(String tenKT) {
        this.tenKT = tenKT;
    }

    public boolean isTtKT() {
        return ttKT;
    }

    public void setTtKT(boolean ttKT) {
        this.ttKT = ttKT;
    }

    @Override
    public String toString() {
        return "KichThuoc{" + "idKT=" + idKT + ", tenKT=" + tenKT + ", ttKT=" + ttKT + '}';
    }
    
}
