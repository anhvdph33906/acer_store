/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;

import java.util.List;
/**
 *
 * @author ADMON
 */
public abstract class HoaDonDAO<EntityType1,EntityType2,KeyType> {
    public abstract List<EntityType1> selectAllHD(KeyType trang);
    public abstract List<EntityType1> selectHDBySql(String sql, Object...args);
    public abstract List<EntityType2> selectAllHDCT(int MaHD);
    public abstract List<EntityType2> selectHDCTBySql(String sql, Object...args);
    public abstract EntityType2 selectAllSPCT(Integer ImeiID);
    public abstract EntityType2 selectSPCTBySql(String sql, Object...args);
    public abstract List<EntityType1> selectHDById(KeyType id);
    public abstract List<EntityType1> selectHDByTrangthai(KeyType id);
    
    public abstract List<EntityType1> selectHDTangBySql(String sql, Object...args);
    public abstract List<EntityType1> selectHDGiamBySql(String sql, Object...args);
    public abstract List<EntityType1> selectAllHDTang();
    public abstract List<EntityType1> selectAllHDGiam();
    
    
}
