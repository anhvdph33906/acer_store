package com.acerstore.app.database;

import com.acerstore.app.model.NhanVien1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NhanVienService {

    private Connection conn;
    private ArrayList<NhanVien1> list = new ArrayList<>();

    public NhanVienService() {
        try {
            conn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<NhanVien1> fillAll() {
        try {
            String query = "SELECT MaNV, Ten, GioiTinh, SoDT, MatKhau, VaiTro FROM NhanVien";
            try ( PreparedStatement ps = conn.prepareStatement(query);  ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String ma = rs.getString("MaNV");
                    String ten = rs.getString("Ten");
                    boolean gioiTinh = rs.getBoolean("GioiTinh");
                    String sdt = rs.getString("SoDT");
                    String mk = rs.getString("MatKhau");
//                    String gc = rs.getString("GhiChu");
                    String tt = rs.getString("VaiTro");
//                    String tt = rs.getString("TrangThai");

                    NhanVien1 nv1 = new NhanVien1(ma, ten, gioiTinh, sdt, mk, tt);
                    list.add(nv1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean addNhanVien(NhanVien1 nv) {
        try {
            String query = "INSERT INTO NhanVien (MaNV, Ten, GioiTinh, SoDT, MatKhau, VaiTro) VALUES (?, ?, ?, ?, ?, ?)";
            try ( PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, nv.getMaNV());
                ps.setString(2, nv.getTenNV());
                ps.setBoolean(3, nv.isGioiTinh());
                ps.setString(4, nv.getSdt());
                ps.setString(5, nv.getMatKhau());
//                ps.setString(8, nv.getGhiChu());
                ps.setString(6, nv.getTrangThai());
//                ps.setString(7, nv.getTrangThai());

                int result = ps.executeUpdate();
                return result > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getcount() {
        try {
            String query = "SELECT COUNT(*) FROM NhanVien";
            try ( PreparedStatement ps = conn.prepareStatement(query);  ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public int getCount() {
        try {
            String query = "SELECT COUNT(*) FROM NhanVien";
            try ( PreparedStatement ps = conn.prepareStatement(query);  ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
