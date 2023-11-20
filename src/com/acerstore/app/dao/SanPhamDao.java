/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;

import Interfaces.SanPhamInterfaces;
import com.acerstore.app.database.DBConnection;
import com.acerstore.app.database.DBConnection;
import com.acerstore.app.model.SanPhamNew;
import com.acerstore.app.view.SanPham;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
/**
 *
 * @author ASUS
 */
public class SanPhamDao implements SanPhamInterfaces{
    TableModel tbm;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql =null;
    public List<SanPhamNew> getAll(){
        List<SanPhamNew> sp = new ArrayList<>();
        SanPhamNew s = null;
        sql = "select MaSP,ten,XuatXu,Ngayramat,TrangThai,HinhAnh from SanPham ";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new SanPhamNew(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getBoolean(5), rs.getBytes(6));
                sp.add(s);
            }
            return sp;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    public List<SanPhamNew> getMaSP(String masp){
        List<SanPhamNew> sp = new ArrayList<>();
        SanPhamNew s = null;
        sql = "select * from SanPham where MaSP=?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, masp);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new SanPhamNew(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getBoolean(5), rs.getBytes(6));
                sp.add(s);
            }
            return sp;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    public ArrayList getsp(){
        ArrayList sp = new ArrayList<>();
        sql = "select * from SanPham";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id sản phẩm");
                sp.add(id);
            }
            return sp;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
    public void getLoadTrang(long trang){
    SanPhamNew s = null;
        sql = "select top 5 * from SanPham where [San_Pham] not in (select top " + (trang * 5 - 5) + " [San_Pham] from SanPham )";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while(rs.next()){
                Vector v = new Vector();
                String ma= rs.getString(1);
                String ten =rs.getString(2);
                String xx =rs.getString(3); 
                Date d = rs.getDate(4);
                boolean tt = rs.getBoolean(5); 
                byte[] a = rs.getBytes(6);
                v.add(ma);
                v.add(ten);
                v.add(xx);
                v.add(d);
                v.add(tt);
                v.add(a);
                tbm.addTableModelListener((TableModelListener) v);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
 
    public void getCountSP(){
        long count;
        sql = "select COUNT(*) from SanPham";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                count =rs.getLong(1);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
    public SanPhamNew LikeMa(String m){
        SanPhamNew s = null;
        sql = "select MaSP,ten,XuatXu,Ngayramat,TrangThai,HinhAnh from SanPham where MaSP=?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new SanPhamNew(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getBoolean(5), rs.getBytes(6));
            }
            return s;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    } 
    

    @Override
    public int add(SanPhamNew sp) {
        sql ="insert into SanPham(MaSP,ten,XuatXu,Ngayramat,TrangThai,HinhAnh) values (?,?,?,?,?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaSP());
            ps.setObject(2, sp.getTenSP());
            ps.setObject(3, sp.getXuatXu());
            ps.setObject(4, sp.getNgayRaMat());
            ps.setObject(5, sp.isTrangThai());
            ps.setBytes(6, sp.getHinhAnh());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    @Override
    public int update(SanPhamNew s, String maSP) {
        sql ="update SanPham set ten=?,TrangThai=? where MaSP =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, s.getTenSP());
            ps.setObject(2, s.isTrangThai());
            ps.setObject(3, maSP);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }
    
}
