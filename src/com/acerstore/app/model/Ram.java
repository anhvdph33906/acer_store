/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author JeongDoo
 */
public class Ram {
    private int idRam;
    private String tenRam;
    private boolean ttRam;

    public Ram() {
    }

    public Ram(int idRam, String tenRam, boolean ttRam) {
        this.idRam = idRam;
        this.tenRam = tenRam;
        this.ttRam = ttRam;
    }

    public int getIdRam() {
        return idRam;
    }

    public void setIdRam(int idRam) {
        this.idRam = idRam;
    }

    public String getTenRam() {
        return tenRam;
    }

    public void setTenRam(String tenRam) {
        this.tenRam = tenRam;
    }

    public boolean isTtRam() {
        return ttRam;
    }

    public void setTtRam(boolean ttRam) {
        this.ttRam = ttRam;
    }

    @Override
    public String toString() {
        return "Ram{" + "idRam=" + idRam + ", tenRam=" + tenRam + ", ttRam=" + ttRam + '}';
    }
    
    
}
