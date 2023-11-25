/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.services;

import com.acerstore.app.database.DBConnection;
import com.acerstore.app.model.OSModel;
import com.acerstore.app.model.RAMModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class RAMServices {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<RAMModel> getAll() {
        sql = "SELECT RamId, TenRam, TrangThai FROM RAM";
        List<RAMModel> lstRAM = new ArrayList<>();
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RAMModel ram = new RAMModel();
                ram.setiD(rs.getString(1));
                ram.setThongTin(rs.getString(2));
                ram.setTrangThai(rs.getBoolean(3));
                lstRAM.add(ram);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lstRAM;
    }

    public int addRAM(String value) {
        sql = "INSERT INTO RAM (TenRam) VALUES (?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, value);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateRAM(String value, int id) {
        sql = "UPDATE RAM SET TenRam = ? WHERE RamId = ?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, value);
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteRAM(int id) {
        sql = "DELETE FROM RAM WHERE RamId = ?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int checkDuplicate(String value) {
        List<RAMModel> lstRAM = getAll();
        for (RAMModel ram : lstRAM) {
            if (ram.getThongTin().equals(value))
                return 0;           
        }
        return 1;
    }
}
