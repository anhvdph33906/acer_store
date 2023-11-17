package com.acerstore.app.dao;

import com.acerstore.app.database.DBConnect;
import com.acerstore.app.model.HoaDonCho;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoaDonChoDAO extends AcerDAO {

    String SELECT_ALL_SQL = "SELECT HoaDon.MaHD, MaNV, ngayTao, HoaDon.TrangThai FROM HoaDonCho\n"
            + "INNER JOIN HoaDon ON HoaDonCho.HoaDonId = HoaDon.HoaDonId";

    @Override
    public void insert(Object e) {

    }

    @Override
    public void update(Object e) {

    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Object selectById(Object id) {
        return null;
    }

    @Override
    public List selectBySql(String sql, Object... args) {
        List<HoaDonCho> lstHDC = new ArrayList<>();
        try {
            ResultSet rs = DBConnect.executeQuery(sql, args);
            while (rs.next()) {
                HoaDonCho hdc = new HoaDonCho();
                hdc.setMaHD(rs.getString(1));
                hdc.setMaNV(rs.getString(2));
                hdc.setNgayTao(rs.getString(3));
                hdc.setTrangThai(rs.getBoolean(4));
                lstHDC.add(hdc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHDC;
    }
}
