/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.acerstore.app.view;

import Interfaces.SanPhamChiTiet;
import com.acerstore.app.dao.SanPhamChiTietDao;
import com.acerstore.app.database.DBConnection;
import com.acerstore.app.model.Imei;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.xmlbeans.XmlObject;
import org.apache.commons.collections4.ListValuedMap;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 *
 * @author Admin
 */
public class IMEIDialog extends javax.swing.JDialog {

    private int currentPage = 1;
    private int pageSize = 8;
    private ArrayList<Imei> list;
    private SanPhamChiTietDao spct = new SanPhamChiTietDao();
    private DefaultTableModel model = new DefaultTableModel();

    public IMEIDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        setLocationRelativeTo(null);
        GetData();
        updateLabelCount();
    }

    void GetData() {
        try {
            Connection conn = DBConnection.getConnection();

            String sqlCount = "SELECT COUNT(*) AS total FROM IMEI";
            PreparedStatement pstmtCount = conn.prepareStatement(sqlCount);
            ResultSet rsCount = pstmtCount.executeQuery();
            rsCount.next();

            String sql = "SELECT * FROM IMEI ORDER BY Ma OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (currentPage - 1) * pageSize);
            pstmt.setInt(2, pageSize);
            ResultSet rs = pstmt.executeQuery();

            model = (DefaultTableModel) tblIMEI.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                int idImei = rs.getInt("ImeiId");
                String ma = rs.getString("Ma");
                Object[] data = {idImei,ma};
                model.addRow(data);
            }
            updateTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateTable() {
        int totalRows = getTotalRows();
        int totalPages = (int) Math.ceil((double) totalRows / pageSize);

        lblTrang.setText("Page " + currentPage + " of " + totalPages);
        btnFirst.setEnabled(currentPage > 1);
        btnLast.setEnabled(currentPage < totalPages);
    }

    private int getTotalRows() {
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

    boolean validateData() {
        if (txtIMEI.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa nhập IMEI");
            return false;
        }
        return true;
    }

    void insertIMEI() {
        String query = "INSERT INTO IMEI (Ma) VALUES(?)";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, txtIMEI.getText());
            pstmt.execute();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            updateLabelCount();
            GetData();
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }

    void getDataRow() {
        int selectedRow = tblIMEI.getSelectedRow();
        txtIMEI.setText((String) tblIMEI.getValueAt(selectedRow, 1));
    }

    void clearForm() {
        txtIMEI.setText("");
    }

    void first() {
        if (currentPage > 1) {
            currentPage--;
            GetData();
            updateTable();
        }
    }

    void last() {
        int maxPage = (int) Math.ceil((double) getTotalRows() / pageSize);
        if (currentPage < maxPage) {
            currentPage++;
            GetData();
            updateTable();
        }
    }

    public int readExcelAndUpdateTable() {
        DefaultTableModel model = (DefaultTableModel) tblIMEI.getModel();
        model.setRowCount(0);
        File excelFile;
        FileInputStream excelinput = null;
        BufferedInputStream excelbuffer = null;
        XSSFWorkbook workbook = null;
        String tcurrentDirectoryPath = "C:\\Users\\Tan\\Documents\\srcExcecl";
        JFileChooser fileChooser = new JFileChooser(tcurrentDirectoryPath);
        fileChooser.setDialogTitle("Select Excel file");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
        fileChooser.setFileFilter(fnef);
        int excelChooser = fileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = fileChooser.getSelectedFile();
                excelinput = new FileInputStream(excelFile);
                excelbuffer = new BufferedInputStream(excelinput);
                workbook = new XSSFWorkbook(excelbuffer);
                XSSFSheet sheet = workbook.getSheetAt(0);
                DataFormatter dataFormatter = new DataFormatter();
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    XSSFRow row = sheet.getRow(i);
                    XSSFCell Ma = row.getCell(0);
                    String cellValue = dataFormatter.formatCellValue(Ma);
                    model.addRow(new Object[]{cellValue});

                }
                JOptionPane.showMessageDialog(this, "Thành công");
                insertDataToDatabase();
                GetData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Het cuu");
            } finally {
                try {
                    if (excelinput != null) {
                        excelinput.close();
                    }
                    if (excelbuffer != null) {
                        excelbuffer.close();
                    }
                    if (workbook != null) {
                        workbook.close();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }
            }
        }
        return 0;
    }

    private void insertDataToDatabase() {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO IMEI (Ma) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < model.getRowCount(); i++) {
                String ma = model.getValueAt(i, 0).toString();
                pstmt.setString(1, ma);
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi chuyển dữ liệu lên cơ sở dữ liệu: " + e.getMessage());
        }
    }

    private void deleteAllDataFromDatabase() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establish a database connection
            connection = DBConnection.getConnection();

            // SQL statement to delete all data
            String deleteQuery = "DELETE FROM IMEI"; // Replace your_table_name with your actual table name

            // Create a prepared statement
            preparedStatement = connection.prepareStatement(deleteQuery);

            // Execute the delete statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xoá dữ liệu từ database: " + e.getMessage());
        } finally {
            try {
                // Close resources in the reverse order of their creation
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi đóng kết nối: " + e.getMessage());
            }
        }
    }

    private void updateLabelCount() {
        try {
            Connection conn = DBConnection.getConnection();

            String sqlCount = "SELECT COUNT(*) AS total FROM IMEI";
            PreparedStatement pstmtCount = conn.prepareStatement(sqlCount);
            ResultSet rsCount = pstmtCount.executeQuery();
            rsCount.next();

            int totalCount = rsCount.getInt("total");
            lblSoLuong.setText("IMEI Count: " + totalCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIMEI = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIMEI = new javax.swing.JTable();
        btnLast = new javax.swing.JButton();
        lblTrang = new javax.swing.JLabel();
        btnFirst = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        lblSoLuong = new javax.swing.JLabel();
        btnThem1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("IMEI: ");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        tblIMEI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Imei", "Mã IMEI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIMEI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIMEIMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIMEI);

        btnLast.setText(">>");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        lblTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTrang.setText("Trang");

        btnFirst.setText("<<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnExcel.setText("Thêm 1");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        lblSoLuong.setText("Số lượng:");

        btnThem1.setText("Xoá");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTrang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIMEI, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExcel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(lblSoLuong)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSoLuong)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIMEI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem)
                    .addComponent(btnExcel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTrang))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        first();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (validateData()) {
            this.insertIMEI();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblIMEIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIMEIMouseClicked
        // TODO add your handling code here:
        getDataRow();
    }//GEN-LAST:event_tblIMEIMouseClicked

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        // TODO add your handling code here:
        readExcelAndUpdateTable();
        updateLabelCount();
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete all data?", "Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            // Delete all data from the database
            deleteAllDataFromDatabase();

            // Clear the table
            DefaultTableModel model = (DefaultTableModel) tblIMEI.getModel();
            model.setRowCount(0);
            updateLabelCount();

            JOptionPane.showMessageDialog(this, "All data deleted successfully.");
        }
    }//GEN-LAST:event_btnThem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IMEIDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IMEIDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IMEIDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IMEIDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IMEIDialog dialog = new IMEIDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTrang;
    private javax.swing.JTable tblIMEI;
    private javax.swing.JTextField txtIMEI;
    // End of variables declaration//GEN-END:variables
}
