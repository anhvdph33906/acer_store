/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author JeongDoo
 */
public class CPU {
    private int idCPU;
    private String tenCPU;
    private boolean ttCPU;

    public CPU() {
    }

    public CPU(int idCPU, String tenCPU, boolean ttCPU) {
        this.idCPU = idCPU;
        this.tenCPU = tenCPU;
        this.ttCPU = ttCPU;
    }

    public int getIdCPU() {
        return idCPU;
    }

    public void setIdCPU(int idCPU) {
        this.idCPU = idCPU;
    }

    public String getTenCPU() {
        return tenCPU;
    }

    public void setTenCPU(String tenCPU) {
        this.tenCPU = tenCPU;
    }

    public boolean isTtCPU() {
        return ttCPU;
    }

    public void setTtCPU(boolean ttCPU) {
        this.ttCPU = ttCPU;
    }

    @Override
    public String toString() {
        return "CPU{" + "idCPU=" + idCPU + ", tenCPU=" + tenCPU + ", ttCPU=" + ttCPU + '}';
    }
    
}
