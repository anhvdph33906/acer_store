/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.model;

/**
 *
 * @author ASUS
 */
public class SanPhamChiTiets {
    private String maSpct;
    SanPhamNew sp;
    Imei im;
    ManHinh mh;
    Ram ra;
    KichThuoc kt;
    CPU cp;
    HeDieuHanh hdh;
    OCung oc;
    Mau ma;
    private int soluong;
    private double gia;

    public SanPhamChiTiets() {
    }

    public SanPhamChiTiets(String maSpct, int soluong, double gia) {
        this.maSpct = maSpct;
        this.soluong = soluong;
        this.gia = gia;
    }

    public String getMaSpct() {
        return maSpct;
    }

    public void setMaSpct(String maSpct) {
        this.maSpct = maSpct;
    }

    public SanPhamNew getSp() {
        return sp;
    }

    public void setSp(SanPhamNew sp) {
        this.sp = sp;
    }

    public Imei getIm() {
        return im;
    }

    public void setIm(Imei im) {
        this.im = im;
    }

    public ManHinh getMh() {
        return mh;
    }

    public void setMh(ManHinh mh) {
        this.mh = mh;
    }

    public Ram getRa() {
        return ra;
    }

    public void setRa(Ram ra) {
        this.ra = ra;
    }

    public KichThuoc getKt() {
        return kt;
    }

    public void setKt(KichThuoc kt) {
        this.kt = kt;
    }

    public CPU getCp() {
        return cp;
    }

    public void setCp(CPU cp) {
        this.cp = cp;
    }

    public HeDieuHanh getHdh() {
        return hdh;
    }

    public void setHdh(HeDieuHanh hdh) {
        this.hdh = hdh;
    }

    public OCung getOc() {
        return oc;
    }

    public void setOc(OCung oc) {
        this.oc = oc;
    }

    public Mau getMa() {
        return ma;
    }

    public void setMa(Mau ma) {
        this.ma = ma;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "SanPhamChiTiets{" + "maSpct=" + maSpct + ", sp=" + sp + ", im=" + im + ", mh=" + mh + ", ra=" + ra + ", kt=" + kt + ", cp=" + cp + ", hdh=" + hdh + ", oc=" + oc + ", ma=" + ma + ", soluong=" + soluong + ", gia=" + gia + '}';
    }
    

}
