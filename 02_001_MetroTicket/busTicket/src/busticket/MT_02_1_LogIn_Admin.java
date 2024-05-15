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
import javax.swing.Timer;

/**
 *
 * @author Alexander
 */
public class MT_02_1_LogIn_Admin extends javax.swing.JFrame {

    /**
     * Creates new form MT_02_1_LogIn_Admin
     */
    public MT_02_1_LogIn_Admin() {
        initComponents();
        showDate();
        showTime();
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

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        logInBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setkBorderRadius(100);
        kGradientPanel1.setkEndColor(new java.awt.Color(14, 131, 136));
        kGradientPanel1.setkStartColor(new java.awt.Color(14, 131, 136));
        kGradientPanel1.setName(""); // NOI18N
        kGradientPanel1.setOpaque(false);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkBorderRadius(100);
        kGradientPanel2.setkEndColor(new java.awt.Color(46, 79, 79));
        kGradientPanel2.setkStartColor(new java.awt.Color(46, 79, 79));
        kGradientPanel2.setOpaque(false);
        kGradientPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.WHITE);
        jLabel1.setText("Password");
        kGradientPanel2.add(jLabel1);
        jLabel1.setBounds(470, 190, 170, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon("D:\\Metro Ticket\\busTicket\\src\\busticket\\PictureAssets\\Bus Logo.png")); // NOI18N
        jLabel8.setText("jLabel8");
        jLabel8.setPreferredSize(new java.awt.Dimension(160, 160));
        kGradientPanel2.add(jLabel8);
        jLabel8.setBounds(50, 60, 160, 160);

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel2.setText("Username");
        jLabel2.setForeground(java.awt.Color.WHITE);
        kGradientPanel2.add(jLabel2);
        jLabel2.setBounds(470, 80, 170, 30);

        username.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        kGradientPanel2.add(username);
        username.setBounds(470, 110, 340, 40);

        password.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        kGradientPanel2.add(password);
        password.setBounds(470, 220, 340, 40);

        logInBtn.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        logInBtn.setText("Log In");
        logInBtn.setBorder(null);
        logInBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logInBtn.setFocusable(false);
        logInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInBtnActionPerformed(evt);
            }
        });
        kGradientPanel2.add(logInBtn);
        logInBtn.setBounds(470, 290, 160, 40);

        exitBtn.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.setBorder(null);
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitBtn.setFocusable(false);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        kGradientPanel2.add(exitBtn);
        exitBtn.setBounds(650, 290, 160, 40);

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Log In - Admin");
        kGradientPanel2.add(jLabel5);
        jLabel5.setBounds(50, 210, 290, 60);

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Login using your existing account");
        kGradientPanel2.add(jLabel6);
        jLabel6.setBounds(50, 270, 340, 30);

        jLabel4.setFont(new java.awt.Font("Poppins", 3, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setForeground(java.awt.Color.WHITE);
        jLabel4.setText("Login as Staff");
        jLabel4.setToolTipText("");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        kGradientPanel2.add(jLabel4);
        jLabel4.setBounds(570, 340, 150, 28);

        kGradientPanel1.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 910, 390));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 940, 420));

        time.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time.setText("Date");
        getContentPane().add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(973, 60, 170, 30));

        time1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        time1.setForeground(new java.awt.Color(255, 255, 255));
        time1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        time1.setText("Time");
        getContentPane().add(time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1146, 60, 150, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/BG-MT.gif"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 108, 1366, 660));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/MT_01_SplashScreen .png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInBtnActionPerformed
        try {
            //        try {
            //            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //            String dburl = "jdbc:sqlserver://localhost\\SQL2022:1434;databaseName=testDB;username=sa;password=sa123456;TrustServerCertificate=true";
            //            Connection conn = DriverManager.getConnection(dburl);
            //            Statement stat = conn.createStatement();
            //            String query = "Select * from testTable where username=? and password =? ";
            //            PreparedStatement pst = conn.prepareStatement(query);
            //            pst.setString(1, username.getText());
            //            pst.setString(2, password.getText());
            //            ResultSet rs = pst.executeQuery();
            //
            //            if (rs.next()) {
            //                JOptionPane.showMessageDialog(null, "Username and Password Matched");
            //                dispose();
            //                MT_03_MainMenu_Staff staffMenu = new MT_03_MainMenu_Staff();
            //                staffMenu.show();
            //            }
            //            else {
            //                JOptionPane.showConfirmDialog(null, "Fuckin Wrong");
            //                username.setText("");
            //                password.setText("");
            //            }
            //            conn.close();
            //
            //        } catch (ClassNotFoundException ex) {
            //            Logger.getLogger(BusTicket.class.getName()).log(Level.SEVERE, null, ex);
            //        } catch (SQLException ex) {
            //            Logger.getLogger(MT_02_LogIn.class.getName()).log(Level.SEVERE, null, ex);
            //        }

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/accountdb", "root", "Schoolsucks25!");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("Select * from adminacc");
            PreparedStatement pst = con.prepareStatement("Select * from adminacc where username=? AND password=?");
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Username and Password Matched");
                dispose();
                MT_04_MainMenu_Admin adminMenu = new MT_04_MainMenu_Admin();
                adminMenu.show();
            } else {
                JOptionPane.showConfirmDialog(null, "Fuckin Wrong");
                username.setText("");
                password.setText("");
            }
            con.close();

            System.out.print("Database Connected");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MT_02_0_LogIn_Staff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MT_02_0_LogIn_Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logInBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_exitBtnActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
        MT_02_0_LogIn_Staff login = new MT_02_0_LogIn_Staff();
        login.show();     
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(MT_02_1_LogIn_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MT_02_1_LogIn_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MT_02_1_LogIn_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MT_02_1_LogIn_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MT_02_1_LogIn_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private javax.swing.JButton logInBtn;
    public static javax.swing.JTextField password;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time1;
    public static javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
