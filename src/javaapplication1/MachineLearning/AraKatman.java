/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.MachineLearning;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication1.DosyaIslem.Veritabani;
import javaapplication1.MachineLearning.Kumeleme;
import javaapplication1.User.KullaniciSayfasi;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MehmetCan
 */
public class AraKatman {

    String userVectorPath = "C://Users//MehmetCan//Documents//NetBeansProjects//JavaApplication2//etiketleme";
    List<String> arrList0 = new ArrayList<String>();
    List<String> arrList1 = new ArrayList<String>();
    List<String> arrList2 = new ArrayList<String>();
    public List<String> arrList4 = new ArrayList<String>();
    public List<String> arrList6 = new ArrayList<String>();
    public List<String> arrList3 = new ArrayList<String>();
    public List<String> arrList7 = new ArrayList<String>();
      public List<String> arrList10 = new ArrayList<String>();
    List<String> arrList5 = new ArrayList<String>();

    static Connection connect = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    BufferedReader reader = null;
    GsonBuilder gsonBuilder = new GsonBuilder();

    public void oku() throws IOException, SQLException {
        connect = Veritabani.Baglanti();
        List<Kullanici> list = new ArrayList<Kullanici>();
        gsonBuilder.serializeSpecialFloatingPointValues();
        Gson gson = gsonBuilder.create();

        reader = new BufferedReader(new FileReader(userVectorPath));

        String line;
        while ((line = reader.readLine()) != null) {
            //  try {
            list.add(gson.fromJson(line, Kullanici.class));
            //System.out.println(line);
            line = line.replace("\"", "").replace("\\", "").replace("'", "").replace("[", "").replace("]", "").replace("}", "");
            String[] arr = line.split(",");
            String isbn = arr[0];
            String isbn1 = arr[1];
            String[] arr1 = isbn.split(":");
            String[] arr12 = isbn1.split(":");

            arr[0] = arr1[1];
            arr[1] = arr12[1];
//id ve ona ait labelı etiketlemeden oku
            //  System.out.print("user id:"+arr[0]+"---");
            float toplam = 0;
            for (int i = 2; i < arr.length - 1; i++) {
                String d = arr[i];
                float k = Float.parseFloat(d);
                toplam = toplam + k;

            }

            String k = arr[arr.length - 1];
            String[] e = k.split(":");
            //  System.out.println("label:"+e[1]+"-----"+"toplam: "+toplam);
            if (e[1].equals("0")) {
                String sorgu = "SELECT kulid FROM `arakatman`WHERE label=0 ORDER BY `arakatman`.`toplamOy` DESC LIMIT 5";
                PreparedStatement st = connect.prepareStatement(sorgu);
                ResultSet set = st.executeQuery();
                while (set.next()) {

                    arrList0.add(set.getString("kulid"));
                }     // System.out.println("label---2---id------"+arr[0]+"-----"+"toplam: "+toplam);
            }
            if (e[1].equals("1")) {
                String sorgu = "SELECT kulid FROM `arakatman`WHERE label=1 ORDER BY `arakatman`.`toplamOy` DESC LIMIT 5";
                PreparedStatement st = connect.prepareStatement(sorgu);
                ResultSet set = st.executeQuery();
                while (set.next()) {

                    arrList1.add(set.getString("kulid"));
                }     // System.out.println("label---2---id------"+arr[0]+"-----"+"toplam: "+toplam);
            }

            if (e[1].equals("2")) {
                //  select isbn,max(rating) from rating  where userid=( SELECT kulid FROM `arakatman`WHERE label=2 ORDER BY `arakatman`.`toplamOy` DESC LIMIT 1)
                String sorgu = "SELECT kulid FROM `arakatman`WHERE label=2 ORDER BY `arakatman`.`toplamOy` DESC LIMIT 5";
                PreparedStatement st = connect.prepareStatement(sorgu);
                ResultSet set = st.executeQuery();
                while (set.next()) {

                    arrList2.add(set.getString("kulid"));

                }     // System.out.println("label---2---id------"+arr[0]+"-----"+"toplam: "+toplam);

            }

            if (e[1].equals("3")) {
                         //    System.out.println("label---3----id-----"+arr[0]+"-----"+"toplam: "+toplam);

            }
            if (e[1].equals("4")) {
                           //  System.out.println("label---4-----id----"+arr[0]+"-----"+"toplam: "+toplam);

            }
            if (e[1].equals("5")) {
                           // System.out.println("label---5----id-----"+arr[0]+"-----"+"toplam: "+toplam);

            }
            if (e[1].equals("6")) {
                           //  System.out.println("label---6----id-----"+arr[0]+"-----"+"toplam: "+toplam);

            }
            if (e[1].equals("7")) {
                           //  System.out.println("label---7----id----"+arr[0]+"-----"+"toplam: "+toplam);

            }
            if (e[1].equals("8")) {
                            // System.out.println("label---8----id-----"+arr[0]+"-----"+"toplam: "+toplam);

            }
            if (e[1].equals("9")) {
                            // System.out.println("label---9-----id----"+arr[0]+"-----"+"toplam: "+toplam);

            }
            if (e[1].equals("10")) {
                             //System.out.println("label---10----id----"+arr[0]+"-----"+"toplam: "+toplam);
                String sorgu = "SELECT kulid FROM `arakatman`WHERE label=2 ORDER BY `arakatman`.`toplamOy` DESC LIMIT 5";
                PreparedStatement st = connect.prepareStatement(sorgu);
                ResultSet set = st.executeQuery();
                while (set.next()) {

                    arrList10.add(set.getString("kulid"));

                }     // System.out.println("label---2---id------"+arr[0]+"-----"+"toplam: "+toplam);

                 for (int t = 0; t <= 4; t++) {

            String sorgu1 = "SELECT title FROM book WHERE isbn IN (SELECT isbn FROM rating WHERE userid='" + arrList10.get(t) + "' AND rating=10)ORDER BY RAND() LIMIT 5";

            DefaultTableModel liste = new DefaultTableModel();
            PreparedStatement pst = connect.prepareStatement(sorgu1);
            ResultSet set1 = pst.executeQuery();
            int colcount = 5;
            int sayac = 0;

            while (set1.next()) {

                sayac++;
                arrList3.add(set.getString("title"));
                System.out.println(set1.getString("title"));

            }
            System.out.println(sayac);
                     // arrList3.add(set.getString("isbn")); 

        }

        System.out.println("lboyutu:--" + arrList3.size());

        if (arrList3.size() > 10) {
            Random rand = new Random();
            for (int i = 0; i < 10; i++) {
                int randomIndex = rand.nextInt(arrList3.size());
                String randomElement = arrList3.get(randomIndex);
                System.out.println(randomElement);
            }
        } else {
            for (int i = 0; i < arrList3.size(); i++) {
                System.out.println(arrList3.get(i));
            }
        }

            }
            if (e[1].equals("11")) {
                             //System.out.println("label---11-----id----"+arr[0]+"-----"+"toplam: "+toplam);

            }
            if (e[1].equals("12")) {
                           //  System.out.println("label---12-----id----"+arr[0]+"-----"+"toplam: "+toplam);

            }
            if (e[1].equals("13")) {
                            // System.out.println("label---13-----id----"+arr[0]+"-----"+"toplam: "+toplam);

            }
            if (e[1].equals("14")) {
                            // System.out.println("label---14-----v---"+arr[0]+"-----"+"toplam: "+toplam);

            }

            /*    String sorgu="insert into arakatman(label,kulid,toplamoy) values(?,?,?)";
                         
                         
             PreparedStatement ps=connect.prepareStatement(sorgu);
             ps.setString(1, e[1]);
             ps.setString(2,arr[0]);
             ps.setString(3,String.valueOf(toplam));
                         
                      
             ps.executeUpdate();
                       
                   
             if (reader != null) {
                             
             //  reader.close();
                             
             }       } catch (SQLException ex) {
             Logger.getLogger(AraKatman.class.getName()).log(Level.SEVERE, null, ex);
                  
             */
                  //}        
        }
//while sonu
        System.out.println("label 0:--" + arrList0.get(0) + "--" + arrList0.get(1) + "--" + arrList0.get(2) + "--" + arrList0.get(3) + "--" + arrList0.get(4));
        //  System.out.println("label 1:--"+arrList1.get(0)+"--"+arrList1.get(1)+"--"+arrList1.get(2)+"--"+arrList1.get(3)+"--"+arrList1.get(4));
        System.out.println("label 2:--" + arrList2.get(0) + "--" + arrList2.get(1) + "--" + arrList2.get(2) + "--" + arrList2.get(3) + "--" + arrList2.get(4));
                  //System.out.println(arrList2);  

        for (int t = 0; t <= 4; t++) {

            String sorgu = "SELECT title FROM book WHERE isbn IN (SELECT isbn FROM rating WHERE userid='" + arrList2.get(t) + "' AND rating=10)ORDER BY RAND() LIMIT 5";

            DefaultTableModel liste = new DefaultTableModel();
            PreparedStatement st = connect.prepareStatement(sorgu);
            ResultSet set = st.executeQuery();
            int colcount = 5;
            int sayac = 0;

            while (set.next()) {

                sayac++;
                arrList3.add(set.getString("title"));
                System.out.println(set.getString("title"));

            }
            System.out.println(sayac);
                     // arrList3.add(set.getString("isbn")); 

        }

        System.out.println("lboyutu:--" + arrList3.size());

        if (arrList3.size() > 10) {
            Random rand = new Random();
            for (int i = 0; i < 10; i++) {
                int randomIndex = rand.nextInt(arrList3.size());
                String randomElement = arrList3.get(randomIndex);
                System.out.println(randomElement);
            }
        } else {
            for (int i = 0; i < arrList3.size(); i++) {
                System.out.println(arrList3.get(i));
            }
        }

// System.out.println(arrList3.get(new Random(r).nextInt(arrList3.size())));
    }

    public void idGelen(String id) throws SQLException, FileNotFoundException, IOException {

        String userVectorPath = "C://Users//MehmetCan//Documents//NetBeansProjects//JavaApplication2//etiketleme";
        List<String> arrList0 = new ArrayList<String>();
        List<String> arrList1 = new ArrayList<String>();
        List<String> arrList2 = new ArrayList<String>();
        List<String> arrList3 = new ArrayList<String>();

        connect = Veritabani.Baglanti();
        List<Kullanici> list = new ArrayList<Kullanici>();
        gsonBuilder.serializeSpecialFloatingPointValues();
        Gson gson = gsonBuilder.create();

        reader = new BufferedReader(new FileReader(userVectorPath));

        String line;
        while ((line = reader.readLine()) != null) {
            //  try {
            list.add(gson.fromJson(line, Kullanici.class));
            //System.out.println(line);
            line = line.replace("\"", "").replace("\\", "").replace("'", "").replace("[", "").replace("]", "").replace("}", "");
            String[] arr = line.split(",");
            String isbn = arr[0];
            String isbn1 = arr[1];
            String[] arr1 = isbn.split(":");
            String[] arr12 = isbn1.split(":");

            arr[0] = arr1[1];
            arr[1] = arr12[1];
            if (arr[0].equalsIgnoreCase(id)) {
                //  System.out.print("user id:"+arr[0]+"---");
                float toplam = 0;
                for (int i = 2; i < arr.length - 1; i++) {
                    String d = arr[i];
                    float k = Float.parseFloat(d);
                    toplam = toplam + k;

                }

                String k = arr[arr.length - 1];
                String[] e = k.split(":");
                System.out.println("label:" + e[1] + "-----" + "toplam: " + toplam);

                if (e[1].equals("0")) {
                    String sorgu = "SELECT kulid FROM `arakatman`WHERE label=0 ORDER BY `arakatman`.`toplamOy` DESC LIMIT 5";
                    PreparedStatement st = connect.prepareStatement(sorgu);
                    ResultSet set = st.executeQuery();
                    while (set.next()) {

                        arrList0.add(set.getString("kulid"));
                    }     // System.out.println("label---2---id------"+arr[0]+"-----"+"toplam: "+toplam);
                } else if (e[1].equals("1")) {
                    String sorgu = "SELECT kulid FROM `arakatman`WHERE label=1 ORDER BY `arakatman`.`toplamOy` DESC LIMIT 5";
                    PreparedStatement st = connect.prepareStatement(sorgu);
                    ResultSet set = st.executeQuery();
                    while (set.next()) {

                        arrList1.add(set.getString("kulid"));
                    }     // System.out.println("label---2---id------"+arr[0]+"-----"+"toplam: "+toplam);
                } else if (e[1].equals("2")) {
                    //  select isbn,max(rating) from rating  where userid=( SELECT kulid FROM `arakatman`WHERE label=2 ORDER BY `arakatman`.`toplamOy` DESC LIMIT 1)
                    String sorgu = "SELECT kulid FROM `arakatman`WHERE label=2 ORDER BY `arakatman`.`toplamOy` DESC LIMIT 5";
                    PreparedStatement st = connect.prepareStatement(sorgu);
                    ResultSet set = st.executeQuery();
                    while (set.next()) {

                        arrList4.add(set.getString("kulid"));

                    }
                    System.out.println(arrList4);

                } else if (e[1].equals("3")) {
                    System.out.println("label---3----id-----" + arr[0] + "-----" + "toplam: " + toplam);

                } else if (e[1].equals("4")) {
                    System.out.println("label---4-----id----" + arr[0] + "-----" + "toplam: " + toplam);
                      String sorgu = "SELECT kulid FROM `arakatman`WHERE label=2 ORDER BY `arakatman`.`toplamOy` DESC LIMIT 5";
                    PreparedStatement st = connect.prepareStatement(sorgu);
                    ResultSet set = st.executeQuery();
                    while (set.next()) {

                        arrList4.add(set.getString("kulid"));

                    }
                    System.out.println(arrList4);

                } else if (e[1].equals("5")) {
                    System.out.println("label---5----id-----" + arr[0] + "-----" + "toplam: " + toplam);

                } else if (e[1].equals("6")) {
                    System.out.println("label---6----id-----" + arr[0] + "-----" + "toplam: " + toplam);

                } else if (e[1].equals("7")) {
                    System.out.println("label---7----id----" + arr[0] + "-----" + "toplam: " + toplam);

                } else if (e[1].equals("8")) {
                    System.out.println("label---8----id-----" + arr[0] + "-----" + "toplam: " + toplam);

                } else if (e[1].equals("9")) {
                    System.out.println("label---9-----id----" + arr[0] + "-----" + "toplam: " + toplam);

                } else if (e[1].equals("10")) {
                    System.out.println("label---10----id----" + arr[0] + "-----" + "toplam: " + toplam);
                       String sorgu = "SELECT kulid FROM `arakatman`WHERE label=10 ORDER BY `arakatman`.`toplamOy` DESC LIMIT 5";
                    PreparedStatement st = connect.prepareStatement(sorgu);
                    ResultSet set = st.executeQuery();
                    while (set.next()) {

                        arrList10.add(set.getString("kulid"));

                    }
                    System.out.println(arrList10);
                }
                if (e[1].equals("11")) {
                    System.out.println("label---11-----id----" + arr[0] + "-----" + "toplam: " + toplam);

                } else if (e[1].equals("12")) {
                    System.out.println("label---12-----id----" + arr[0] + "-----" + "toplam: " + toplam);

                } else if (e[1].equals("13")) {
                    System.out.println("label---13-----id----" + arr[0] + "-----" + "toplam: " + toplam);

                } else if (e[1].equals("14")) {
                    System.out.println("label---14-----v---" + arr[0] + "-----" + "toplam: " + toplam);

                }

                for (int t = 0; t <= 4; t++) {
                 String sorgu = "SELECT title FROM book WHERE isbn IN (SELECT isbn FROM rating WHERE userid='" + arrList4.get(t) + "' AND rating=10)ORDER BY RAND() LIMIT 5";
                    //   System.out.println(arrList4.get(t));
                    PreparedStatement st1 = connect.prepareStatement(sorgu);
                    ResultSet set1 = st1.executeQuery();

                    int sayac = 0;

                    while (set1.next()) {

                        sayac++;
                        arrList6.add(set1.getString("title"));
               //   System.out.println("3");
                        //   System.out.println(set1.getString("title"));

                    }
          //  System.out.println(sayac);
                    // arrList3.add(set.getString("isbn")); 

                }

                System.out.println("lboyutu:--" + arrList4.size());

                if (arrList6.size() > 10) {
                    Random rand = new Random();
                    for (int i = 0; i < 10; i++) {
                        int randomIndex = rand.nextInt(arrList6.size());
                        String randomElement = arrList6.get(randomIndex);
                        arrList7.add(randomElement);
                        
                        System.out.println(randomElement);
                    }
                } else {
                    for (int i = 0; i < arrList6.size(); i++) {
                        arrList7.add(arrList6.get(i));
                        System.out.println(arrList6.get(i));
                    }
                }

            }
                

                     //arrList3.add(set.getString("isbn")); 
// System.out.println(arrList3.get(new Random(r).nextInt(arrList3.size())));
        }
    }

    public static void main(String[] args) throws IOException, SQLException {
        AraKatman ara = new AraKatman();
         //ara.oku();

        ara.idGelen("35");

    }
     
                
}
