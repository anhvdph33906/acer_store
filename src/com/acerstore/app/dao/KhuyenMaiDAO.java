/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;

import com.acerstore.app.database.DBConnect;
import com.acerstore.app.model.KhuyenMaiModel;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class KhuyenMaiDAO extends AcerDAO<KhuyenMaiModel, String>{
    
    final String INSERT_SQL = "insert into Khuyenmai(MaKM, TenKM, KieuKM, TriGia, TGBD, TGKT, TrangThai) values (?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "update KhuyenMai set TenKM = ?, KieuKM = ?, TriGia = ?, TGBD = ?, TGKT = ?, TrangThai = ? where MaKM = ?";
    final String SELECT_ALL_SQL = "select * from KhuyenMai";
    final String SELECT_BY_ID_SQL = "select * from KhuyenMai where MaKM = ?";

    @Override
    public void insert(KhuyenMaiModel e) {
        DBConnect.executeUpdate(INSERT_SQL, e.getMaKM(), e.getTenKM(), e.getKieuKM(), e.getTriGia(), e.getThoiGianBatDau(), e.getThoiGianKetThuc(), e.getTrangThai());
    }

    @Override
    public void update(KhuyenMaiModel e) {
        DBConnect.executeUpdate(UPDATE_SQL, e.getTenKM(), e.getKieuKM(), e.getTriGia(), e.getThoiGianBatDau(), e.getThoiGianKetThuc(), e.getTrangThai(), e.getMaKM());
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<KhuyenMaiModel> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public KhuyenMaiModel selectById(String id) {
        List<KhuyenMaiModel> list = selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhuyenMaiModel> selectBySql(String sql, Object... args) {
        List<KhuyenMaiModel> list = new ArrayList();
        try {
            ResultSet rs = DBConnect.executeQuery(sql, args);
            while(rs.next()){
                KhuyenMaiModel entity = new KhuyenMaiModel();
                entity.setMaKM(rs.getString("MaKM"));
                entity.setTenKM(rs.getString("TenKM"));
                entity.setKieuKM(rs.getString("KieuKM"));
                entity.setTriGia(rs.getDouble("TriGia"));
                entity.setThoiGianBatDau(rs.getDate("TGBD"));
                entity.setThoiGianKetThuc(rs.getDate("TGKT"));
                entity.setTrangThai(rs.getString("TrangThai"));
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
    
    public List<KhuyenMaiModel> selectByKeyword(String keyword) {
        String SQL = "SELECT * FROM KhuyenMai WHERE TenKM LIKE ?";
        return this.selectBySql(SQL, "%" + keyword + "%");
    }
    
}
