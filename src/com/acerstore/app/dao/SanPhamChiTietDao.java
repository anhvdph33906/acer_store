/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;

import Interfaces.SanPhamChiTietInterface;
import com.acerstore.app.database.DBConnection;
import com.acerstore.app.model.CPU;
import com.acerstore.app.model.HDH;
import com.acerstore.app.model.ManHinh;
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
        sql = "SELECT\n" +
"    S.SanPhamChiTietId,\n" +
"	SP.Ten,\n" +
"	S.SoLuong,\n" +
"	S.Gia,\n" +
"    MH.LoaiManHinh,\n" +
"    R.LoaiRam,\n" +
"    KT.LoaiKichThuoc,\n" +
"    CPU.LoaiCpu,\n" +
"    HDH.LoaiHeDieuHanh,\n" +
"    TL.LoaiTrongLuong,\n" +
"    MS.LoaiMauSac,\n" +
"	s.TrangThai,\n" +
"	s.MoTa\n" +
"FROM\n" +
"	SanPham SP join \n" +
"    SanPhamChiTiet S ON SP.SanPhamId = S.sanphamid \n" +
"JOIN ManHinh MH ON S.ManHinhId = MH.ManHinhId\n" +
"JOIN Ram R ON S.RamId = R.RamId\n" +
"JOIN KichThuoc KT ON S.KichThuocId = KT.KichThuocId\n" +
"JOIN Cpu CPU ON S.CpuId = CPU.CpuId\n" +
"JOIN HeDieuHanh HDH ON S.HeDieuHanhId = HDH.HeDieuHanhId\n" +
"JOIN TrongLuong TL ON S.TrongLuongId = TL.TrongLuongId\n" +
"JOIN MauSac MS ON S.MauSacId = MS.MauSacId";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
//            ps.setInt(1, sanPhamId);
            rs = ps.executeQuery();
            while(rs.next()){
                s = new SanPhamChiTiets(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getFloat(7), rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getString(11), rs.getBoolean(12), rs.getString(13));
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
                s = new SanPhamChiTiets(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getFloat(7), rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getString(11), rs.getBoolean(12), rs.getString(13));
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
                s = new SanPhamChiTiets(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getFloat(7), rs.getString(8), rs.getString(9), rs.getFloat(10), rs.getString(11), rs.getBoolean(12), rs.getString(13));
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
    
public Integer getSanPhamID(String maSP) {
    int sanphamID = -1; // Khởi tạo giá trị mặc định (có thể thay đổi tùy theo logic ứng dụng)

    sql = "SELECT SanPham.SanPhamId " +
          "FROM SanPham " +
          "WHERE SanPham.MaSP = ?;";

    try {
        con = DBConnection.getConnection();
        ps = con.prepareStatement(sql);
        ps.setObject(1, maSP);
        rs = ps.executeQuery();

        // Kiểm tra xem có kết quả trong ResultSet hay không
        if (rs.next()) {
            // Lấy giá trị từ cột "SanPhamId"
            sanphamID = rs.getInt("SanPhamId");
        }
    } catch (Exception e) {
        e.printStackTrace(); // In stack trace để theo dõi lỗi (hoặc có thể sử dụng log)
    } finally {
        // Đóng tất cả các tài nguyên (ResultSet, PreparedStatement, Connection)
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Trả về giá trị sanphamID
    return sanphamID;
}


    public ArrayList<ManHinh> getAllMH(){
        ManHinh mh = null;
        
        sql = "select * from ManHinh";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<ManHinh> list = new ArrayList<>();
            while(rs.next()){
                mh = new ManHinh(rs.getInt(1), rs.getString(2));
                list.add(mh);
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    } 
    
    public void AddManHinh(String txtManHinh){
               sql = "insert into ManHinh values (?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, txtManHinh);
            rs = ps.executeQuery();

        } catch (Exception e) {
            e.getMessage();
            
        }
    }
    public ArrayList<HDH> getAllHdh() {
        sql = "select * from HeDieuHanh";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {

            ArrayList<HDH> list = new ArrayList<>();
            while (rs.next()) {
                HDH hdh = new HDH(rs.getInt("HeDieuHanhId"), rs.getString("LoaiHeDieuHanh"));
                list.add(hdh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để bạn có thể xem và xử lý
            return null;
        }
    }

    public void AddHDH(String txtHDH) {
        sql = "insert into HeDieuHanh (LoaiHeDieuHanh) values (?)";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, txtHDH);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(); // In ra lỗi để bạn có thể xem và xử lý
        }
    }
        public ArrayList<CPU> getAllCPU(){
        CPU cpu = null;
        
        sql = "select * from Cpu";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<CPU> list = new ArrayList<>();
            while(rs.next()){
                cpu = new CPU(rs.getInt(1), rs.getString(2));
                list.add(cpu);
            }
            return list;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    } 
    
    public void AddCPU(String txtCPU){
               sql = "insert into Cpu values (?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, txtCPU);
            rs = ps.executeQuery();

        } catch (Exception e) {
            e.getMessage();
            
        }
    }

    
}
