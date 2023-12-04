/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author ADMON
 */
public class CPU {
    private int cpuID;
    private String loaiCPU;

    public CPU() {
    }

    public CPU(int cpuID, String loaiCPU) {
        this.cpuID = cpuID;
        this.loaiCPU = loaiCPU;
    }

    public int getCpuID() {
        return cpuID;
    }

    public void setCpuID(int cpuID) {
        this.cpuID = cpuID;
    }

    public String getLoaiCPU() {
        return loaiCPU;
    }

    public void setLoaiCPU(String loaiCPU) {
        this.loaiCPU = loaiCPU;
    }

    @Override
    public String toString() {
        return "CPU{" + "cpuID=" + cpuID + ", loaiCPU=" + loaiCPU + '}';
    }
    
    
}
