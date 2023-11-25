package com.acerstore.app.services;

import com.acerstore.app.database.*;
import com.acerstore.app.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OSServices {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<OSModel> getAll() {
        sql = "SELECT HeDieuHanhId, TenHDH FROM HeDieuHanh";
        List<OSModel> lstOS = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                OSModel os = new OSModel();
                os.setiD(rs.getString(1));
                os.setThongTin(rs.getString(2));
                lstOS.add(os);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lstOS;
    }
    
    public int addCPU(String value) {
        sql = "INSERT INTO HeDieuHanh (TenHDH) VALUES (?)";
        try {
            con = DBConnection.getConnection();          
            ps = con.prepareStatement(sql);
            ps.setObject(1, value);
            ps.setObject(1, value);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int deleteCPU(int index) {
        sql = "DELETE FROM HeDieuHanh WHERE HeDieuHanhId = ?";
        try {
            con = DBConnection.getConnection();          
            ps = con.prepareStatement(sql);
            ps.setObject(1, index);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
