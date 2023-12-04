/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;

import com.acerstore.app.database.DBConnection;
import com.acerstore.app.model.DanhMucs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DanhMucDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<DanhMucs> getAllDM() {
        List<DanhMucs> dm = new ArrayList<>();
        DanhMucs d = null;
        sql = "select * from DanhMuc";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                d = new DanhMucs(rs.getInt(1), rs.getString(2));
                dm.add(d);
            }
            return dm;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public void insertDM(String name) {
        sql = "insert into DanhMuc (TenDM) values (?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, name);
            ps.execute();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public int deleteDM(String ma) {

        sql = "delete from DanhMuc where MaDM =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int updateDM(DanhMucs d, String madm) {
        sql = "update DanhMuc set TenDM =? where MaDM =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, d.getTenDm());
            ps.setObject(2, madm);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }
}
