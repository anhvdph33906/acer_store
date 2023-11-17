package com.acerstore.app.model;

public class HoaDonCho {
    private int maHDC;
    private String maHD;
    private String maNV;
    private String ngayTao;
    private boolean trangThai;

    public HoaDonCho() {}

    public HoaDonCho(int maHDC, String maHD, String maNV, String ngayTao, boolean trangThai) {
        this.maHDC = maHDC;
        this.maHD = maHD;
        this.maNV = maNV;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public int getMaHDC() {
        return maHDC;
    }

    public void setMaHDC(int maHDC) {
        this.maHDC = maHDC;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] toDataRows() {
        String trangThai;
        if (this.trangThai) {
            trangThai = "Đã thanh toán";
        } else {
            trangThai = "Chưa thanh toán";
        }
        return new Object[]{maHD, maNV, ngayTao, trangThai};
    }
}
