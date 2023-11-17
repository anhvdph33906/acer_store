package com.acerstore.app.dao;

import com.acerstore.app.database.DBConnect;
import com.acerstore.app.model.SanPhamModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO extends AcerDAO<SanPhamModel, String> {

    String SELECT_ALL_SQL = "SELECT SanPham.MaSP, SanPham.Ten, spct.SoLuong, spct.Gia, spct.TrangThai, spct.MoTa FROM SanPham \n"
            + "INNER JOIN SanPhamChiTiet spct ON SanPham.SanPhamChiTietId = spct.SanPhamChiTietId";

    @Override
    public void insert(SanPhamModel e) {

    }

    @Override
    public void update(SanPhamModel e) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public List<SanPhamModel> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public SanPhamModel selectById(String id) {
        return null;
    }

    @Override
    public List<SanPhamModel> selectBySql(String sql, Object... args) {
        List<SanPhamModel> lstSanPham = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.executeQuery(sql, args);
            while (rs.next()) {
                SanPhamModel sp = new SanPhamModel();
                sp.setMaSP(rs.getString(1));
                sp.setTenSP(rs.getString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setGiaBan(rs.getLong(4));
                sp.setTrangThai(rs.getByte(5));
                sp.setMoTa(rs.getString(6));
                lstSanPham.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstSanPham;
    }
}
