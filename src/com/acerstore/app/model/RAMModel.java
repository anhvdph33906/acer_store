package com.acerstore.app.model;

public class RAMModel {
    private String iD;
    private String thongTin;
    private boolean trangThai;

    public RAMModel() {
    }

    public RAMModel(String iD, String thongTin, boolean trangThai) {
        this.iD = iD;
        this.thongTin = thongTin;
        this.trangThai = trangThai;
    }

    public String getiD() {
        return iD;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
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
        String tt;
        if (this.trangThai) {
            tt = "Còn hàng";
        } else {
            tt = "Hết hàng";
        }
        return new Object[]{iD, thongTin, tt};
    }
}
