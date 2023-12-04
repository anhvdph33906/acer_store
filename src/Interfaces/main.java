/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import com.acerstore.app.dao.SanPhamChiTietDao;
import com.acerstore.app.dao.SanPhamDao;

/**
 *
 * @author JeongDoo
 */
public class main {
    public static void main(String[] args) {
        SanPhamChiTietDao spct = new SanPhamChiTietDao();
        spct.getAllSPCT();
        System.out.println("d"+spct.getAllSPCT());
        SanPhamDao sp = new SanPhamDao();
        System.out.println("sp"+sp.getAll());
    }
    
}
