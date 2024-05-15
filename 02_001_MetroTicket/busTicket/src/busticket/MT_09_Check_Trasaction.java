/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package busticket;

import static busticket.MT_06_PreviewAndPayment.busType;
import static busticket.MT_06_PreviewAndPayment.cashAmt;
import static busticket.MT_06_PreviewAndPayment.changeAmt;
import static busticket.MT_06_PreviewAndPayment.destination;
import static busticket.MT_06_PreviewAndPayment.totalAmt;
import com.mysql.cj.PreparedQuery;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.mysql.cj.x.protobuf.MysqlxResultset;
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
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexander
 */
public class MT_09_Check_Trasaction extends javax.swing.JFrame {

    /**
     * Creates new form MT_09_Check_Trasaction
     */
    public MT_09_Check_Trasaction() {
        initComponents();
        showDate();
        showTime();
        showTransac();
    }

    Connection con;
    PreparedStatement pst;
    int x, y;

    private void showTransac() {
        DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "root");
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
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        searchTxtField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        time1 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(46, 79, 79));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(14, 131, 136));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ADMIN");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 7, 180, 57));

        jButton4.setText("A");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1165, 22, 30, 30));

        searchTxtField.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        searchTxtField.setText("Search");
        searchTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtFieldActionPerformed(evt);
            }
        });
        searchTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTxtFieldKeyTyped(evt);
            }
        });
        jPanel4.add(searchTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 15, 550, -1));

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Transaction History");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 7, 265, 57));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 70));

        jButton2.setBackground(new java.awt.Color(14, 131, 136));
        jButton2.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton2.setText("Back to Main Menu");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 400, 190, 43));

        jButton5.setBackground(new java.awt.Color(14, 131, 136));
        jButton5.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton5.setText("Delete");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 130, 190, 43));

        jButton3.setBackground(new java.awt.Color(14, 131, 136));
        jButton3.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton3.setText("Edit");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 220, 190, 43));

        jButton6.setBackground(new java.awt.Color(14, 131, 136));
        jButton6.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton6.setText("Print");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 310, 190, 43));

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
                false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 1040, 460));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1280, 610));

        time1.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        time1.setForeground(new java.awt.Color(255, 255, 255));
        time1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1007, 60, 100, 30));

        time.setFont(new java.awt.Font("Poppins SemiBold", 1, 12)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 60, 100, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/BG-MT.gif"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 108, 1366, 660));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/MT_01_SplashScreen  (1).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            String searchTemp = searchTxtField.getText() + "%";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "root");
            Statement pst = con.createStatement();
            ResultSet rs;
            rs = pst.executeQuery("SELECT * FROM transaction WHERE Places LIKE '" + searchTemp + "' OR Transaction_ID LIKE '" + searchTemp + "'");

            ResultSetMetaData data = rs.getMetaData();
            y = data.getColumnCount();
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();
                for (x = 1; x <= y; x++) {
                    columnData.add(rs.getInt("Transaction_ID"));
                    columnData.add(rs.getString("Places"));
                    columnData.add(rs.getString("Bus_Type"));
                    columnData.add(rs.getDouble("Fare"));
                    columnData.add(rs.getDouble("Total"));
                    columnData.add(rs.getDouble("Cash"));
                    columnData.add(rs.getDouble("Change"));

                }
                tableModel.addRow(columnData);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MT_07_Transaction_History.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void searchTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtFieldActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tableModel2 = (DefaultTableModel) jTable1.getModel();
        int SelectedRow = jTable1.getSelectedRow();
        String id = tableModel2.getValueAt(SelectedRow, 0).toString();

        int reply = JOptionPane.showConfirmDialog(this, "Confirm Refund?", "Refund", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "root");
                pst = con.prepareStatement("DELETE FROM transaction WHERE Transaction_ID = '" + id + "'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "DELETED");
                pst.close();

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(MT_07_Transaction_History.class.getName()).log(Level.SEVERE, null, ex);
            }

            int reply2 = JOptionPane.showConfirmDialog(this, "Do another refund?", "Refund", JOptionPane.YES_NO_OPTION);
            if (reply2 == JOptionPane.YES_OPTION) {
                dispose();
                MT_07_Transaction_History transac = new MT_07_Transaction_History();
                transac.show();
            } else {
                dispose();
                MT_03_MainMenu_Staff mainmenu = new MT_03_MainMenu_Staff();
                mainmenu.show();
            }
        } else {
            dispose();
            MT_07_Transaction_History transac = new MT_07_Transaction_History();
            transac.show();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MT_04_MainMenu_Admin menuAdmin = new MT_04_MainMenu_Admin();
        dispose();
        menuAdmin.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table2 = (DefaultTableModel) jTable1.getModel();
        Statement st;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "root");
            st = con.createStatement();
            for (int i = 0; i < table2.getRowCount(); i++) {

                int id = Integer.valueOf(table2.getValueAt(i, 0).toString());
                String Places = table2.getValueAt(i, 1).toString();
                String Bus_Type = table2.getValueAt(i, 2).toString();
                double fare = Double.valueOf(table2.getValueAt(i, 3).toString());
                double total = Double.valueOf(table2.getValueAt(i, 4).toString());
                double cash = Double.valueOf(table2.getValueAt(i, 5).toString());
                double stick = Double.valueOf(table2.getValueAt(i, 6).toString());

                String updt = "UPDATE transaction SET Places = '" + Places + "' , Bus_Type= '" + Bus_Type + "', Fare= '" + fare + "', Total= '" + total + "', Cash= '" + cash + "' WHERE Transaction_ID = '" + id + "'";

                st.addBatch(updt);

            }
            st.executeBatch();
            st.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MT_09_Check_Trasaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "root");
            DefaultTableModel table4 = (DefaultTableModel) jTable1.getModel();
            int selectedRow3 = jTable1.getSelectedRow();
            String dest = table4.getValueAt(selectedRow3, 1).toString();
            String bus = table4.getValueAt(selectedRow3, 2).toString();
            int trID = Integer.parseInt(table4.getValueAt(selectedRow3, 0).toString());
            Double fare = Double.valueOf(table4.getValueAt(selectedRow3, 3).toString());
            Double total = Double.valueOf(table4.getValueAt(selectedRow3, 4).toString());
            Double cash = Double.valueOf(table4.getValueAt(selectedRow3, 5).toString());
            Double change = Double.valueOf(table4.getValueAt(selectedRow3, 6).toString());

            JLabel lb1 = new JLabel();
            lb1.setText("<html>Transaction ID" + trID + "<br>" + "Transaction ID" + dest + "<br>" + "Transaction ID" + bus + "<br>" + "Transaction ID" + fare + "<br>" + "Transaction ID" + total + "<br>" + "Transaction ID" + cash + "<br>" +"Transaction ID" + change + "</html>" );
            JOptionPane.showMessageDialog(this, lb1);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MT_09_Check_Trasaction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MT_09_Check_Trasaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void searchTxtFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtFieldKeyTyped
        // TODO add your handling code here:
        try {
            String searchTemp = searchTxtField.getText() + "%";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "root");
            Statement pst = con.createStatement();
            ResultSet rs;
            rs = pst.executeQuery("SELECT * FROM transaction WHERE Places LIKE '" + searchTemp + "' OR Transaction_ID LIKE '" + searchTemp + "'");

            ResultSetMetaData data = rs.getMetaData();
            y = data.getColumnCount();
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();
                for (x = 1; x <= y; x++) {
                    columnData.add(rs.getInt("Transaction_ID"));
                    columnData.add(rs.getString("Places"));
                    columnData.add(rs.getString("Bus_Type"));
                    columnData.add(rs.getDouble("Fare"));
                    columnData.add(rs.getDouble("Total"));
                    columnData.add(rs.getDouble("Cash"));
                    columnData.add(rs.getDouble("Change"));

                }
                tableModel.addRow(columnData);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MT_07_Transaction_History.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchTxtFieldKeyTyped

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
            java.util.logging.Logger.getLogger(MT_09_Check_Trasaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MT_09_Check_Trasaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MT_09_Check_Trasaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MT_09_Check_Trasaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MT_09_Check_Trasaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchTxtField;
    public static javax.swing.JLabel time;
    public static javax.swing.JLabel time1;
    // End of variables declaration//GEN-END:variables
}
