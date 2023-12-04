/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author JeongDoo
 */
public class Mau {
    private int idMau;
    private String tenMau;
    private boolean ttMau;

    public Mau() {
    }

    public Mau(int idMau, String tenMau, boolean ttMau) {
        this.idMau = idMau;
        this.tenMau = tenMau;
        this.ttMau = ttMau;
    }

    public int getIdMau() {
        return idMau;
    }

    public void setIdMau(int idMau) {
        this.idMau = idMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public boolean isTtMau() {
        return ttMau;
    }

    public void setTtMau(boolean ttMau) {
        this.ttMau = ttMau;
    }

    @Override
    public String toString() {
        return "Mau{" + "idMau=" + idMau + ", tenMau=" + tenMau + ", ttMau=" + ttMau + '}';
    }
    
}
