package javaapplication1.MachineLearning;

import javaapplication1.MachineLearning.CsvdenVeritabanina;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 *  @author MehmetCan
 */
public class KitaptanOkuma {

    public static Map<String, String> getBookMap() {


        
        Map<String, String> map = new HashMap<String, String>();


        
        String userCsvPath = "C:\\Users\\MehmetCan\\Documents\\NetBeansProjects\\JavaApplication2\\BX-Books.csv";

        File file = new File(userCsvPath);

        if (!file.exists()) {
            
            return null;
        }

        FileReader fileReader;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String line;
            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                line = line.replace("\"", "").replace("\\", "").replace("'", "");
                String[] arr = line.split(";");

                if (arr.length < 3) continue;//ilk iki sütunu al

                String isbn = arr[0];
                String title = arr[1];

                map.put(isbn, title);

            }

            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }
}
