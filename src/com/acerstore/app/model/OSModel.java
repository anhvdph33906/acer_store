package com.acerstore.app.model;

public class OSModel {

    private String iD;
    private String thongTin;

    public OSModel() {
    }

    public OSModel(String iD, String thongTin) {
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
