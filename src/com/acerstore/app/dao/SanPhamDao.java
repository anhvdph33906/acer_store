/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;

import Interfaces.SanPhamInterfaces;
import com.acerstore.app.database.DBConnection;
import com.acerstore.app.model.DanhMucs;
import com.acerstore.app.model.SanPhamNew;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SanPhamDao implements SanPhamInterfaces {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<SanPhamNew> getAll() {
        List<SanPhamNew> sp = new ArrayList<>();
        sql = "select SanPham.*, DanhMuc.TenDM from SanPham\n"
                + "join DanhMuc on DanhMuc.MaDM = SanPham.MaDM";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamNew s = new SanPhamNew(
                        rs.getInt("SanPhamId"),
                        rs.getString("MaSP"),
                        rs.getString("Ten"),
                        rs.getString("XuatXu"),
                        rs.getString("ngaytao"),
                        rs.getBoolean("TrangThai"),
                        rs.getBytes("HinhAnh"),
                        rs.getString("MoTa")
                );
                DanhMucs dm = new DanhMucs(rs.getInt("MaDM"), rs.getString("TenDM"));
                s.setDanhmuc(dm);
                sp.add(s);
            }
            return sp;
        } catch (Exception e) {
            e.printStackTrace(); // In thông điệp lỗi ra console hoặc log lỗi
            return null;
        } finally {
            try {
                // Đóng tất cả các tài nguyên
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace(); // In thông điệp lỗi ra console hoặc log lỗi
            }
        }
    }

    public int checksoLuong(int soLuong) {
        sql = "SELECT SanPhamId, COUNT(*) AS SoLuong\n"
                + "FROM SanPhamChiTiet\n"
                + "GROUP BY SanPhamId";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, soLuong);
            rs = ps.executeQuery();
            while (rs.next()) {
                int spid = rs.getInt("sanphamid");
                int soluong = rs.getInt("soluong");
                String soluongsql = "UPDATE SanPham\n"
                        + "SET TrangThai = CASE\n"
                        + "    WHEN EXISTS (\n"
                        + "        SELECT 1 FROM SanPhamChiTiet \n"
                        + "        WHERE SanPhamChiTiet.SanPhamId = SanPham.SanPhamId AND SanPhamChiTiet.SoLuong > 0\n"
                        + "    ) THEN 'Còn hàng'\n"
                        + "    ELSE 'Hết hàng'\n"
                        + "END;";
                ps.setString(1, (soluong > 0) ? "Còn hàng" : "Hết hàng");
                ps.setInt(2, spid);
                ps.executeUpdate();
            }
            return 1;
        } catch (Exception e) {
            e.getMessage();
            return 0;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public SanPhamNew getLikeMa(String ma) {
        SanPhamNew s = null;
        sql = "select MaSP,Ten,NgayTao,XuatXu,DanhMuc.MaDM as MaDM,DanhMuc.TenDM as TenDM,trangthai,HinhAnh,MoTa from SanPham\n"
                + "join DanhMuc on DanhMuc.MaDM = SanPham.MaDM where MaSP=?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new SanPhamNew(rs.getInt("id"), rs.getString("MaSP"), rs.getString("Ten"), rs.getString("XuatXu"), rs.getString("NgayTao"), rs.getBoolean("TrangThai"), rs.getBytes("HinhAnh"), rs.getString("MoTa"));
                DanhMucs dm = new DanhMucs(rs.getInt("MaDM"), rs.getString("TenDM"));
                s.setDanhmuc(dm);
            }
            return s;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public int insertSPNew(SanPhamNew spn) {
        sql = "insert into SanPham(MaSP,Ten,XuatXu,NgayTao,MaDM,trangthai,MoTa) values(?,?,?,?,?,?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, spn.getMaSP());
            ps.setString(2, spn.getTenSP());
            ps.setString(3, spn.getXuatXu());
            ps.setString(4, spn.getNgayRaMat());
            ps.setString(5, String.valueOf(spn.getDanhmuc().getMaDm()));
            ps.setBoolean(6, spn.isTrangThai());
            ps.setString(7, spn.getMota());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Ghi lại hoặc xử lý ngoại lệ một cách phù hợp
            }
        }
    }

    public int addSP(String ma, String ten, String xuatxu, String ngay, int iddm, boolean tt, String hinhAnh, String mota) {
        FileInputStream fis = null;
        sql = "insert into SanPham(MaSP,Ten,XuatXu,NgayTao,MaDM,trangthai,HinhAnh,MoTa) values (?,?,?,?,?,?,?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            ps.setString(2, ten);
            ps.setString(3, xuatxu);
            ps.setString(4, ngay);
            ps.setString(5, String.valueOf(iddm));
            ps.setString(6, String.valueOf(tt));
            try {
                InputStream input = new FileInputStream(new File(hinhAnh));
                ps.setBlob(7, input);
            } catch (Exception e) {
                e.getMessage();
            }
            ps.setString(8, mota);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int updateSP(String ten, String xuatxu, String ngay, int iddm, String mota, String ma) {
        sql = "update SanPham set Ten=?,XuatXu=?,NgayTao =?,MaDM=?,MoTa=? where MaSP =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ten);
            ps.setString(2, xuatxu);
            ps.setString(3, ngay);
            ps.setString(4, String.valueOf(iddm));
            ps.setString(5, mota);
            ps.setString(6, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public ArrayList getMaSP() {
        ArrayList listMSP = new ArrayList<>();
        String sql = "select SanPhamId from SanPham";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idsp = rs.getInt("SanPhamId");
                listMSP.add(idsp);
            }
            return listMSP;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public List<SanPhamNew> getSanPham(int pageSelect) {
        List<SanPhamNew> listSP = new ArrayList<>();
        SanPhamNew s = null;
        String sql = "SELECT SanPhamId, MaSP, Ten, NgayTao, XuatXu, DanhMuc.MaDM AS MaDM, DanhMuc.TenDM AS TenDM, trangthai, HinhAnh, MoTa\n"
                + "FROM SanPham\n"
                + "JOIN DanhMuc ON DanhMuc.MaDM = SanPham.MaDM\n"
                + "ORDER BY SanPham.MaSP\n"
                + "OFFSET ? ROWS \n"
                + "FETCH NEXT 5 ROWS ONLY;";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pageSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                s = new SanPhamNew(rs.getInt("SanPhamId"), rs.getString("MaSP"), rs.getString("Ten"), rs.getString("XuatXu"), rs.getString("NgayTao"), rs.getBoolean("TrangThai"), rs.getBytes("HinhAnh"), rs.getString("MoTa"));
                DanhMucs dm = new DanhMucs(rs.getInt("MaDM"), rs.getString("TenDM"));
                s.setDanhmuc(dm);
                listSP.add(s);
            }
            return listSP;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public int add(SanPhamNew sp) {
        FileInputStream fis = null;
        sql = "insert into SanPham(MaSP,Ten,XuatXu,NgayTao,MaDM,trangthai,HinhAnh,MoTa) values (?,?,?,?,?,?,?,?)";
        try {
            File imageFile = new File("D:\\SD_18319_Java3\\icon");
            fis = new FileInputStream(imageFile);
            byte[] imageData = new byte[(int) imageFile.length()];
            fis.read(imageData);
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sp.getMaSP());
            ps.setString(2, sp.getTenSP());
            ps.setString(3, sp.getXuatXu());
            ps.setString(4, sp.getNgayRaMat());
            ps.setString(5, String.valueOf(sp.getDanhmuc().getMaDm()));
            ps.setString(6, String.valueOf(sp.isTrangThai()));
            ps.setBytes(7, imageData);
            ps.setString(8, sp.getMota());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    @Override
    public int update(SanPhamNew s, String maSP) {
        sql = "update SanPham set ten=?,TrangThai=?,MoTa=? where MaSP =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, s.getTenSP());
            ps.setObject(2, s.isTrangThai());
            ps.setObject(3, s.getMota());
            ps.setObject(4, maSP);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

}
