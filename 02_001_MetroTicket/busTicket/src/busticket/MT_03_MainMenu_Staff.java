/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package busticket;

import static busticket.MT_02_0_LogIn_Staff.time;
import static busticket.MT_02_0_LogIn_Staff.time1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Alexander
 */
public class MT_03_MainMenu_Staff extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu_Staff
     */
    public MT_03_MainMenu_Staff() {
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

        logoutBtn = new javax.swing.JButton();
        busTicketingPageBtn = new javax.swing.JButton();
        transacHistBtn = new javax.swing.JButton();
        time = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutBtn.setBorder(null);
        logoutBtn.setContentAreaFilled(false);
        logoutBtn.setFocusable(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        getContentPane().add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(855, 174, 140, 52));

        busTicketingPageBtn.setBorder(null);
        busTicketingPageBtn.setContentAreaFilled(false);
        busTicketingPageBtn.setFocusable(false);
        busTicketingPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busTicketingPageBtnActionPerformed(evt);
            }
        });
        getContentPane().add(busTicketingPageBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 276, 390));

        transacHistBtn.setBorder(null);
        transacHistBtn.setContentAreaFilled(false);
        transacHistBtn.setFocusable(false);
        transacHistBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transacHistBtnActionPerformed(evt);
            }
        });
        getContentPane().add(transacHistBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 300, 390));

        time.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        time.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 150, 30));

        time1.setFont(new java.awt.Font("Poppins SemiBold", 1, 18)); // NOI18N
        time1.setForeground(new java.awt.Color(255, 255, 255));
        time1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 60, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/MT_03_MainMenu_Staff.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/busticket/PictureAssets/BG-MT.gif"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 108, 1366, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void busTicketingPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busTicketingPageBtnActionPerformed
        // TODO add your handling code here:
        MT_05_Ticketing_Page busTix = new MT_05_Ticketing_Page();
        dispose();
        busTix.show();
    }//GEN-LAST:event_busTicketingPageBtnActionPerformed

    private void transacHistBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transacHistBtnActionPerformed
        // TODO add your handling code here:
        MT_07_Transaction_History transacHist = new MT_07_Transaction_History();
        dispose();
        transacHist.show();
    }//GEN-LAST:event_transacHistBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        MT_02_0_LogIn_Staff login = new MT_02_0_LogIn_Staff();
        login.show();
    }//GEN-LAST:event_logoutBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MT_03_MainMenu_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MT_03_MainMenu_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MT_03_MainMenu_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MT_03_MainMenu_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MT_03_MainMenu_Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton busTicketingPageBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time1;
    private javax.swing.JButton transacHistBtn;
    // End of variables declaration//GEN-END:variables
}
