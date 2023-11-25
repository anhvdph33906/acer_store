package com.acerstore.app.services;

import com.acerstore.app.database.*;
import com.acerstore.app.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CPUServices {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<CPUModel> getAll() {
        sql = "SELECT CPUId, TenCPU FROM CPU";
        List<CPUModel> lstCPU = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CPUModel cpu = new CPUModel();
                cpu.setiD(rs.getString(1));
                cpu.setThongTin(rs.getString(2));
                lstCPU.add(cpu);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lstCPU;
    }
    
    public int addCPU(String value) {
        sql = "INSERT INTO CPU (TenCPU) VALUES (?)";
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
        sql = "DELETE FROM CPU WHERE CPUId = ?";
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
