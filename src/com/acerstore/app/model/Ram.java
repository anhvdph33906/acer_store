/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author ADMON
 */
public class Ram {
    private int ramID;
    private int loaiRam;

    public Ram() {
    }

    public Ram(int ramID, int loaiRam) {
        this.ramID = ramID;
        this.loaiRam = loaiRam;
    }

    public int getRamID() {
        return ramID;
    }

    public void setRamID(int ramID) {
        this.ramID = ramID;
    }

    public int getLoaiRam() {
        return loaiRam;
    }

    public void setLoaiRam(int loaiRam) {
        this.loaiRam = loaiRam;
    }

    @Override
    public String toString() {
        return "Ram{" + "ramID=" + ramID + ", loaiRam=" + loaiRam + '}';
    }
    
    
}
