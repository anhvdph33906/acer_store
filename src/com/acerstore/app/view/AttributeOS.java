package com.acerstore.app.view;

import Interfaces.SanPhamChiTiet;
import com.acerstore.app.model.CPUModel;
import com.acerstore.app.model.OSModel;
import com.acerstore.app.services.OSServices;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class AttributeOS extends JFrame {

    private JPanel pnlLeft;
    private JPanel pnlRight;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnSelect;
    private JButton btnCancel;
    private JTextField txtHang;
    private JTextField txtcongNghe;
    private JTextField txtloaiCPU;
    JTable tblHDH;
    JLabel lblHang;
    JLabel lblcongNghe;
    JLabel lblloai;
    DefaultTableModel model;
    OSServices service = new OSServices();

    public AttributeOS() {
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        showPanel();
        showModel();
        showButton();
        buttonEvent();
        fillToTable(service.getAll());
        pack();
    }

    private void showButton() {
        btnAdd = new JButton("Thêm");
        btnDelete = new JButton("Xoá");
        btnSelect = new JButton("Chọn");
        btnCancel = new JButton("Huỷ");
        pnlRight.add(btnAdd);
        pnlRight.add(btnDelete);
        pnlRight.add(btnCancel);
        pnlRight.setLayout(new FlowLayout());
    }

    private void showModel() {
        Object[][] rows = {};
        String[] cols = {"ID", "CPU"};
        model = new DefaultTableModel(rows, cols);
        tblHDH = new JTable(model);
        pnlLeft.setBorder(new TitledBorder("Thuộc tính CPU"));
        pnlLeft.add(new JScrollPane(tblHDH));
    }

    private void buttonEvent() {
        btnAdd.addActionListener((e) -> {
            try {
                String value = JOptionPane.showInputDialog("Mời nhập vào thuộc tính CPU");
                if (value.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Không được phép bỏ trống");
                } else {
                    int i = service.addCPU(value);
                    if (i != 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        fillToTable(service.getAll());
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
            } catch (Exception ex) {
                System.out.println("Cancel");
            }
        });

        btnDelete.addActionListener((e) -> {
            try {
                int rows = tblHDH.getSelectedRow();
                int index = Integer.parseInt(tblHDH.getValueAt(rows, 0).toString());
                int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá?", "Xoá", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    int del = service.deleteCPU(index);
                    if (del != 0) {
                        JOptionPane.showMessageDialog(this, "Xoá thành công");
                        fillToTable(service.getAll());
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Xoá thất bại");
            }

        });

        btnCancel.addActionListener((e) -> {
            dispose();
        });
    }

    private void fillToTable(List<OSModel> os) {
        model = (DefaultTableModel) tblHDH.getModel();
        model.setRowCount(0);
        for (OSModel o : os) {
            model.addRow(o.toDataRows());
        }
    }

    private void showPanel() {
        pnlLeft = new JPanel();
        pnlRight = new JPanel();
        pnlLeft.setBackground(new Color(255, 255, 255));
        pnlRight.setBackground(new Color(255, 255, 255));
        add(pnlLeft, BorderLayout.CENTER);
        add(pnlRight, BorderLayout.SOUTH);
    }
}
