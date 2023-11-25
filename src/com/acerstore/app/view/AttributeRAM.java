package com.acerstore.app.view;

import Interfaces.SanPhamChiTiet;
import com.acerstore.app.model.CPUModel;
import com.acerstore.app.model.OSModel;
import com.acerstore.app.model.RAMModel;
import com.acerstore.app.services.OSServices;
import com.acerstore.app.services.RAMServices;
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

public class AttributeRAM extends JFrame {

    private JPanel pnlTop;
    private JPanel pnlBottom;
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnCancel;
    JTable tblRAM;
    DefaultTableModel model;
    RAMServices service = new RAMServices();

    public AttributeRAM() {
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
        btnUpdate = new JButton("Sửa");
        btnDelete = new JButton("Xoá");
        btnCancel = new JButton("Huỷ");
        pnlBottom.add(btnAdd);
        pnlBottom.add(btnUpdate);
        pnlBottom.add(btnDelete);
        pnlBottom.add(btnCancel);
        pnlBottom.setLayout(new FlowLayout());
    }

    private void showModel() {
        Object[][] rows = {};
        String[] cols = {"ID", "RAM", "Trạng thái"};
        model = new DefaultTableModel(rows, cols) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };
        tblRAM = new JTable(model);
        pnlTop.setBorder(new TitledBorder("Thuộc tính RAM"));
        pnlTop.add(new JScrollPane(tblRAM));
    }

    private void buttonEvent() {
        btnAdd.addActionListener((e) -> {
            try {
                String value = JOptionPane.showInputDialog("Mời nhập vào thuộc tính RAM");
                if (value.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Không được phép bỏ trống");
                } else {
                    if (service.checkDuplicate(value) != 0) {
                        int number = service.addRAM(value);
                        if (number != 0) {
                            JOptionPane.showMessageDialog(this, "Thêm thành công");
                            fillToTable(service.getAll());
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại");
                    }
                }
            } catch (Exception ex) {
                System.out.println("Cancel");
            }
        });

        btnUpdate.addActionListener((e) -> {
            int rows = tblRAM.getSelectedRow();
            int id = Integer.parseInt(tblRAM.getValueAt(rows, 0).toString());
            String data = tblRAM.getValueAt(rows, 1).toString();
            if (service.checkDuplicate(data) != 0) {
                int number = service.updateRAM(data, id);
                if (number != 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    fillToTable(service.getAll());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }
        });

        btnDelete.addActionListener((e) -> {
            try {
                int rows = tblRAM.getSelectedRow();
                int id = Integer.parseInt(tblRAM.getValueAt(rows, 0).toString());
                int result = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá?", "Xoá", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    int number = service.deleteRAM(id);
                    if (number != 0) {
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

    private void fillToTable(List<RAMModel> lst) {
        model = (DefaultTableModel) tblRAM.getModel();
        model.setRowCount(0);
        for (RAMModel ram : lst) {
            model.addRow(ram.toDataRows());
        }
    }

    private void showPanel() {
        pnlTop = new JPanel();
        pnlBottom = new JPanel();
        pnlTop.setBackground(new Color(255, 255, 255));
        pnlBottom.setBackground(new Color(255, 255, 255));
        add(pnlTop, BorderLayout.CENTER);
        add(pnlBottom, BorderLayout.SOUTH);
    }
}
