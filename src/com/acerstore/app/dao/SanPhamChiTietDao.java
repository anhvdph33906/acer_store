/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;

import Interfaces.SanPhamChiTietInterface;
import com.acerstore.app.database.DBConnection;
import com.acerstore.app.model.SanPhamChiTiets;
import com.acerstore.app.model.ThongSo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SanPhamChiTietDao implements SanPhamChiTietInterface{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql =null;
    public List<SanPhamChiTiets> getAll(){
        List<SanPhamChiTiets> sp = new ArrayList<>();
        SanPhamChiTiets s = null;
        sql = "select sanpham.MaSP,sanpham.Ten,IMEI.Ma,SoLuong,Gia,thongso.ManHinh,thongso.Ram,thongso.KichThuoc,thongso.CPU,thongso.HeDieuHanh,thongso.TrongLuong,thongso.Mau,SanPham.TrangThai,sanphamchitiet.MoTa  from SanPhamChiTiet\n" +
"join SanPham on SanPhamChiTiet.sanphamid = SanPham.SanPhamId \n" +
"join ThongSo on ThongSo.ThongSoId = SanPhamChiTiet.ThongSoId\n" +
"join IMEI on SanPhamChiTiet.SanPhamChiTietId= IMEI.SanPhamChiTietId";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new SanPhamChiTiets(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getBoolean(13), rs.getString(14));
                sp.add(s);
            }
            return sp;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    public List<SanPhamChiTiets> getMa(String masp){
        List<SanPhamChiTiets> sp = new ArrayList<>();
        SanPhamChiTiets s = null;
        sql = "select sanpham.MaSP,sanpham.Ten,SoLuong,Gia,thongso.ManHinh,thongso.Ram,thongso.KichThuoc,thongso.CPU,thongso.HeDieuHanh,thongso.TrongLuong,thongso.Mau,SanPham.TrangThai,sanpham.MoTa  from SanPhamChiTiet\n" +
"join SanPham on SanPhamChiTiet.sanphamid = SanPham.SanPhamId\n" +
"join ThongSo on ThongSo.ThongSoId = SanPhamChiTiet.ThongSoId where MaSP=?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, masp);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new SanPhamChiTiets(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getBoolean(13), rs.getString(14));
                sp.add(s);
            }
            return sp;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    public List<SanPhamChiTiets> LikeMaCT(String tenHinh){
        List<SanPhamChiTiets> sp = new ArrayList<>();
        SanPhamChiTiets s = null;
        sql = "select sanpham.MaSP,sanpham.Ten,SoLuong,Gia,thongso.ManHinh,thongso.Ram,thongso.KichThuoc,thongso.CPU,thongso.HeDieuHanh,thongso.TrongLuong,thongso.Mau,SanPham.TrangThai,sanphamchitiet.MoTa  from SanPhamChiTiet\n" +
"join SanPham on SanPhamChiTiet.sanphamid = SanPham.SanPhamId \n" +
"join ThongSo on ThongSo.ThongSoId = SanPhamChiTiet.ThongSoId where ManHinh like '%"+tenHinh+"%'";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tenHinh);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new SanPhamChiTiets(rs.getString(1), rs.getString(2),rs.getString(3), rs.getInt(4), rs.getDouble(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getBoolean(13), rs.getString(14));
                sp.add(s);
            }
            return sp;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    } 
    public List<ThongSo> getAllTS(){
        List<ThongSo> ts = new ArrayList<>();
        ThongSo t = null;
        sql ="select ManHinh,Ram,KichThuoc,CPU,HeDieuHanh,TrongLuong,mau from ThongSo";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                t = new ThongSo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                ts.add(t);
            }
            return ts;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    public int getInsertTS(ThongSo t){
        List<ThongSo> ts = new ArrayList<>();
        sql ="insert into ThongSo(ManHinh,Ram,KichThuoc,CPU,HeDieuHanh,TrongLuong,mau) values(?,?,?,?,?,?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, t.getManHinh());
            ps.setObject(2, t.getRam());
            ps.setObject(3, t.getKichThuoc());
            ps.setObject(4, t.getcPU());
            ps.setObject(5, t.getHeDH());
            ps.setObject(6, t.getTrongLuong());
            ps.setObject(7, t.getMau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    
    @Override
    public int add(SanPhamChiTiets spct) {
        sql ="insert into SanPhamChiTiet (SoLuong,Gia,MoTa,sanphamid,ThongSoId) values(?,?,?,?,?)";
        return 0;
    }

    @Override
    public int update(SanPhamChiTiets spcts, String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
