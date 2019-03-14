package javaapplication1.DosyaIslem;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
    


/**
 *
 * @author MehmetCan
 */
public class Veritabani {
  
    public static Connection Baglanti(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connect=DriverManager.getConnection("jdbc:mysql://localhost/bookreader","root", "");
        System.out.println("Connected");
        return connect;
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        return null;
    }
    
    }
    
}
