/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MetroTicket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;


/**
 *
 * @author GameWorks
 */
public class MT_01_SplashScreen extends javax.swing.JFrame {

   private static final String username = "root";
   private static final String password = "Schoolsucks25!";
   private static final String dataConn = "jdbc:mysql://localhost:3306/metroticket_connector";
   
   Connection sqlConn = null;
   PreparedStatement pst = null;
   ResultSet rs =null;
   int q, i , id, deleteItem;
   
   
   
    public MT_01_SplashScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    //==========================Function=====================================
    
    public void upDateDB(){
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("select * from metroticket_connector");
            
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            
            q = stData.getColumnCount();
            
            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            RecordTable.setRowCount(0);
            
            while (rs.next()) {
                Vector columnData = new Vector ();
                
                for ( i = 1; i <= q; i++){
                    columnData.add(rs.getString("id"));
                    columnData.add(rs.getString("TransactionNumber"));
                    columnData.add(rs.getString("Departure"));
                    columnData.add(rs.getString("Destination"));
                    columnData.add(rs.getString("Class"));
                    columnData.add(rs.getString("Quantity"));
                    columnData.add(rs.getString("Price"));
                    columnData.add(rs.getString("Discount"));
                    columnData.add(rs.getString("Total"));
                }
                RecordTable.addRow(columnData);
                    
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //==========================End Function=================================
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MT_01_jtx_Discount = new javax.swing.JTextField();
        MT_01_jtx_Destination = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        MT_01_jtx_TransactionNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        MT_01_jtx_Class = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        MT_01_jtx_Price = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        MT_01_jtx_Quantity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        MT_01_jtx_Total = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        MT_01_jbtn_Exit = new javax.swing.JButton();
        MT_01_jbtn_Add = new javax.swing.JButton();
        MT_01_jbtn_Update = new javax.swing.JButton();
        MT_01_jbtn_Print = new javax.swing.JButton();
        MT_01_jbtn_Reset = new javax.swing.JButton();
        MT_01_jbtn_Delete = new javax.swing.JButton();
        MT_01_jtx_Departure = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MetroTicket");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 400, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 51), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Discount");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 400, 60));

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Transaction Number");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 520, 80));

        MT_01_jtx_Discount.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jPanel2.add(MT_01_jtx_Discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, 480, 60));

        MT_01_jtx_Destination.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        MT_01_jtx_Destination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MT_01_jtx_DestinationActionPerformed(evt);
            }
        });
        jPanel2.add(MT_01_jtx_Destination, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 480, 60));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Destination");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 400, 60));

        MT_01_jtx_TransactionNumber.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        MT_01_jtx_TransactionNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MT_01_jtx_TransactionNumberActionPerformed(evt);
            }
        });
        jPanel2.add(MT_01_jtx_TransactionNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 480, 60));

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Departure");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 400, 60));

        MT_01_jtx_Class.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jPanel2.add(MT_01_jtx_Class, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 480, 60));

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Class");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 400, 60));

        MT_01_jtx_Price.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jPanel2.add(MT_01_jtx_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 410, 480, 60));

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Price");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 400, 60));

        MT_01_jtx_Quantity.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        MT_01_jtx_Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MT_01_jtx_QuantityActionPerformed(evt);
            }
        });
        jPanel2.add(MT_01_jtx_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 480, 60));

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Quantity");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 400, 60));

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Total");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 400, 60));

        MT_01_jtx_Total.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        jPanel2.add(MT_01_jtx_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 550, 480, 60));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction Number", "Departure", "Destination", "Class", "Quantity", "Price", "Discount", "Total"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 1010, 300));

        MT_01_jbtn_Exit.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        MT_01_jbtn_Exit.setText("Exit");
        MT_01_jbtn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MT_01_jbtn_ExitActionPerformed(evt);
            }
        });
        jPanel2.add(MT_01_jbtn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 520, 410, 70));

        MT_01_jbtn_Add.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        MT_01_jbtn_Add.setText("Add");
        MT_01_jbtn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MT_01_jbtn_AddActionPerformed(evt);
            }
        });
        jPanel2.add(MT_01_jbtn_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 120, 410, 70));

        MT_01_jbtn_Update.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        MT_01_jbtn_Update.setText("Update");
        MT_01_jbtn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MT_01_jbtn_UpdateActionPerformed(evt);
            }
        });
        jPanel2.add(MT_01_jbtn_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 200, 410, 70));

        MT_01_jbtn_Print.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        MT_01_jbtn_Print.setText("Print");
        MT_01_jbtn_Print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MT_01_jbtn_PrintActionPerformed(evt);
            }
        });
        jPanel2.add(MT_01_jbtn_Print, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 280, 410, 70));

        MT_01_jbtn_Reset.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        MT_01_jbtn_Reset.setText("Reset");
        MT_01_jbtn_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MT_01_jbtn_ResetActionPerformed(evt);
            }
        });
        jPanel2.add(MT_01_jbtn_Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 360, 410, 70));

        MT_01_jbtn_Delete.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        MT_01_jbtn_Delete.setText("Delete");
        MT_01_jbtn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MT_01_jbtn_DeleteActionPerformed(evt);
            }
        });
        jPanel2.add(MT_01_jbtn_Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 440, 410, 70));

        MT_01_jtx_Departure.setFont(new java.awt.Font("Poppins", 0, 48)); // NOI18N
        MT_01_jtx_Departure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MT_01_jtx_DepartureActionPerformed(evt);
            }
        });
        jPanel2.add(MT_01_jtx_Departure, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 480, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1920, 960));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MT_01_jbtn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MT_01_jbtn_AddActionPerformed
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("insert into metroticket_connector(TransactionNumber,Departure,Destination,Class,Quantity,Price,Discount,Total)value(?,?,?,?,?,?,?,?)");
            
            pst.setString(1, MT_01_jtx_TransactionNumber.getText());
            pst.setString(2, MT_01_jtx_Departure.getText());
            pst.setString(3, MT_01_jtx_Destination.getText());
            pst.setString(4, MT_01_jtx_Class.getText());
            pst.setString(5, MT_01_jtx_Quantity.getText());
            pst.setString(6, MT_01_jtx_Price.getText());
            pst.setString(7, MT_01_jtx_Discount.getText());
            pst.setString(8, MT_01_jtx_Total.getText());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Transaction Added");
            upDateDB();
        }catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(MT_01_SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE,null, ex);
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(MT_01_SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE,null, ex);
        }
    }//GEN-LAST:event_MT_01_jbtn_AddActionPerformed

    private void MT_01_jbtn_PrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MT_01_jbtn_PrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MT_01_jbtn_PrintActionPerformed

    private void MT_01_jtx_TransactionNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MT_01_jtx_TransactionNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MT_01_jtx_TransactionNumberActionPerformed

    private void MT_01_jtx_DestinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MT_01_jtx_DestinationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MT_01_jtx_DestinationActionPerformed

    private void MT_01_jtx_QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MT_01_jtx_QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MT_01_jtx_QuantityActionPerformed
private JFrame frame;
    private void MT_01_jbtn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MT_01_jbtn_ExitActionPerformed
        
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame,"Do you want to exit?", "MetroTicket", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_MT_01_jbtn_ExitActionPerformed

    private void MT_01_jbtn_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MT_01_jbtn_ResetActionPerformed
        MT_01_jtx_TransactionNumber.setText("");
        MT_01_jtx_Class.setText("");
        MT_01_jtx_TransactionNumber.setText("");
        MT_01_jtx_Destination.setText("");
        MT_01_jtx_Discount.setText("");
        MT_01_jtx_Price.setText("");
        MT_01_jtx_Quantity.setText("");
        MT_01_jtx_Total.setText("");
        
            
    }//GEN-LAST:event_MT_01_jbtn_ResetActionPerformed

    private void MT_01_jtx_DepartureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MT_01_jtx_DepartureActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MT_01_jtx_DepartureActionPerformed

    private void MT_01_jbtn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MT_01_jbtn_UpdateActionPerformed
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataConn,username,password);
            pst = sqlConn.prepareStatement("update metroticket_connector set TransactionNumber=? , Departure=?, Destination=?, Class=?, Quantity=?, Price=?, Discount=?, Total=? where id=?");
            
            pst.setString(1, MT_01_jtx_TransactionNumber.getText());
            pst.setString(2, MT_01_jtx_Departure.getText());
            pst.setString(3, MT_01_jtx_Destination.getText());
            pst.setString(4, MT_01_jtx_Class.getText());
            pst.setString(5, MT_01_jtx_Quantity.getText());
            pst.setString(6, MT_01_jtx_Price.getText());
            pst.setString(7, MT_01_jtx_Discount.getText());
            pst.setString(8, MT_01_jtx_Total.getText());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Transaction Updated");
            upDateDB();
        }catch (ClassNotFoundException ex){
            java.util.logging.Logger.getLogger(MT_01_SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE,null, ex);
        }catch (SQLException ex){
            java.util.logging.Logger.getLogger(MT_01_SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE,null, ex);
        }
    }//GEN-LAST:event_MT_01_jbtn_UpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
            int SelectedRows = jTable1.getSelectedRow();
            
            MT_01_jtx_TransactionNumber.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
            MT_01_jtx_Departure.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
            MT_01_jtx_Destination.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
            MT_01_jtx_Class.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
            MT_01_jtx_Quantity.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
            MT_01_jtx_Price.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
            MT_01_jtx_Discount.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
            MT_01_jtx_Total.setText(RecordTable.getValueAt(SelectedRows, 8).toString());
            
            
    }//GEN-LAST:event_jTable1MouseClicked

    private void MT_01_jbtn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MT_01_jbtn_DeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MT_01_jbtn_DeleteActionPerformed

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
            java.util.logging.Logger.getLogger(MT_01_SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MT_01_SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MT_01_SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MT_01_SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MT_01_SplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MT_01_jbtn_Add;
    private javax.swing.JButton MT_01_jbtn_Delete;
    private javax.swing.JButton MT_01_jbtn_Exit;
    private javax.swing.JButton MT_01_jbtn_Print;
    private javax.swing.JButton MT_01_jbtn_Reset;
    private javax.swing.JButton MT_01_jbtn_Update;
    private javax.swing.JTextField MT_01_jtx_Class;
    private javax.swing.JTextField MT_01_jtx_Departure;
    private javax.swing.JTextField MT_01_jtx_Destination;
    private javax.swing.JTextField MT_01_jtx_Discount;
    private javax.swing.JTextField MT_01_jtx_Price;
    private javax.swing.JTextField MT_01_jtx_Quantity;
    private javax.swing.JTextField MT_01_jtx_Total;
    private javax.swing.JTextField MT_01_jtx_TransactionNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
