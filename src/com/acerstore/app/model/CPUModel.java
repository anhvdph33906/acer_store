package com.acerstore.app.model;

public class CPUModel {

    private String iD;
    private String thongTin;

    public CPUModel() {
    }

    public CPUModel(String iD, String thongTin) {
        this.iD = iD;
        this.thongTin = thongTin;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    @Override
    public String toString() {
        return "CPUModel{" + "iD=" + iD + ", thongTin=" + thongTin + '}';
    }   

    public Object[] toDataRows() {
        return new Object[]{iD, thongTin};
    }
}
