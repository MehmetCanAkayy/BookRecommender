/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.User;

import javaapplication1.User.UserPanel;
import com.adobe.acrobat.Viewer;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.getString;
import javax.swing.table.DefaultTableModel;
import javaapplication1.DosyaIslem.Veritabani;
import javaapplication1.MachineLearning.AraKatman;
import javax.annotation.Resource;
import javax.security.auth.login.Configuration;
import javax.swing.table.TableColumn;

/**
 *
 * @author Lenovo
 */
public class KullanıcıAnaSayfa extends javax.swing.JFrame {

    Connection connect = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String kulid;
    String oyu;
    public Viewer viewer;
    PDFDocument pdf;
    String kulid1;

    /**
     * Creates new form Ana_Sayfa
     */
    public KullanıcıAnaSayfa() {
        initComponents();
        connect = Veritabani.Baglanti();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Kitap Oku");
        jButton1.setActionCommand("kitap_oku");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Yüksek Puanlı Kitaplar");
        jButton2.setActionCommand("yuksek_puanlılar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("En Çok Oylanan Kitaplar");
        jButton3.setActionCommand("cok_oylananlar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("En Yeni Kitaplar");
        jButton4.setActionCommand("yeniler");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jButton5.setText("Öneri Al");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton5))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {

            DefaultTableModel liste = new DefaultTableModel();
            //myList = new JList;

            String sorgu = "SELECT * FROM `books`";
            pst = connect.prepareStatement(sorgu);
            rs = pst.executeQuery();
            int colcount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= colcount; i++) {
                liste.addColumn(rs.getMetaData().getColumnName(i));
            }
            while (rs.next()) {
                Object[] row = new Object[colcount];
                for (int i = 1; i <= colcount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                liste.addRow(row);
            }
            jTable2.setModel(liste);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {//en çok oy alan
            DefaultTableModel tm = new DefaultTableModel();
            // TODO add your handling code here:
            //select book.title,COUNT(selectedbook.isbn) from selectedbook,book WHERE selectedbook.isbn=book.isbn GROUP BY selectedbook.isbn ORDER BY COUNT(selectedbook.isbn) DESC
            String sorgu = "select isbn,COUNT(isbn) from selectedbook GROUP BY isbn ORDER BY COUNT(isbn) DESC"
                    + " ";
            Object[] baslik = {"isbn", "oy"};
            Object[][] veri;

            PreparedStatement st = connect.prepareStatement(sorgu);
            ResultSet set = st.executeQuery();
            int count = 0;
            set.last();
            count = set.getRow();
            veri = new Object[count][5];
            set.first();
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < 2; j++) {
                    veri[i][j] = set.getObject(j + 1);
                }
                set.next();
            }

            jTable2.setModel(new DefaultTableModel(veri, baslik));
        } catch (SQLException ex) {
            Logger.getLogger(KullanıcıAnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {// yüksek puanlı
            DefaultTableModel tm = new DefaultTableModel();
            // TODO add your handling code here:
            String sorgu = " SELECT isbn, SUM(oy) FROM selectedbook GROUP BY isbn ORDER BY SUM(oy) DESC";
            //String sorgu = "SELECT isbn,oy FROM selectedbook ORDER BY oy ASC";
            Object[] baslik = {"isbn", "toplam oy"};
            Object[][] veri;

            PreparedStatement st = connect.prepareStatement(sorgu);
            ResultSet set = st.executeQuery();
            int count = 0;
            set.last();
            count = set.getRow();
            veri = new Object[count][5];
            set.first();
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < 2; j++) {
                    veri[i][j] = set.getObject(j + 1);
                }
                set.next();
            }

            jTable2.setModel(new DefaultTableModel(veri, baslik));
        } catch (SQLException ex) {
            Logger.getLogger(KullanıcıAnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            DefaultTableModel liste = new DefaultTableModel();
            //myList = new JList;

            String sorgu = "SELECT isbn,title FROM `book`";
            pst = connect.prepareStatement(sorgu);
            rs = pst.executeQuery();
            int colcount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= colcount; i++) {
                liste.addColumn(rs.getMetaData().getColumnName(i));
            }
            while (rs.next()) {
                Object[] row = new Object[colcount];
                for (int i = 1; i <= colcount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                liste.addRow(row);
            }
            jTable2.setModel(liste);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked


    }//GEN-LAST:event_jButton1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int satir = jTable2.getSelectedRow(); //Seçilen satırı bulduk
        String title = String.valueOf(jTable2.getValueAt(satir, 1));
        String filename = "C:\\Users\\MehmetCan\\Documents\\NetBeansProjects\\JavaApplication2\\pdf\\" + title + ".pdf";
        try {

            pdf = new PDFDocument(filename);
            pdf.setVisible(true);
        } catch (Exception e4) {
            e4.getMessage();
        }

       

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        ////////////////////////////////////////////////////////////////////////
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        Vector row = new Vector();

                        //jTable2.addColumn(veri);
        try {
            AraKatman arakatman = new AraKatman();
            UserPanel panel = new UserPanel();

//                    arakatman.idGelen(panel.liste.get(0));
            DefaultTableModel tm = new DefaultTableModel();
            // TODO add your handling code here:
            String sorgu = " select kulid from giris order by girisid DESC LIMIT 1";
                    //String sorgu = "SELECT isbn,oy FROM selectedbook ORDER BY oy ASC";

            PreparedStatement st = connect.prepareStatement(sorgu);
            ResultSet set = st.executeQuery();
            while (set.next()) {
                kulid1 = set.getString("kulid");
                System.out.print(kulid1);

                //}
            }
            arakatman.idGelen("35");

            Object[] baslik = {"kitap adi"};
            Object[] veri;

            int count = 0;

            veri = new Object[arakatman.arrList7.size()];

            for (int i = 0; i < arakatman.arrList7.size(); i++) {

                   // veri[i] = arakatman.arrList6.get(i);
                // tm.addRow(veri);
                veri[0] = arakatman.arrList7.get(i);
                model.addRow(veri);

            }
                     //    DefaultTableModel tableModel = new DefaultTableModel((Vector) (arakatman.arrList6), 0);

                                            // The 0 argument is number rows.
        } catch (SQLException ex) {
            Logger.getLogger(KullanıcıAnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KullanıcıAnaSayfa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(KullanıcıAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KullanıcıAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KullanıcıAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KullanıcıAnaSayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullanıcıAnaSayfa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
