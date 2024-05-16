/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package busticket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander
 */
public class MT_06_PreviewAndPayment extends javax.swing.JFrame {

    /**
     * Creates new form MT_06_PreviewAndPayment
     */
    public MT_06_PreviewAndPayment() {
        initComponents();
        showDate();
        showTime();
        showTransac();
        transac();
    }

    Connection con;

    void showTransac() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "Schoolsucks25!");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("Select * from transaction");
            while (rs.next()) {
                String places = rs.getString("Places");
                String Cash = rs.getString("Cash");
                String Change = rs.getString("Change");
                destination.setText(places);
                cashAmt.setText(Cash);
                changeAmt.setText(Change);
            }
            stat.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MT_06_PreviewAndPayment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MT_06_PreviewAndPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void transac() {
        DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "Schoolsucks25!");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("Select * from transaction");
            while (rs.next()) {
                int trans = rs.getInt("Transaction_ID");
                String Places = rs.getString("Places");
                String type = rs.getString("Bus_Type");
                double fare = rs.getDouble("Fare");
                double total = rs.getDouble("Total");
                double Cash = rs.getDouble("Cash");
                double Change = rs.getDouble("Change");
                System.out.println("Skibidi Papa");
                tableModel1.addRow(new Object[]{trans, Places, type, fare, total, Cash, Change});

            }
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(MT_07_Transaction_History.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showDate() {
        SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        time1.setText(a.format(d));
    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat a = new SimpleDateFormat("h:mm:ss a");
                Date d = new Date();
                time.setText(a.format(d));
            }

        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        destination = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cashAmt = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        changeAmt = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        totalAmt = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        busType = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(46, 79, 79));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(14, 131, 136));

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CONFIRM TRANSACTIONS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 40));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Places", "Bus Type", "Fare", "Total", "Cash", "Change"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 750, 530));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 750, 570));

        jPanel3.setBackground(new java.awt.Color(46, 79, 79));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(14, 131, 136));

        jLabel12.setFont(new java.awt.Font("Poppins SemiBold", 1, 28)); // NOI18N
        jLabel12.setText("RECEIPT");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel12)
                .addContainerGap(318, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        jLabel9.setFont(new java.awt.Font("Poppins SemiBold", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("From:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 25));

        jLabel13.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Quezon City");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 210, -1));

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("To:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, 20));

        destination.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        destination.setForeground(new java.awt.Color(255, 255, 255));
        destination.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(destination, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 210, 30));

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cash:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, 20));

        cashAmt.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        cashAmt.setForeground(new java.awt.Color(255, 255, 255));
        cashAmt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(cashAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 210, 30));

        jLabel8.setFont(new java.awt.Font("Poppins SemiBold", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Change:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, 30));

        changeAmt.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        changeAmt.setForeground(new java.awt.Color(255, 255, 255));
        changeAmt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(changeAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 210, 30));

        jLabel10.setFont(new java.awt.Font("Poppins SemiBold", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 20));

        jButton3.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton3.setText("Confirm");
        jButton3.setBorder(null);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 135, 70));

        jButton1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton1.setText("Reset");
        jButton1.setBorder(null);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 460, 135, 70));

        jButton2.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton2.setText("Back");
        jButton2.setBorder(null);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 135, 70));

        totalAmt.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        totalAmt.setForeground(new java.awt.Color(255, 255, 255));
        totalAmt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(totalAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 210, 30));

        jLabel14.setFont(new java.awt.Font("Poppins SemiBold", 1, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Bus Type:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, 30));

        busType.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        busType.setForeground(new java.awt.Color(255, 255, 255));
        busType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(busType, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 210, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 480, 570));

        time1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        time1.setForeground(new java.awt.Color(255, 255, 255));
        time1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 60, 160, 30));

        time.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(978, 60, 150, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/BG-MT.gif"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 108, 1366, 660));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/MT_01_SplashScreen  (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int response = JOptionPane.showConfirmDialog(this, "Confirm Payment?", "Prompt", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            try {
                DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "Schoolsucks25!");
                String Places = (String) destination.getText();
                String Bus_Type = (String) busType.getText();
                PreparedStatement ps = con.prepareStatement("INSERT INTO refundable VALUES(null, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, Places);
                ps.setString(2, Bus_Type);
                ps.setDouble(3, Double.parseDouble(model1.getValueAt(0, 0).toString()));
                ps.setDouble(4, Double.parseDouble(totalAmt.getText()));
                ps.setDouble(5, Double.parseDouble(cashAmt.getText()));
                ps.setDouble(6, Double.parseDouble(changeAmt.getText()));
                ps.execute();
                System.out.print("donE");
                ps.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MT_06_PreviewAndPayment.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MT_06_PreviewAndPayment.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
                int selectedRow = jTable1.getSelectedRow();
                String id = model1.getValueAt(selectedRow, 0).toString();
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "Schoolsucks25!");
                PreparedStatement pst = con.prepareStatement("DELETE FROM transaction WHERE Transaction_ID = '" + id + "'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Payment Confirmed!");
                pst.close();

            } catch (ClassNotFoundException | SQLException e) {
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        MT_05_Ticketing_Page ticketingpage = new MT_05_Ticketing_Page();
        ticketingpage.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();
        destination.setText(table.getValueAt(selectedRow, 1).toString());
        totalAmt.setText(table.getValueAt(selectedRow, 4).toString());
        cashAmt.setText(table.getValueAt(selectedRow, 5).toString());
        changeAmt.setText(table.getValueAt(selectedRow, 6).toString());
        busType.setText(table.getValueAt(selectedRow, 2).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MT_06_PreviewAndPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MT_06_PreviewAndPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MT_06_PreviewAndPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MT_06_PreviewAndPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MT_06_PreviewAndPayment().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel busType;
    public static javax.swing.JLabel cashAmt;
    public static javax.swing.JLabel changeAmt;
    public static javax.swing.JLabel destination;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public static javax.swing.JLabel time;
    public static javax.swing.JLabel time1;
    public static javax.swing.JLabel totalAmt;
    // End of variables declaration//GEN-END:variables
}
