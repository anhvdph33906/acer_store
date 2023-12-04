/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author JeongDoo
 */
public class Imei {
    private int idimei;
    private String ma;

    public Imei() {
    }

    public Imei(int idimei, String ma) {
        this.idimei = idimei;
        this.ma = ma;
    }

    public int getIdimei() {
        return idimei;
    }

    public void setIdimei(int idimei) {
        this.idimei = idimei;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    @Override
    public String toString() {
        return "Imei{" + "idimei=" + idimei + ", ma=" + ma + '}';
    }
}
