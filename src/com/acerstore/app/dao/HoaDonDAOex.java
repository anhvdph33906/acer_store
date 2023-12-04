/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;
import com.acerstore.app.database.DBConnect;
import com.acerstore.app.model.HoaDon;
import com.acerstore.app.model.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author ADMON
 */
public class HoaDonDAOex extends HoaDonDAO<HoaDon, HoaDonChiTiet, Integer>{

    //final String SELECT_ALLHD_SQL = "select * from HoaDon";
    final String SELECT_ALLHD_SQL = "select top 2 * from HoaDon where [HoaDonId] not in (select top \" + (trang*2-2) + \" [HoaDonId] from HoaDon);";
    
    final String SELECT_ALLHDCT_SQL = "select HoaDonChiTiet.MaHD, HoaDonChiTiet.BaoHanhId,HoaDonChiTiet.HoaDonId,HoaDonChiTiet.MaKH,HoaDonChiTiet.MaNV,\n" +
                            "		HoaDonChiTiet.ThoiGianTao,HoaDonChiTiet.ThoiGianThanhToan , HoaDonChiTiet.Gia,HoaDonChiTiet.Voucher,\n" +
                            "		HoaDonChiTiet.ThanhTien, HoaDonChiTiet.TienKhachTra,HoaDonChiTiet.GhiChu, IMEI.ImeiId\n" +
                            "from HoaDonChiTiet join IMEI on HoaDonChiTiet.MaHD = IMEI.MaHD\n" +
                            "where HoaDonId = ?";
    
    final String SELECT_ALLSPCT_SQL = "select  SanPhamChiTiet.ManHinhId,SanPhamChiTiet.RamId,SanPhamChiTiet.KichThuocId,SanPhamChiTiet.CPUId,SanPhamChiTiet.HeDieuHanhId,SanPhamChiTiet.TrongLuongId,SanPhamChiTiet.MauId, SanPhamChiTiet.MoTa, IMEI.ImeiId\n" +
"from HoaDonChiTiet join IMEI on HoaDonChiTiet.MaHD = IMEI.MaHD\n" +
"					join SanPhamChiTiet on IMEI.SanPhamChiTietId = SanPhamChiTiet.SanPhamChiTietId\n" +
"					where IMEI.ImeiId = ?";
    
    final String SELECTHD_BY_ID_SQL = "select *\n" +
                                    "from HoaDon\n" +
                                    "where HoaDon.HoaDonId = ?";
    
    final String SELECTHD_BY_TRANGTHAI_SQL = "select * from HoaDon where HoaDon.TrangThai = ?;"; 
    
    final String SELECT_ALLHDTang_SQL = "select * from HoaDon order by HoaDon.TongTien asc";

    final String SELECT_ALLHDGiam_SQL = "select * from HoaDon order by HoaDon.TongTien desc";    
    
    
    
    
    @Override
    public List<HoaDon> selectAllHD(Integer trang) {
         return selectHDBySql(SELECT_ALLHD_SQL, trang);
    }

    @Override
    public List<HoaDon> selectHDBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList();
        try {
            ResultSet rs = DBConnect.executeQuery(sql, args);
            while(rs.next()){
                HoaDon entity1 = new HoaDon();
                entity1.setHoaDonId(rs.getInt("HoaDonId"));
                entity1.setGhiChu(rs.getString("GhiChu"));
                entity1.setTongTien(rs.getBigDecimal("TongTien"));
                entity1.setThanhToan(rs.getString("ThanhToan"));
                entity1.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(entity1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<HoaDonChiTiet> selectAllHDCT(int MaHD) {
        return selectHDCTBySql(SELECT_ALLHDCT_SQL,MaHD);
    }

    @Override
    public List<HoaDonChiTiet> selectHDCTBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList();
        try {
            ResultSet rs = DBConnect.executeQuery(sql, args);
            while(rs.next()){
                HoaDonChiTiet entity2 = new HoaDonChiTiet();
                entity2.setMaHD(rs.getString("MaHD"));
                entity2.setBaoHanhId(rs.getInt("BaoHanhId"));
                entity2.setHoaDonId(rs.getInt("HoaDonId"));
                entity2.setMaKh(rs.getString("MaKH"));
                entity2.setMaNV(rs.getString("MaNV"));
                entity2.setThoiGianTao(rs.getDate("ThoiGianTao"));
                entity2.setThoiGianThanhToan(rs.getDate("ThoiGianThanhToan"));
                entity2.setGia(rs.getBigDecimal("Gia"));
                entity2.setVoucher(rs.getFloat("Voucher"));
                entity2.setThanhTien(rs.getBigDecimal("ThanhTien"));
                entity2.setTienKhachTra(rs.getBigDecimal("TienKhachTra"));
                entity2.setGhiChu(rs.getString("GhiChu"));
                entity2.setImeiId(rs.getInt("ImeiId"));
                list.add(entity2);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public HoaDonChiTiet selectAllSPCT(Integer ImeiID) {
        return selectSPCTBySql(SELECT_ALLSPCT_SQL,ImeiID);
    }

    @Override
    public HoaDonChiTiet selectSPCTBySql(String sql, Object... args) {
        try {
            ResultSet rs = DBConnect.executeQuery(sql, args);
            HoaDonChiTiet entity3 = new HoaDonChiTiet();
            while(rs.next()){
                entity3.setManHinhId(rs.getInt("ManHinhId"));
                entity3.setRamId(rs.getInt("RamId"));
                entity3.setKichThuocId(rs.getInt("KichThuocId"));
                entity3.setCpuId(rs.getInt("CPUId"));
                entity3.setHeDieuHanhId(rs.getInt("HeDieuHanhId"));
                entity3.setTrongLuongId(rs.getInt("TrongLuongId"));
                entity3.setMausacId(rs.getInt("MauId"));
                entity3.setMoTa(rs.getString("MoTa"));
            }
            return entity3;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<HoaDon> selectHDById(Integer id) {
         return selectHDBySql(SELECTHD_BY_ID_SQL,id);
    }
    
        @Override
    public List<HoaDon> selectHDByTrangthai(Integer id) {
        return selectHDBySql(SELECTHD_BY_TRANGTHAI_SQL, id);
    }

    @Override
    public List<HoaDon> selectHDTangBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList();
        try {
            ResultSet rs = DBConnect.executeQuery(sql, args);
            while(rs.next()){
                HoaDon entity1 = new HoaDon();
                entity1.setHoaDonId(rs.getInt("HoaDonId"));
                entity1.setGhiChu(rs.getString("GhiChu"));
                entity1.setTongTien(rs.getBigDecimal("TongTien"));
                entity1.setThanhToan(rs.getString("ThanhToan"));
                entity1.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(entity1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<HoaDon> selectHDGiamBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList();
        try {
            ResultSet rs = DBConnect.executeQuery(sql, args);
            while(rs.next()){
                HoaDon entity1 = new HoaDon();
                entity1.setHoaDonId(rs.getInt("HoaDonId"));
                entity1.setGhiChu(rs.getString("GhiChu"));
                entity1.setTongTien(rs.getBigDecimal("TongTien"));
                entity1.setThanhToan(rs.getString("ThanhToan"));
                entity1.setTrangThai(rs.getBoolean("TrangThai"));
                list.add(entity1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<HoaDon> selectAllHDTang() {
        return selectHDTangBySql(SELECT_ALLHDTang_SQL);
    }

    @Override
    public List<HoaDon> selectAllHDGiam() {
        return selectHDGiamBySql(SELECT_ALLHDGiam_SQL);
    }


    
}
