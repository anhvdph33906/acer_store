/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acerstore.app.dao;

import Interfaces.SanPhamChiTietInterface;
import com.acerstore.app.database.DBConnection;
import com.acerstore.app.model.CPU;
import com.acerstore.app.model.DanhMucs;
import com.acerstore.app.model.HeDieuHanh;
import com.acerstore.app.model.Imei;
import com.acerstore.app.model.KichThuoc;
import com.acerstore.app.model.ManHinh;
import com.acerstore.app.model.Mau;
import com.acerstore.app.model.OCung;
import com.acerstore.app.model.Ram;
import com.acerstore.app.model.SanPhamChiTiets;
import com.acerstore.app.model.SanPhamNew;
import com.acerstore.app.model.ThongSo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class SanPhamChiTietDao implements SanPhamChiTietInterface {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<SanPhamChiTiets> getAllSPCT() {
        List<SanPhamChiTiets> spct = new ArrayList<>();
        sql = "select SanPhamChiTiet.*,SanPham.Ten as TenSP,MANHINH.TenMH as TenMH,RAM.TenRam as TenRam,KICHTHUOC.TenKT as TenKT,CPU.TenCPU as TenCPU,HEDIEUHANH.TenHDH as TenHDH,OCUNG.TenOC as TenOCung,MAU.TenM as TenMau,SanPham.TrangThai as TrangThai,SanPham.MoTa as Mota from SanPhamChiTiet\n"
                + "join SanPham on SanPhamChiTiet.SanPhamId = SanPham.sanphamid\n"
                + "join MANHINH on MANHINH.ManHinhId = SanPhamChiTiet.ManHinhId\n"
                + "join RAM on ram.RamId = SanPhamChiTiet.ramid\n"
                + "join KICHTHUOC on KICHTHUOC.KichThuocId = SanPhamChiTiet.KichThuocId\n"
                + "join CPU on CPU.CPUId = SanPhamChiTiet.CPUId\n"
                + "join HEDIEUHANH on HEDIEUHANH.HeDieuHanhId = SanPhamChiTiet.HeDieuHanhId\n"
                + "join OCUNG on OCUNG.OCungId = SanPhamChiTiet.OCungId\n"
                + "join MAU on MAU.MauId = SanPhamChiTiet.MauId";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTiets spcts = new SanPhamChiTiets(rs.getString("MaSPCT"), rs.getInt("soluong"), rs.getDouble("gia"));
                SanPhamNew sps = new SanPhamNew(rs.getInt("SanPhamId"), rs.getString(2), rs.getString("TenSP"), rs.getString(4), rs.getString(5), rs.getBoolean("TrangThai"), rs.getBytes(7), rs.getString("mota"));
                ManHinh mh = new ManHinh(rs.getInt("ManHinhId"), rs.getString("TenMh"), rs.getBoolean("TrangThai"));
                Ram ra = new Ram(rs.getInt("RamId"), rs.getString("TenRam"), rs.getBoolean("TrangThai"));
                KichThuoc kt = new KichThuoc(rs.getInt("KichThuocId"), rs.getString("TenKT"), rs.getBoolean("TrangThai"));
                CPU cp = new CPU(rs.getInt("CPUId"), rs.getString("TenCPU"), rs.getBoolean("TrangThai"));
                HeDieuHanh hdh = new HeDieuHanh(rs.getInt("HeDieuHanhId"), rs.getString("TenHDH"), rs.getBoolean("TrangThai"));
                OCung oc = new OCung(rs.getInt("OCungId"), rs.getString("TenOCung"), rs.getBoolean("TrangThai"));
                Mau ma = new Mau(rs.getInt("MauId"), rs.getString("TenMau"), rs.getBoolean("TrangThai"));
                spcts.setSp(sps);
                spcts.setMh(mh);
                spcts.setRa(ra);
                spcts.setKt(kt);
                spcts.setCp(cp);
                spcts.setHdh(hdh);
                spcts.setOc(oc);
                spcts.setMa(ma);
                spct.add(spcts);
            }
            return spct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SanPhamChiTiets> getSPShowSPCT(int sanphamid) {
        List<SanPhamChiTiets> spct = new ArrayList<>();
        sql = "select SanPhamChiTiet.MaSPCt,sanpham.Ten,SoLuong,Gia,MANHINH.TenMH,Ram.TenRam,KichThuoc.TenKT,CPU.TenCPU,HeDieuHanh.TenHDH,Ocung.TenOC,Mau.TenM,SanPham.TrangThai,SanPham.MoTa from SanPhamChiTiet\n"
                + "join SanPham on SanPhamChiTiet.SanPhamId = SanPham.sanphamid\n"
                + "join MANHINH on MANHINH.ManHinhId = SanPhamChiTiet.ManHinhId\n"
                + "join RAM on ram.RamId = SanPhamChiTiet.ramid\n"
                + "join KICHTHUOC on KICHTHUOC.KichThuocId = SanPhamChiTiet.KichThuocId\n"
                + "join CPU on CPU.CPUId = SanPhamChiTiet.CPUId\n"
                + "join HEDIEUHANH on HEDIEUHANH.HeDieuHanhId = SanPhamChiTiet.HeDieuHanhId\n"
                + "join OCUNG on OCUNG.OCungId = SanPhamChiTiet.OCungId\n"
                + "join MAU on MAU.MauId = SanPhamChiTiet.MauId where SanPham.SanPhamId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, sanphamid);
            rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTiets spcts = new SanPhamChiTiets(rs.getString("MaSPCT"), rs.getInt("soluong"), rs.getDouble("gia"));
                SanPhamNew sps = new SanPhamNew(rs.getInt("SanPhamId"), rs.getString(2), rs.getString("TenSP"), rs.getString(4), rs.getString(5), rs.getBoolean("TrangThai"), rs.getBytes(7), rs.getString("mota"));
                ManHinh mh = new ManHinh(rs.getInt("ManHinhId"), rs.getString("TenMh"), rs.getBoolean("TrangThai"));
                Ram ra = new Ram(rs.getInt("RamId"), rs.getString("TenRam"), rs.getBoolean("TrangThai"));
                KichThuoc kt = new KichThuoc(rs.getInt("KichThuocId"), rs.getString("TenKT"), rs.getBoolean("TrangThai"));
                CPU cp = new CPU(rs.getInt("CPUId"), rs.getString("TenCPU"), rs.getBoolean("TrangThai"));
                HeDieuHanh hdh = new HeDieuHanh(rs.getInt("HeDieuHanhId"), rs.getString("TenHDH"), rs.getBoolean("TrangThai"));
                OCung oc = new OCung(rs.getInt("OCungId"), rs.getString("TenOCung"), rs.getBoolean("TrangThai"));
                Mau ma = new Mau(rs.getInt("MauId"), rs.getString("TenMau"), rs.getBoolean("TrangThai"));
                spcts.setSp(sps);
                spcts.setMh(mh);
                spcts.setRa(ra);
                spcts.setKt(kt);
                spcts.setCp(cp);
                spcts.setHdh(hdh);
                spcts.setOc(oc);
                spcts.setMa(ma);
                spct.add(spcts);
            }
            return spct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<SanPhamChiTiets> getMa(String masp) {
        List<SanPhamChiTiets> sp = new ArrayList<>();
        SanPhamChiTiets s = null;
        sql = "select sanpham.MaSP,sanpham.Ten,SoLuong,Gia,thongso.ManHinh,thongso.Ram,thongso.KichThuoc,thongso.CPU,thongso.HeDieuHanh,thongso.TrongLuong,thongso.Mau,SanPham.TrangThai,sanpham.MoTa  from SanPhamChiTiet\n"
                + "join SanPham on SanPhamChiTiet.sanphamid = SanPham.SanPhamId\n"
                + "join ThongSo on ThongSo.ThongSoId = SanPhamChiTiet.ThongSoId where MaSP=?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, masp);
            rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(s);
            }
            return sp;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public int AddManHinh(ManHinh mh) {
        sql = "insert into MANHINH(TenMH,TrangThai) values (?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, mh.getTenMh());
            ps.setBoolean(2, mh.isTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int AddRam(Ram ram) {
        sql = "insert into Ram(TenRam,TrangThai) values (?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ram.getTenRam());
            ps.setBoolean(2, ram.isTtRam());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int AddKichThuoc(KichThuoc kichthuoc) {
        sql = "insert into KICHTHUOC(TenKT,TrangThai) values  (?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, kichthuoc.getTenKT());
            ps.setBoolean(2, kichthuoc.isTtKT());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int AddCPU(CPU cpu) {
        sql = "insert into CPU(TenCPU,TrangThai) (?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cpu.getTenCPU());
            ps.setBoolean(2, cpu.isTtCPU());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int AddHeDieuHanh(HeDieuHanh hdh) {
        sql = "insert into HEDIEUHANH(TenHDH,TrangThai) values (?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, hdh.getTenHDH());
            ps.setBoolean(2, hdh.isTtHDH());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int AddOCung(OCung ocung) {
        sql = "insert into OCUNG(TenOC,TrangThai) values (?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ocung.getTenOCung());
            ps.setBoolean(2, ocung.isTtOCung());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int AddMau(Mau mau) {
        sql = "insert into MAU(TenM,TrangThai) values (?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, mau.getTenMau());
            ps.setBoolean(2, mau.isTtMau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public List<ManHinh> getMH() {
        List<ManHinh> m = new ArrayList<>();
        ManHinh mh = null;
        sql = "select * from MANHINH";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                mh = new ManHinh(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                m.add(mh);
            }
            return m;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public List<Ram> getRam() {
        List<Ram> r = new ArrayList<>();
        Ram ra = null;
        sql = "select * from Ram";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ra = new Ram(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                r.add(ra);
            }
            return r;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public List<KichThuoc> getKichThuoc() {
        List<KichThuoc> kt = new ArrayList<>();
        KichThuoc k = null;
        sql = "select * from KICHTHUOC";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                k = new KichThuoc(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                kt.add(k);
            }
            return kt;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public List<CPU> getCPU() {
        List<CPU> cpu = new ArrayList<>();
        CPU cp = null;
        sql = "select * from CPU";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cp = new CPU(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                cpu.add(cp);
            }
            return cpu;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public List<Mau> getMau() {
        List<Mau> mau = new ArrayList<>();
        Mau ma = null;
        sql = "select * from Mau";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ma = new Mau(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                mau.add(ma);
            }
            return mau;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public List<OCung> getOCung() {
        List<OCung> Ocung = new ArrayList<>();
        OCung OCung = null;
        sql = "select * from OCung";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                OCung = new OCung(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                Ocung.add(OCung);
            }
            return Ocung;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public List<HeDieuHanh> getHeDieuHanh() {
        List<HeDieuHanh> hdh = new ArrayList<>();
        HeDieuHanh h = null;
        sql = "select * from HEDIEUHANH";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                h = new HeDieuHanh(rs.getInt(1), rs.getString(2), rs.getBoolean(3));
                hdh.add(h);
            }
            return hdh;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public int updateMh(ManHinh m, int id) {
        sql = "update MANHINH set TenMH=?,TrangThai=? where ManHinhId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getTenMh());
            ps.setBoolean(2, m.isTrangThai());
            ps.setInt(3, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int updateRam(Ram m, int id) {
        sql = "update RAM set TenRam=?,TrangThai=? where RamId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getTenRam());
            ps.setBoolean(2, m.isTtRam());
            ps.setInt(3, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int updateKt(KichThuoc m, int id) {
        sql = "update KICHTHUOC set TenKT=?,TrangThai=? where KichThuocId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getTenKT());
            ps.setBoolean(2, m.isTtKT());
            ps.setInt(3, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int updateCPU(CPU m, int id) {
        sql = "update CPU set TenCPU=?,TrangThai=? where CPUId=?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getTenCPU());
            ps.setBoolean(2, m.isTtCPU());
            ps.setInt(3, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int updateHDH(HeDieuHanh m, int id) {
        sql = "update HEDIEUHANH set TenHDH=?,TrangThai=? where HeDieuHanhId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getTenHDH());
            ps.setBoolean(2, m.isTtHDH());
            ps.setInt(3, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int updateOCung(OCung m, int id) {
        sql = "update OCUNG set TenOC=?,TrangThai =? where OCungId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getTenOCung());
            ps.setBoolean(2, m.isTtOCung());
            ps.setInt(3, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int updateMau(Mau m, int id) {
        sql = "update MAU set TenM=?,TrangThai=? where MauId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getTenMau());
            ps.setBoolean(2, m.isTtMau());
            ps.setInt(3, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public List<SanPhamChiTiets> LikeMaCT(String tenHinh) {
        List<SanPhamChiTiets> sp = new ArrayList<>();
        SanPhamChiTiets s = null;
        sql = "select sanpham.MaSP,sanpham.Ten,SoLuong,Gia,thongso.ManHinh,thongso.Ram,thongso.KichThuoc,thongso.CPU,thongso.HeDieuHanh,thongso.TrongLuong,thongso.Mau,SanPham.TrangThai,sanphamchitiet.MoTa  from SanPhamChiTiet\n"
                + "join SanPham on SanPhamChiTiet.sanphamid = SanPham.SanPhamId \n"
                + "join ThongSo on ThongSo.ThongSoId = SanPhamChiTiet.ThongSoId where ManHinh like '%" + tenHinh + "%'";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tenHinh);
            rs = ps.executeQuery();
            while (rs.next()) {
                sp.add(s);
            }
            return sp;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public int deleteMH(int id) {
        sql = "delete from MANHINH where ManHinhId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int deleteRam(int id) {
        sql = "delete from RAM where RamId=?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int deleteKT(int id) {
        sql = "delete from KICHTHUOC where KichThuocId = ?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int deleteCPU(int id) {
        sql = "delete from CPU where CPUId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int deleteHDH(int id) {
        sql = "delete from HEDIEUHANH where HeDieuHanhId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int deleteOCung(int id) {
        sql = "delete from OCUNG where OCungId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public int deleteMau(int id) {
        sql = "delete from MAU where MauId =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    public boolean CheckSP(SanPhamChiTiets s) {
        sql = "select SanPhamChiTiet.soluong from SanPhamChiTiet\n"
                + "	join SanPham on sanpham.SanPhamId = SanPhamChiTiet.sanphamid";
        boolean tt = true;
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int soluong = rs.getInt("soluong");
                tt = soluong > 0;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return tt;
    }

    public ArrayList<SanPhamChiTiets> getSanPhamCT(int pageSelect) {
        ArrayList<SanPhamChiTiets> listSPCT = new ArrayList<>();
        String query = "select sanpham.MaSP,sanpham.Ten,IMEI.Ma,SoLuong,Gia,MANHINH.TenMH,Ram.TenRam,KichThuoc.TenKT,CPU.TenCPU,HeDieuHanh.TenHDH,Ocung.TenOC,Mau.TenM,sanphamchitiet.trangthai,sanpham.MoTa from SanPhamChiTiet\n"
                + "join select SanPhamChiTiet.MaSPCt,sanpham.Ten,SoLuong,Gia,MANHINH.TenMH,Ram.TenRam,KichThuoc.TenKT,CPU.TenCPU,HeDieuHanh.TenHDH,Ocung.TenOC,Mau.TenM,SanPham.TrangThai,SanPham.MoTa from SanPhamChiTiet\n"
                + "join SanPham on SanPhamChiTiet.SanPhamId = SanPham.sanphamid\n"
                + "join MANHINH on MANHINH.ManHinhId = SanPhamChiTiet.ManHinhId\n"
                + "join RAM on ram.RamId = SanPhamChiTiet.ramid\n"
                + "join KICHTHUOC on KICHTHUOC.KichThuocId = SanPhamChiTiet.KichThuocId\n"
                + "join CPU on CPU.CPUId = SanPhamChiTiet.CPUId\n"
                + "join HEDIEUHANH on HEDIEUHANH.HeDieuHanhId = SanPhamChiTiet.HeDieuHanhId\n"
                + "join OCUNG on OCUNG.OCungId = SanPhamChiTiet.OCungId\n"
                + "join MAU on MAU.MauId = SanPhamChiTiet.MauId \n"
                + "ORDER BY SanPham.MaSP\n"
                + "OFFSET ? ROWS	\n"
                + "FETCH NEXT 5 ROWS ONLY;";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, pageSelect);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                SanPhamChiTiets spcts = new SanPhamChiTiets(rs.getString("maspct"), rs.getInt("soluong"), rs.getDouble("gia"));
                SanPhamNew sps = new SanPhamNew(rs.getInt("SanPhamId"), rs.getString("masp"), rs.getString("ten"), rs.getString("xuatxu"), rs.getString("ngay"), rs.getBoolean("trangthai"), rs.getBytes("HinhAnh"), rs.getString("mota"));
                ManHinh mh = new ManHinh(rs.getInt("ManHinhId"), rs.getString("ten"), rs.getBoolean("tt"));
                Ram ra = new Ram(rs.getInt("RamId"), rs.getString("ten"), rs.getBoolean("tt"));
                KichThuoc kt = new KichThuoc(rs.getInt("KichThuocId"), rs.getString("ten"), rs.getBoolean("tt"));
                CPU cp = new CPU(rs.getInt("CPUId"), rs.getString("ten"), rs.getBoolean("tt"));
                HeDieuHanh hdh = new HeDieuHanh(rs.getInt("HeDieuHanhId"), rs.getString("ten"), rs.getBoolean("tt"));
                OCung oc = new OCung(rs.getInt("OCungId"), rs.getString("ten"), rs.getBoolean("tt"));
                Mau ma = new Mau(rs.getInt("MauId"), rs.getString("ten"), rs.getBoolean("tt"));
                spcts.setSp(sps);
                spcts.setMh(mh);
                spcts.setRa(ra);
                spcts.setKt(kt);
                spcts.setCp(cp);
                spcts.setHdh(hdh);
                spcts.setOc(oc);
                spcts.setMa(ma);
                listSPCT.add(spcts);
            }
            return listSPCT;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Imei> getIMEI() {
        List<Imei> listMSP = new ArrayList<>();
        String sql = "select * from IMEI";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Imei i = new Imei(rs.getInt(1), rs.getString(2));
                listMSP.add(i);
            }
            return listMSP;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getCountIMEI() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT COUNT(*) AS total FROM IMEI";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt("total");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList getSPCT() {
        ArrayList sp = new ArrayList<>();
        sql = "select * from SanPhamChiTiet";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maSPCT = rs.getString("maspct");
                sp.add(maSPCT);
            }
            return sp;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public int AddSPdedail(String maspct, int soLuong, double gia, int idmanHinh, int idRam, int idkichThuoc, int idcPU, int idheDieuHanh, int idOcunng, int idmau, int imei, int idsanpham) {
        sql = "insert into SanPhamChiTiet (MaSPCT,SoLuong,Gia,ManHinhId,RamId,KichThuocId,CPUId,HeDieuHanhId,OCungId,MauId,ImeiId,sanphamid) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, maspct);
            ps.setInt(2, soLuong);
            ps.setDouble(3, gia);
            ps.setString(4, String.valueOf(idmanHinh));
            ps.setString(5, String.valueOf(idRam));
            ps.setString(6, String.valueOf(idkichThuoc));
            ps.setString(7, String.valueOf(idcPU));
            ps.setString(8, String.valueOf(idheDieuHanh));
            ps.setString(9, String.valueOf(idOcunng));
            ps.setString(10, String.valueOf(idmau));
            ps.setString(11, String.valueOf(imei));
            ps.setString(12, String.valueOf(idsanpham));
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int UpdateSPdedail( double gia, int idmanHinh, int idRam, int idkichThuoc, int idcPU, int idheDieuHanh, int idOcunng, int idmau,String maspct) {
        sql = "update SanPhamChiTiet set Gia=?,ManHinhId =?,RamId=?,KichThuocId=?,CPUId =?,HeDieuHanhId=?,OCungId=?,MauId=? where MaSPCT =?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, gia);
            ps.setString(2, String.valueOf(idmanHinh));
            ps.setString(3, String.valueOf(idRam));
            ps.setString(4, String.valueOf(idkichThuoc));
            ps.setString(5, String.valueOf(idcPU));
            ps.setString(6, String.valueOf(idheDieuHanh));
            ps.setString(7, String.valueOf(idOcunng));
            ps.setString(8, String.valueOf(idmau));        
            ps.setString(9, maspct);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    @Override
    public int add(SanPhamChiTiets spct) {
        try {
            String sql = "insert into SanPhamChiTiet(SoLuong,Gia,ManHinhId,RamId,KichThuocId,CPUId,HeDieuHanhId,OCungId,MauId,ImeiId,trangthai,sanphamid) values(?,?,?,?,?,?,?,?,?,?,?,?)";

            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }

    @Override
    public int update(SanPhamChiTiets spcts, String ma) {
        sql = "update SanPhamChiTiet set SoLuong=?,Gia=?,ManHinhId=?,RamId=?,KichThuocId=?,CPUId=?,OCungId=?,MauId=? where Gia=?";
        try {
            con = DBConnection.getConnection();
            ps = con.prepareStatement(sql);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
            return 0;
        }
    }
}
