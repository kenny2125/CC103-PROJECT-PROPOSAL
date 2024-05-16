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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transactions", "root", "Schoolsucks25!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MT_05_Ticketing_Page.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MT_05_Ticketing_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void placesConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/placesdb", "root", "Schoolsucks25!");
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

    void refresh() {
        try {
            transaction();
            total = Double.parseDouble(baseFare.getText()) * Double.parseDouble(passengerCt.getText());
            if (jCheckBox1.isSelected()) {
                total = (double) (total - (0.10 * total));
                totalAmt.setText(String.valueOf(total));
                if (Double.parseDouble(cashAmt.getText()) < Double.parseDouble(totalAmt.getText())) {
                    JOptionPane.showMessageDialog(this, "Please input a proper amount");
                    cashAmt.setText("0");
                    cashAmt.requestFocus();
                    changeAmt.setText("0");
                } else {
                    change = Double.parseDouble(cashAmt.getText()) - total;
                    changeAmt.setText(String.valueOf(change));
                }
            } else {
                totalAmt.setText(String.valueOf(total));
                if (Double.parseDouble(cashAmt.getText()) < Double.parseDouble(totalAmt.getText())) {
                    JOptionPane.showMessageDialog(this, "Please input a proper amount");
                    cashAmt.setText("0");
                    cashAmt.requestFocus();
                    changeAmt.setText("0");
                } else {
                    change = Double.parseDouble(cashAmt.getText()) - total;
                    changeAmt.setText(String.valueOf(change));
                }

            }
        } catch (Exception e) {
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
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        baseFare = new javax.swing.JLabel();
        passengerCt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cashAmt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        changeAmt = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        time1 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(46, 79, 79));
        jPanel2.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Class:");

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Quezon City");

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Destinations:");

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Quantity:");

        jLabel8.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Discount:");

        jLabel9.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fare:");

        BusClass.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        BusClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy", "Deluxe", "VIP" }));
        BusClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BusClassMouseClicked(evt);
            }
        });
        BusClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusClassActionPerformed(evt);
            }
        });

        Destinations.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        Destinations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DestinationsMouseClicked(evt);
            }
        });
        Destinations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DestinationsActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(47, 80, 80));
        jCheckBox1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Discounted");
        jCheckBox1.setOpaque(true);
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseExited(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total:");

        totalAmt.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        totalAmt.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton2.setBorder(null);
        jButton2.setFocusable(false);
        jButton2.setLabel("Main Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton3.setText("Confirm");
        jButton3.setBorder(null);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        baseFare.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        baseFare.setForeground(new java.awt.Color(255, 255, 255));

        passengerCt.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        passengerCt.setText("0");
        passengerCt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passengerCtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                passengerCtMouseExited(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(14, 131, 136));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Departure:");

        jLabel16.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cash:");

        cashAmt.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        cashAmt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cashAmtFocusLost(evt);
            }
        });
        cashAmt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cashAmtMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cashAmtMouseExited(evt);
            }
        });
        cashAmt.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                cashAmtInputMethodTextChanged(evt);
            }
        });
        cashAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashAmtActionPerformed(evt);
            }
        });
        cashAmt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cashAmtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cashAmtKeyTyped(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Poppins SemiBold", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Change:");

        changeAmt.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        changeAmt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeAmtMouseClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        jButton4.setText("Reset");
        jButton4.setBorder(null);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(changeAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(passengerCt, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(cashAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(baseFare, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(66, 66, 66)
                                    .addComponent(BusClass, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                        .addComponent(Destinations, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3, jButton4});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Destinations, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BusClass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(baseFare, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passengerCt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cashAmt)
                                .addGap(3, 3, 3)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(changeAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(90, 90, 90))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 750, 610));

        time1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        time1.setForeground(new java.awt.Color(255, 255, 255));
        time1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 60, 140, 30));

        time.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 150, 30));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/MT_05_Ticketing_Page.png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DestinationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DestinationsActionPerformed
        // TODO add your handling code here:
        transaction();
    }//GEN-LAST:event_DestinationsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        MT_03_MainMenu_Staff mainMenu = new MT_03_MainMenu_Staff();
        mainMenu.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
        MT_05_Ticketing_Page ticket = new MT_05_Ticketing_Page();
        ticket.show();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            int response1 = JOptionPane.showConfirmDialog(this, "Successful!!" + "\n" + "Proceed to Checkout? ", "Successful!!", JOptionPane.YES_NO_OPTION);
            if (JOptionPane.YES_OPTION == response1) {
                MT_06_PreviewAndPayment prev = new MT_06_PreviewAndPayment();
                dispose();
                prev.show();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void BusClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusClassActionPerformed
        // TODO add your handling code here:
        transaction();
    }//GEN-LAST:event_BusClassActionPerformed

    private void DestinationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DestinationsMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_DestinationsMouseClicked

    private void BusClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BusClassMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_BusClassMouseClicked

    private void passengerCtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passengerCtMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_passengerCtMouseClicked

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void cashAmtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashAmtMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cashAmtMouseClicked

    private void changeAmtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeAmtMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_changeAmtMouseClicked

    private void passengerCtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passengerCtMouseExited
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_passengerCtMouseExited

    private void cashAmtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cashAmtMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cashAmtMouseExited

    private void jCheckBox1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseExited
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jCheckBox1MouseExited

    private void cashAmtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashAmtKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_cashAmtKeyTyped

    private void cashAmtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashAmtKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cashAmtKeyPressed

    private void cashAmtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cashAmtFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cashAmtFocusLost

    private void cashAmtInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_cashAmtInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cashAmtInputMethodTextChanged

    private void cashAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashAmtActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_cashAmtActionPerformed

    double total;
    double change;

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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JTextField passengerCt;
    public static javax.swing.JLabel time;
    public static javax.swing.JLabel time1;
    public static javax.swing.JLabel totalAmt;
    // End of variables declaration//GEN-END:variables
}
