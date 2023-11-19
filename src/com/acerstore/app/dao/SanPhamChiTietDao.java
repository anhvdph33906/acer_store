/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;

import Interfaces.SanPhamChiTietInterface;
import com.acerstore.app.database.DBConnection;
import com.acerstore.app.model.SanPhamChiTiets;
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
        sql = "select sanpham.MaSP,sanpham.Ten,SoLuong,Gia,thongso.ManHinh,thongso.Ram,thongso.KichThuoc,thongso.CPU,thongso.HeDieuHanh,thongso.TrongLuong,thongso.Mau,SanPham.TrangThai,sanphamchitiet.MoTa  from SanPhamChiTiet\n" +
"join SanPham on SanPhamChiTiet.sanphamid = SanPham.SanPhamId\n" +
"join ThongSo on ThongSo.ThongSoId = SanPhamChiTiet.ThongSoId";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new SanPhamChiTiets(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getBoolean(12), rs.getString(13));
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
                s = new SanPhamChiTiets(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getBoolean(12), rs.getString(13));
                sp.add(s);
            }
            return sp;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    public SanPhamChiTiets LikeMaCT(String maSP){
        SanPhamChiTiets s = null;
        sql = "select MaSP,ten,XuatXu,Ngayramat,MoTa,TrangThai,HinhAnh from SanPham where MaSP = ?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maSP);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new SanPhamChiTiets(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getBoolean(12), rs.getString(13));
            }
            return s;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    } 

    
    @Override
    public int add(SanPhamChiTiets spct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(SanPhamChiTiets spcts, String ma) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
