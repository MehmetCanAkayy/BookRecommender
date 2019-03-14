package javaapplication1.MachineLearning;

import javaapplication1.MachineLearning.KullanicilarVeKelimeler;
import com.google.gson.Gson;

import java.io.*;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 *  @author MehmetCan
 */
public class Verislem {

    private Set<String> stopWordSet = new HashSet<String>();
    private Map<String, String> kitaplarr;

  
    public static void main(String[] args) {
        Verislem processData = new Verislem();
        processData.kelimeleriGetir();
    }


   
    public void kelimeleriGetir() {

        
        String stopWordPath ="C:\\Users\\MehmetCan\\Documents\\NetBeansProjects\\JavaApplication2\\StopWords";
        BufferedReader stopWordsBuffedReader = null;

       
        try {
            stopWordsBuffedReader = new BufferedReader(new FileReader(stopWordPath));
            String stopWord;

            while ((stopWord = stopWordsBuffedReader.readLine()) != null) {
                stopWordSet.add(stopWord);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stopWordsBuffedReader != null) {
                try {
                    stopWordsBuffedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        kitaplarr = KitaptanOkuma.getBookMap();
        
        String userPath = "C:\\Users\\MehmetCan\\Documents\\NetBeansProjects\\JavaApplication2\\BX-Book-Ratings.csv";

        String kelimeYolu = "C:\\Users\\MehmetCan\\Documents\\NetBeansProjects\\JavaApplication2\\kelimeler";
        System.out.println(kelimeYolu);

        File kelimeDosyasi = new File(kelimeYolu);
        if (!kelimeDosyasi.exists()) {
            try {
                kelimeDosyasi.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        BufferedWriter wordsBagWriter = null;
        BufferedReader userBufferedReader = null;

        Gson gson = new Gson();

        try {
            wordsBagWriter = new BufferedWriter(new FileWriter(kelimeDosyasi));
            userBufferedReader = new BufferedReader(new FileReader(userPath));

            String user;

           
            String curUserId = "";
            KullanicilarVeKelimeler curUserObj = new KullanicilarVeKelimeler();

            userBufferedReader.readLine();
            while ((user = userBufferedReader.readLine()) != null) {
                user = user.replace("\"", "");
                String[] users = user.split(";");
                if (users.length != 3) continue;

                String id = users[0];
                String isbn = users[1];
                int rating = Integer.parseInt(users[2]);

                if (curUserId.equals(id)) {
                    kelimeleriDuzenle(curUserObj.getMap(), isbn, rating);
                } else {
                   
                    wordsBagWriter.write(gson.toJson(curUserObj) + "\n");
                    wordsBagWriter.flush();

                    
                    curUserId = id;
                    curUserObj.setId(id);
                    curUserObj.getMap().clear();

                    
                    kelimeleriDuzenle(curUserObj.getMap(), isbn, rating);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stopWordsBuffedReader != null) {
                try {
                    stopWordsBuffedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (userBufferedReader != null) {
                try {
                    userBufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (wordsBagWriter != null) {
                try {
                    wordsBagWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    
    private void kelimeleriDuzenle(Map<String, Float> map, String isbn, int rating) {
        System.out.println(isbn);
        String sent = kitaplarr.get(isbn);
        if (sent == null) return;

        String[] sents = sent.toLowerCase().split(" ");
        for (String word : sents) {
            if (!stopWordSet.contains(word)) {
                map.put(word, (float) (rating * 0.10 + 0.001));
            }
        }
    }
   

}
