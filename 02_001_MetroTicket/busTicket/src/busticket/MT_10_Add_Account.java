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
public class MT_10_Add_Account extends javax.swing.JFrame {

    /**
     * Creates new form MT_10_Add_Account
     */
    public MT_10_Add_Account() {
        initComponents();
        showDate();
        showTime();
        showTable();
    }

    Connection con;
    int x, y;

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

    private void showTable() {
        DefaultTableModel tableModel1 = (DefaultTableModel) jTable1.getModel();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountdb", "root", "Schoolsucks25!");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("Select * from staffacc");
            while (rs.next()) {
                int id = rs.getInt("Staff_ID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                tableModel1.addRow(new Object[]{id, username, password});

            }
            stat.close();
        } catch (SQLException ex) {
            Logger.getLogger(MT_07_Transaction_History.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        searchTxtField = new javax.swing.JTextField();
        time1 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(46, 79, 79));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(14, 131, 136));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 70));

        jTable1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "ID", "Username", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 880, 460));

        jButton2.setBackground(new java.awt.Color(14, 131, 136));
        jButton2.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton2.setText("Main Menu");
        jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 440, 170, 70));

        jButton5.setBackground(new java.awt.Color(14, 131, 136));
        jButton5.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton5.setText("Add Accounts");
        jButton5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 170, 170, 70));

        jButton3.setBackground(new java.awt.Color(14, 131, 136));
        jButton3.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton3.setText("Edit Accounts");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 260, 170, 70));

        jButton6.setBackground(new java.awt.Color(14, 131, 136));
        jButton6.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton6.setText("Delete Accounts");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 350, 170, 70));

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ACCOUNT MANAGEMENT");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 320, 57));

        jButton4.setText("A");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 74, 30, 30));

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
        jPanel2.add(searchTxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 550, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1280, 600));

        time1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        time1.setForeground(new java.awt.Color(255, 255, 255));
        time1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 60, 140, 30));

        time.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 150, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/MT_10_Add_Account.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void searchTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtFieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        MT_04_MainMenu_Admin menuAdmin = new MT_04_MainMenu_Admin();
        dispose();
        menuAdmin.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table2 = (DefaultTableModel) jTable1.getModel();
        Statement st;
        int response = JOptionPane.showConfirmDialog(this, "Add new Staff Account?", "Confirmation", JOptionPane.INFORMATION_MESSAGE, JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            if (table2.getValueAt(1, 0) != null && table2.getValueAt(1, 1) != null && table2.getValueAt(1, 2) != null) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountdb", "root", "Schoolsucks25!");
                    st = con.createStatement();
                    for (int i = 0; i < table2.getRowCount(); i++) {

                        int id = Integer.parseInt(table2.getValueAt(i, 0).toString());
                        String username = table2.getValueAt(i, 1).toString();
                        String password = table2.getValueAt(i, 2).toString();

                        String updt = "INSERT INTO staffacc (Staff_ID, username, password) VALUES ('" + id + "', '" + username + "', '" + password + "') ";

                        st.addBatch(updt);

                    }
                    st.executeBatch();
                    st.close();

                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(MT_09_Check_Trasaction.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Account Succesfully Added", "Prompt", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                MT_10_Add_Account acc = new MT_10_Add_Account();
                acc.show();
            }
        } else {
            dispose();
            MT_04_MainMenu_Admin admin = new MT_04_MainMenu_Admin();
            admin.show();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table2 = (DefaultTableModel) jTable1.getModel();
        Statement st;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountdb", "root", "Schoolsucks25!");
            st = con.createStatement();
            for (int i = 1; i < table2.getRowCount(); i++) {

                int id = Integer.valueOf(table2.getValueAt(i, 0).toString());
                String username = table2.getValueAt(i, 1).toString();
                String password = table2.getValueAt(i, 2).toString();

                String updt = "UPDATE staffacc SET username='" + username + "', password='" + password + "' WHERE Staff_ID='" + id + "'";

                st.addBatch(updt);

            }
            st.executeBatch();
            st.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MT_09_Check_Trasaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tableModel2 = (DefaultTableModel) jTable1.getModel();
        int SelectedRow = jTable1.getSelectedRow();
        String id = tableModel2.getValueAt(SelectedRow, 0).toString();

        int reply = JOptionPane.showConfirmDialog(this, "Confirm Delete Account?", "Account", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountdb", "root", "Schoolsucks25!");
                PreparedStatement pst = con.prepareStatement("DELETE FROM staffacc WHERE Staff_ID = '" + id + "'");
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "DELETED");
                pst.close();

            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(MT_07_Transaction_History.class.getName()).log(Level.SEVERE, null, ex);
            }

            int reply2 = JOptionPane.showConfirmDialog(this, "Delete Another Account?", "Delete", JOptionPane.YES_NO_OPTION);
            if (reply2 == JOptionPane.YES_OPTION) {
                dispose();
                MT_10_Add_Account acc = new MT_10_Add_Account();
                acc.show();
            } else {
                dispose();
                MT_04_MainMenu_Admin mainmenu = new MT_04_MainMenu_Admin();
                mainmenu.show();
            }
        } else {
            dispose();
            MT_04_MainMenu_Admin mainmenu = new MT_04_MainMenu_Admin();
            mainmenu.show();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void searchTxtFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtFieldKeyTyped
        // TODO add your handling code here:
        try {
            String searchTemp = searchTxtField.getText() + "%";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountdb", "root", "Schoolsucks25!");
            Statement pst = con.createStatement();
            ResultSet rs;
            rs = pst.executeQuery("SELECT * FROM staffacc WHERE username LIKE '" + searchTemp + "' OR Staff_ID LIKE '" + searchTemp + "'");

            ResultSetMetaData data = rs.getMetaData();
            y = data.getColumnCount();
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0);

            while (rs.next()) {
                Vector columnData = new Vector();
                for (x = 1; x <= y; x++) {

                    columnData.add(rs.getString("Staff_ID"));
                    columnData.add(rs.getString("username"));
                    columnData.add(rs.getString("password"));

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
            java.util.logging.Logger.getLogger(MT_10_Add_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MT_10_Add_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MT_10_Add_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MT_10_Add_Account.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MT_10_Add_Account().setVisible(true);
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField searchTxtField;
    public static javax.swing.JLabel time;
    public static javax.swing.JLabel time1;
    // End of variables declaration//GEN-END:variables
}
