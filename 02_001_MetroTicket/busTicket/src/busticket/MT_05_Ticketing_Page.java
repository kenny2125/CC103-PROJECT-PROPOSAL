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
public class MT_05_Ticketing_Page extends javax.swing.JFrame {

    /**
     * Creates new form MT_05_Ticketing_Page
     */
    Connection con;

    public MT_05_Ticketing_Page() {
        initComponents();
        showDate();
        showTime();
        placesConnection();
        createConnection();
    }

    void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "root");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MT_05_Ticketing_Page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MT_05_Ticketing_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void placesConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/placesDB", "root", "root");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("Select places from places");
            while (rs.next()) {
                String name = rs.getString("places");
                Destinations.addItem(name);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MT_05_Ticketing_Page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MT_05_Ticketing_Page.class.getName()).log(Level.SEVERE, null, ex);
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

    void transaction() {
        if (Destinations.getSelectedItem().equals("Baguio City") && BusClass.getSelectedItem().equals("Economy")) {
            baseFare.setText("550");
            System.out.println("WAAAAA");
        } else if (Destinations.getSelectedItem().equals("Baguio City") && BusClass.getSelectedItem().equals("Deluxe")) {
            baseFare.setText("700");
        } else if (Destinations.getSelectedItem().equals("Baguio City") && BusClass.getSelectedItem().equals("VIP")) {
            baseFare.setText("780");
        } else if (Destinations.getSelectedItem().equals("Batangas") && BusClass.getSelectedItem().equals("Economy")) {
            baseFare.setText("450");
        } else if (Destinations.getSelectedItem().equals("Batangas") && BusClass.getSelectedItem().equals("Deluxe")) {
            baseFare.setText("600");
        } else if (Destinations.getSelectedItem().equals("Batangas") && BusClass.getSelectedItem().equals("VIP")) {
            baseFare.setText("680");
        } else if (Destinations.getSelectedItem().equals("La Union") && BusClass.getSelectedItem().equals("Economy")) {
            baseFare.setText("600");
        } else if (Destinations.getSelectedItem().equals("La Union") && BusClass.getSelectedItem().equals("Deluxe")) {
            baseFare.setText("750");
        } else if (Destinations.getSelectedItem().equals("La Union") && BusClass.getSelectedItem().equals("VIP")) {
            baseFare.setText("830");
        } else if (Destinations.getSelectedItem().equals("Laguna") && BusClass.getSelectedItem().equals("Economy")) {
            baseFare.setText("380");
        } else if (Destinations.getSelectedItem().equals("Laguna") && BusClass.getSelectedItem().equals("Deluxe")) {
            baseFare.setText("530");
        } else if (Destinations.getSelectedItem().equals("Laguna") && BusClass.getSelectedItem().equals("VIP")) {
            baseFare.setText("610");
        } else if (Destinations.getSelectedItem().equals("Pampanga") && BusClass.getSelectedItem().equals("Economy")) {
            baseFare.setText("400");
        } else if (Destinations.getSelectedItem().equals("Pampanga") && BusClass.getSelectedItem().equals("Deluxe")) {
            baseFare.setText("530");
        } else if (Destinations.getSelectedItem().equals("Pampanga") && BusClass.getSelectedItem().equals("VIP")) {
            baseFare.setText("630");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        BusClass = new javax.swing.JComboBox<>();
        Destinations = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        totalAmt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        baseFare = new javax.swing.JLabel();
        passengerCt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cashAmt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        changeAmt = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        jLabel11 = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(46, 79, 79));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Class:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 154, 25));

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quezon City");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 154, 25));

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Destinations:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 154, 25));

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantity:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 154, 25));

        jLabel8.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Discount:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 154, 25));

        jLabel9.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fare:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 154, 25));

        BusClass.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        BusClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy", "Deluxe", "VIP" }));
        BusClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusClassActionPerformed(evt);
            }
        });
        jPanel2.add(BusClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 218, -1));

        Destinations.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        Destinations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinationsActionPerformed(evt);
            }
        });
        jPanel2.add(Destinations, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 218, -1));

        jCheckBox1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Discounted");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 218, -1));

        jLabel10.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 154, 25));

        totalAmt.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        totalAmt.setForeground(new java.awt.Color(255, 255, 255));
        totalAmt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(totalAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 220, 25));

        jButton1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton1.setText("Compute");
        jButton1.setBorder(null);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 550, 110, 30));

        jButton2.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton2.setText("Back to Main Menu");
        jButton2.setBorder(null);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 190, 30));

        jButton3.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton3.setText("Confirm");
        jButton3.setBorder(null);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 110, 30));

        baseFare.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        baseFare.setForeground(new java.awt.Color(255, 255, 255));
        baseFare.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(baseFare, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 220, 25));

        passengerCt.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        passengerCt.setText("0");
        jPanel2.add(passengerCt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 218, -1));

        jPanel4.setBackground(new java.awt.Color(14, 131, 136));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel2.setText("Transactions");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 9, 154, 25));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 40));

        jLabel15.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Departure:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 154, 25));

        jLabel16.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cash:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 154, 25));

        cashAmt.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jPanel2.add(cashAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 220, -1));

        jLabel17.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Change:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 154, 25));

        changeAmt.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jPanel2.add(changeAmt, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, 220, -1));

        jButton4.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton4.setText("Reset");
        jButton4.setBorder(null);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, 100, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 630, 610));

        jPanel3.setBackground(new java.awt.Color(46, 79, 79));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(14, 131, 136));

        jLabel12.setFont(new java.awt.Font("Poppins SemiBold", 1, 28)); // NOI18N
        jLabel12.setText("BUS TYPES AND PRICES");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(jLabel12)
                .addContainerGap(321, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        kGradientPanel1.setFocusable(false);
        kGradientPanel1.setkBorderRadius(20);
        kGradientPanel1.setOpaque(false);
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel1.setText("ECONOMY");
        kGradientPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 168, -1));

        jPanel3.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 30));

        kGradientPanel2.setFocusable(false);
        kGradientPanel2.setkBorderRadius(20);
        kGradientPanel2.setOpaque(false);
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel4.setText("DELUXE");
        kGradientPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 168, -1));

        jPanel3.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, -1));

        kGradientPanel3.setFocusable(false);
        kGradientPanel3.setkBorderRadius(20);
        kGradientPanel3.setOpaque(false);
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jLabel11.setText("VIP");
        kGradientPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 168, -1));

        jPanel3.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 600, 610));

        time1.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        time1.setForeground(new java.awt.Color(255, 255, 255));
        time1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 60, 100, 30));

        time.setFont(new java.awt.Font("Poppins SemiBold", 1, 12)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 60, 100, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/BG-MT.gif"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 108, 1366, 660));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/MT_01_SplashScreen  (1).png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        int response = JOptionPane.showConfirmDialog(this, "Place Transaction? ", "Place", JOptionPane.YES_NO_OPTION);
        if (JOptionPane.YES_OPTION == response) {
            try {
                String Places = (String) Destinations.getSelectedItem();
                String Bus_Type = (String) BusClass.getSelectedItem();
                PreparedStatement ps = con.prepareStatement("INSERT INTO transaction VALUES(null, ?, ?, ?, ?, ?, ?)");
                ps.setString(1, Places);
                ps.setString(2, Bus_Type);
                ps.setDouble(3, Double.parseDouble(baseFare.getText()));
                ps.setDouble(4, Double.parseDouble(totalAmt.getText()));
                ps.setDouble(5, Double.parseDouble(cashAmt.getText()));
                ps.setDouble(6, change);
                ps.execute();
                System.out.print("donE");
                ps.close();
            } catch (SQLException e) {
            }
            int response1 = JOptionPane.showConfirmDialog(this, "Proceed to Checkout? ", "HAHAHAHA", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == response1) {
                MT_06_PreviewAndPayment prev = new MT_06_PreviewAndPayment();
                dispose();
                prev.show();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    double total;
    double change;

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        MT_03_MainMenu_Staff mainMenu = new MT_03_MainMenu_Staff();
        mainMenu.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void BusClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusClassActionPerformed
        // TODO add your handling code here:
        transaction();
    }//GEN-LAST:event_BusClassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            transaction();
        total = Double.parseDouble(baseFare.getText()) * Double.parseDouble(passengerCt.getText());
        if (jCheckBox1.isSelected()) {
            total = (double) (total - (0.10 * total));
            totalAmt.setText(String.valueOf(total));
            if (Double.parseDouble(cashAmt.getText()) < Double.parseDouble(totalAmt.getText())) {
                JOptionPane.showMessageDialog(this, "Please input a proper amount");
                cashAmt.setText("0");
            } else {
                change = Double.parseDouble(cashAmt.getText()) - total;
                changeAmt.setText(String.valueOf(change));
            }
        } else {
            totalAmt.setText(String.valueOf(total));
            if (Double.parseDouble(cashAmt.getText()) < Double.parseDouble(totalAmt.getText())) {
                JOptionPane.showMessageDialog(this, "Please input a proper amount");
                cashAmt.setText("0");
            } else {
                change = Double.parseDouble(cashAmt.getText()) - total;
                changeAmt.setText(String.valueOf(change));
            }

        }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void DestinationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinationsActionPerformed
        // TODO add your handling code here:
        transaction();
    }//GEN-LAST:event_DestinationsActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
        MT_05_Ticketing_Page ticket = new MT_05_Ticketing_Page();
        ticket.show();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(MT_05_Ticketing_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MT_05_Ticketing_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MT_05_Ticketing_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MT_05_Ticketing_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MT_05_Ticketing_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BusClass;
    public static javax.swing.JComboBox<String> Destinations;
    public static javax.swing.JLabel baseFare;
    public static javax.swing.JTextField cashAmt;
    public static javax.swing.JTextField changeAmt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    public static javax.swing.JTextField passengerCt;
    public static javax.swing.JLabel time;
    public static javax.swing.JLabel time1;
    public static javax.swing.JLabel totalAmt;
    // End of variables declaration//GEN-END:variables
}
