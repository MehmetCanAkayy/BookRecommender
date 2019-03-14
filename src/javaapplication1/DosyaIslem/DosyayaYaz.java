/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1.DosyaIslem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class DosyayaYaz  {
      File file = new File("az.txt");
   
       
      // BufferedReader bufferReader = null;
      // BufferedWriter bufferwriter ;
    public void yaz(String a) throws FileNotFoundException, IOException, SQLException{
  FileWriter fileWriter = new FileWriter(file, false);
   BufferedWriter bWriter = new BufferedWriter(fileWriter);
        if (!file.exists()) {
            file.createNewFile();
        }

        
        bWriter.write(a);
       // bWriter.close();
//bufferwriter = new BufferedWriter(new FileWriter(outFile));
//bufferwriter.write(a);

    }
}
