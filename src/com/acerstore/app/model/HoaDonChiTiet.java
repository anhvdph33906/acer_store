/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author ADMON
 */
public class HoaDonChiTiet {
    
    //HDCT
    private String maHD;
    private int baoHanhId;
    private int hoaDonId;
    private String maKh;
    private String maNV;
    private Date thoiGianTao;
    private Date thoiGianThanhToan;
    private BigDecimal gia;
    private float voucher;
    private BigDecimal thanhTien;
    private BigDecimal tienKhachTra;
    private String ghiChu;
    
    //IMEI
    private int imeiId;

    
    //SPCT
    private int sanPhamChiTietId;
    private int manHinhId;
    private int ramId;
    private int kichThuocId;
    private int cpuId;
    private int heDieuHanhId;
    private int trongLuongId;
    private int mausacId;
    private String maSp;
    private String tenSp;
    private String loaiSp;
    private int soLuong;
    private BigDecimal giaSPCT;
    private boolean trangThai;
    private String moTa;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHD, int baoHanhId, int hoaDonId, String maKh, String maNV, Date thoiGianTao, Date thoiGianThanhToan, BigDecimal gia, float voucher, BigDecimal thanhTien, BigDecimal tienKhachTra, String ghiChu, int imeiId, int sanPhamChiTietId, int manHinhId, int ramId, int kichThuocId, int cpuId, int heDieuHanhId, int trongLuongId, int mausacId, String maSp, String tenSp, String loaiSp, int soLuong, BigDecimal giaSPCT, boolean trangThai, String moTa) {
        this.maHD = maHD;
        this.baoHanhId = baoHanhId;
        this.hoaDonId = hoaDonId;
        this.maKh = maKh;
        this.maNV = maNV;
        this.thoiGianTao = thoiGianTao;
        this.thoiGianThanhToan = thoiGianThanhToan;
        this.gia = gia;
        this.voucher = voucher;
        this.thanhTien = thanhTien;
        this.tienKhachTra = tienKhachTra;
        this.ghiChu = ghiChu;
        this.imeiId = imeiId;
        this.sanPhamChiTietId = sanPhamChiTietId;
        this.manHinhId = manHinhId;
        this.ramId = ramId;
        this.kichThuocId = kichThuocId;
        this.cpuId = cpuId;
        this.heDieuHanhId = heDieuHanhId;
        this.trongLuongId = trongLuongId;
        this.mausacId = mausacId;
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.loaiSp = loaiSp;
        this.soLuong = soLuong;
        this.giaSPCT = giaSPCT;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public int getBaoHanhId() {
        return baoHanhId;
    }

    public void setBaoHanhId(int baoHanhId) {
        this.baoHanhId = baoHanhId;
    }

    public int getHoaDonId() {
        return hoaDonId;
    }

    public void setHoaDonId(int hoaDonId) {
        this.hoaDonId = hoaDonId;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public Date getThoiGianThanhToan() {
        return thoiGianThanhToan;
    }

    public void setThoiGianThanhToan(Date thoiGianThanhToan) {
        this.thoiGianThanhToan = thoiGianThanhToan;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public float getVoucher() {
        return voucher;
    }

    public void setVoucher(float voucher) {
        this.voucher = voucher;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public BigDecimal getTienKhachTra() {
        return tienKhachTra;
    }

    public void setTienKhachTra(BigDecimal tienKhachTra) {
        this.tienKhachTra = tienKhachTra;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getImeiId() {
        return imeiId;
    }

    public void setImeiId(int imeiId) {
        this.imeiId = imeiId;
    }

    public int getSanPhamChiTietId() {
        return sanPhamChiTietId;
    }

    public void setSanPhamChiTietId(int sanPhamChiTietId) {
        this.sanPhamChiTietId = sanPhamChiTietId;
    }

    public int getManHinhId() {
        return manHinhId;
    }

    public void setManHinhId(int manHinhId) {
        this.manHinhId = manHinhId;
    }

    public int getRamId() {
        return ramId;
    }

    public void setRamId(int ramId) {
        this.ramId = ramId;
    }

    public int getKichThuocId() {
        return kichThuocId;
    }

    public void setKichThuocId(int kichThuocId) {
        this.kichThuocId = kichThuocId;
    }

    public int getCpuId() {
        return cpuId;
    }

    public void setCpuId(int cpuId) {
        this.cpuId = cpuId;
    }

    public int getHeDieuHanhId() {
        return heDieuHanhId;
    }

    public void setHeDieuHanhId(int heDieuHanhId) {
        this.heDieuHanhId = heDieuHanhId;
    }

    public int getTrongLuongId() {
        return trongLuongId;
    }

    public void setTrongLuongId(int trongLuongId) {
        this.trongLuongId = trongLuongId;
    }

    public int getMausacId() {
        return mausacId;
    }

    public void setMausacId(int mausacId) {
        this.mausacId = mausacId;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getLoaiSp() {
        return loaiSp;
    }

    public void setLoaiSp(String loaiSp) {
        this.loaiSp = loaiSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaSPCT() {
        return giaSPCT;
    }

    public void setGiaSPCT(BigDecimal giaSPCT) {
        this.giaSPCT = giaSPCT;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "maHD=" + maHD + ", baoHanhId=" + baoHanhId + ", hoaDonId=" + hoaDonId + ", maKh=" + maKh + ", maNV=" + maNV + ", thoiGianTao=" + thoiGianTao + ", thoiGianThanhToan=" + thoiGianThanhToan + ", gia=" + gia + ", voucher=" + voucher + ", thanhTien=" + thanhTien + ", tienKhachTra=" + tienKhachTra + ", ghiChu=" + ghiChu + ", imeiId=" + imeiId + ", sanPhamChiTietId=" + sanPhamChiTietId + ", manHinhId=" + manHinhId + ", ramId=" + ramId + ", kichThuocId=" + kichThuocId + ", cpuId=" + cpuId + ", heDieuHanhId=" + heDieuHanhId + ", trongLuongId=" + trongLuongId + ", mausacId=" + mausacId + ", maSp=" + maSp + ", tenSp=" + tenSp + ", loaiSp=" + loaiSp + ", soLuong=" + soLuong + ", giaSPCT=" + giaSPCT + ", trangThai=" + trangThai + ", moTa=" + moTa + '}';
    }
    
    
}
