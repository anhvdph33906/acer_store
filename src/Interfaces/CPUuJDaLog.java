/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package Interfaces;

import com.acerstore.app.dao.SanPhamChiTietDao;
import com.acerstore.app.model.CPU;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JeongDoo
 */
public class CPUuJDaLog extends java.awt.Dialog {

    DefaultTableModel tblmodel;
    SanPhamChiTietDao spcdao = new SanPhamChiTietDao();

    public CPUuJDaLog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.filltoTableCPU(spcdao.getCPU());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCPU = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCPU = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        rdoHD = new javax.swing.JRadioButton();
        rdoKHD = new javax.swing.JRadioButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        tblCPU.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "CPU", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCPU.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCPUMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCPU);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel1.setText("Tên");

        btnAdd.setText("ADD");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel3.setText("Trạng thái");

        rdoHD.setSelected(true);
        rdoHD.setText("Hoạt động");

        rdoKHD.setText("Không hoạt động");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCPU, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAdd)
                                    .addComponent(rdoHD))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoKHD))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(btnUpdate)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDelete)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtCPU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rdoHD)
                    .addComponent(rdoKHD))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void tblCPUMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCPUMouseClicked
        // TODO add your handling code here:
        int index = tblCPU.getSelectedRow();
        showDetailCPU(index);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tblCPUMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        this.addCPU();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        this.delete();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        this.updateCPU();
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CPUuJDaLog dialog = new CPUuJDaLog(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoHD;
    private javax.swing.JRadioButton rdoKHD;
    private javax.swing.JTable tblCPU;
    private javax.swing.JTextField txtCPU;
    // End of variables declaration//GEN-END:variables

    private void showDetailCPU(int index) {
        CPU cpu = spcdao.getCPU().get(index);
        txtCPU.setText(cpu.getTenCPU());
        rdoHD.setSelected(cpu.isTtCPU());
        tblCPU.setRowSelectionInterval(index, index);
    }

    private void addCPU() {
        if (checkDataCPU()) {
            CPU cpu = readDataCPU();
            if (spcdao.AddCPU(cpu) > 0) {
                JOptionPane.showMessageDialog(this, "add successful");
                filltoTableCPU(spcdao.getCPU());
            } else {
                JOptionPane.showMessageDialog(this, "add failed");
            }
        }
    }

    private void delete() {
        int index = tblCPU.getSelectedRow();
        int id = Integer.parseInt(tblCPU.getValueAt(index, 0).toString());
        if (spcdao.deleteCPU(id) > 0) {
            JOptionPane.showMessageDialog(this, "delete successful");
            filltoTableCPU(spcdao.getCPU());
        } else {
            JOptionPane.showMessageDialog(this, "delete failed");
        }
        txtCPU.setText("");
        rdoHD.isSelected();
        btnDelete.setEnabled(false);
    }

    private CPU readDataCPU() {
        int id = 0;
        String ten = txtCPU.getText();
        boolean tt;
        if (tt = rdoHD.isSelected()) {
            tt = true;
        } else {
            tt = false;
        }
        return new CPU(id, ten, tt);
    }

    private void updateCPU() {
        if (checkDataCPU()) {
            CPU mh = readDataCPU();
            int index = tblCPU.getSelectedRow();
            int id = Integer.parseInt(tblCPU.getValueAt(index, 0).toString());
            if (spcdao.updateCPU(mh, id) > 0) {
                JOptionPane.showMessageDialog(this, "update successful");
                filltoTableCPU(spcdao.getCPU());
            } else {
                JOptionPane.showMessageDialog(this, "update failed");
            }
            txtCPU.setText("");
            rdoHD.isSelected();
            btnUpdate.setEnabled(false);
        }
    }

    private boolean checkDataCPU() {
        if (txtCPU.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "empty");
            txtCPU.requestFocus();
            return false;
        }
        return true;
    }

    private void filltoTableCPU(List<CPU> cp) {
        tblmodel = (DefaultTableModel) tblCPU.getModel();
        tblmodel.setRowCount(0);
        for (CPU cpu : cp) {
            tblmodel.addRow(new Object[]{
                cpu.getIdCPU(),
                cpu.getTenCPU(),
                cpu.isTtCPU() ? "Hoạt động" : "Không hoạt động"
            });
        }
    }
}