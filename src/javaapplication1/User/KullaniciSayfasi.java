/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.User;

import javaapplication1.User.KullanıcıAnaSayfa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import javaapplication1.DosyaIslem.Veritabani;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MehmetCan
 */
public class KullaniciSayfasi extends javax.swing.JFrame {

    int sayac = 0;
    Connection connect = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    PreparedStatement ps1 = null;
    String degerIsbn;
    String kulad;
    String kulid;
    String oyu;
    int satir2;

  //  ArrayList<String> list=new ArrayList<String>();
    public KullaniciSayfasi() throws IOException {
        initComponents();
        connect = Veritabani.Baglanti();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabl = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kitap Seçin");

        jButton1.setText("Listele");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        tabl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1"},
                {"2"},
                {"3"},
                {"4"},
                {null}
            },
            new String [] {
                "puanlar"
            }
        ));
        jScrollPane2.setViewportView(tabl);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))))
                .addContainerGap(437, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /* Scanner scanner = new Scanner("nes.csv");
         scanner.useDelimiter(",");
         while(scanner.hasNext()){
         System.out.print(scanner.next()+"|");
         }
         scanner.close(); */
        BufferedReader crunchifyBuffer = null;

        BufferedReader br = null;
        DefaultTableModel tm = new DefaultTableModel();
        String line = "";
        Object[] row = new Object[60];
        String cvsSplitBy = ",";
        tm.addColumn("Isbn");
        tm.addColumn("book title");
        tm.addColumn("book author");
        tm.addColumn("year of");
        tm.addColumn("publisher");
        tm.addColumn("image url");
        Vector v = new Vector();
        int dizi[];
        String cumle;
        String[] kelime = null;
        try {

            br = new BufferedReader(new FileReader("BX-Books.csv"));
            while ((line = br.readLine()) != null) {

                System.out.println(line.split(";"));
                tm.addRow(line.split(";"));

                //sayac++;
                //System.out.println("Satır  \t"+line);
                 //row[sayac]=line;
                //System.out.println(row[sayac]);
               // tm.addRow((Object[]) row[sayac]);
            }
            jTable1.setModel(tm);
            jTable1.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("while sonu" + sayac);


    }//GEN-LAST:event_jButton1ActionPerformed
    int say;
    private void c(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c

        try {

            try {

                // UserPanel user= new UserPanel();
                // kulad=String.valueOf(nesne.isim);
                //kulad=user.liste.get(0);
                String sorgu = "select max(kulid) FROM kullanici";
                OylamaSayfasi oyla = new OylamaSayfasi();
                try {

                    pst = connect.prepareStatement(sorgu);
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        kulid = rs.getString(1);
                        System.out.println("kulid" + rs.getString(1));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(KullaniciSayfasi.class.getName()).log(Level.SEVERE, null, ex);
                }
                int satir = jTable1.getSelectedRow(); //Seçilen satırı bulduk7

                // System.out.println("satir"+satir);
                degerIsbn = String.valueOf(jTable1.getValueAt(satir, 0));

                // System.out.println("degger"+deger);
                say++;

                /* try{
                
                 System.out.println(deger);
                 System.out.println(kulid);
                 for(int k=0;k<=user.liste.size();k++){
                 list.add(user.liste.get(k));
                 if(list.get(k)==kulid){
                 System.out.println(list.get(k));}
                 else {
                 System.out.println("ollmadı");
                 }
                
                
                
                 }
                
                
                
                 }
                 catch(Exception e){
                 }
                 */
                //JOptionPane.showMessageDialog(null, "Kitap seçildi ");
                if (say > 10) {
                    JOptionPane.showMessageDialog(null, "Kitap seçimini tamamladınız..Ana sayfaya yönlendiiriliyorsunuz ");
                    KullanıcıAnaSayfa kullan = new KullanıcıAnaSayfa();
                    kullan.setVisible(true);
                    this.setVisible(false);

                } else {

                    /*int yanit=  JOptionPane.showConfirmDialog(null, "Seçilen kitabı oylayın", "Secilen kitabı oylayın", 1, 1);
                    
                     if(yanit == JOptionPane.YES_OPTION){
                     satir2 = tabl.getSelectedRow();
                     oyu=String.valueOf(tabl.getValueAt(satir2,0));
                    
                    
                     System.out.println("bana gelen"+oyu);
                     }
                    
                     else if(yanit == JOptionPane.NO_OPTION)
                     JOptionPane.showMessageDialog(null, "No Tuşuna bastın");
                     else if(yanit == JOptionPane.CANCEL_OPTION)
                     */
                    oyu = JOptionPane.showInputDialog(null, "Oyunuzu giriniz.", "Oyunuz", JOptionPane.INFORMATION_MESSAGE);
                    while (10 <= Integer.parseInt(oyu) || Integer.parseInt(oyu) <= 0) {
                        oyu = JOptionPane.showInputDialog("0-10 aralıgında puanlayın");
                        System.out.println(oyu);

                        //JOptionPane.showMessageDialog(null, "Kitap seçmeye devam edin ");
                    }
                }
                String sorgu2 = "INSERT INTO selectedbook (isbn, kulid,oy) VALUES (?,?,?)";
                ps1 = connect.prepareStatement(sorgu2);
                ps1.setString(1, degerIsbn);
                ps1.setString(2, kulid);
                ps1.setString(3, oyu);
                ps1.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(KullaniciSayfasi.class.getName()).log(Level.SEVERE, null, ex);
            }
            String dizi[] = new String[3];

            dizi[0] = kulid;
            dizi[1] = degerIsbn;
            dizi[2] = oyu;
            String ratingCsvPath = "C:\\Users\\MehmetCan\\Documents\\NetBeansProjects\\JavaApplication2\\BX-Book-Ratings.csv";
            File file = new File(ratingCsvPath);
            FileWriter fileWriter = null;
            FileReader fileReader = new FileReader(file);

            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(KayitSayfasi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            fileWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);

            bWriter.write('"' + dizi[0] + '"' + ";");
            bWriter.write('"' + dizi[1] + '"' + ";");
            bWriter.write('"' + dizi[2] + '"');
            bWriter.write("\n");
            bWriter.write('"' + "555;679425608;6" + '"');
            bWriter.write("\n");

            bWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(KullaniciSayfasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_c

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new KullaniciSayfasi().setVisible(true);

                } catch (IOException ex) {
                    Logger.getLogger(KullaniciSayfasi.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tabl;
    // End of variables declaration//GEN-END:variables
}
