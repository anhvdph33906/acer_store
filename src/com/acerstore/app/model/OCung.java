/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author JeongDoo
 */
public class OCung {
    private int idOCung;
    private String tenOCung;
    private boolean ttOCung;

    public OCung() {
    }

    public OCung(int idOCung, String tenOCung, boolean ttOCung) {
        this.idOCung = idOCung;
        this.tenOCung = tenOCung;
        this.ttOCung = ttOCung;
    }

    public int getIdOCung() {
        return idOCung;
    }

    public void setIdOCung(int idOCung) {
        this.idOCung = idOCung;
    }

    public String getTenOCung() {
        return tenOCung;
    }

    public void setTenOCung(String tenOCung) {
        this.tenOCung = tenOCung;
    }

    public boolean isTtOCung() {
        return ttOCung;
    }

    public void setTtOCung(boolean ttOCung) {
        this.ttOCung = ttOCung;
    }

    @Override
    public String toString() {
        return "OCung{" + "idOCung=" + idOCung + ", tenOCung=" + tenOCung + ", ttOCung=" + ttOCung + '}';
    }
    
}
