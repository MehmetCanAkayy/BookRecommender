package  javaapplication1.MachineLearning;

import javaapplication1.MachineLearning.Kullanici;
import javaapplication1.MachineLearning.KullanicilarVeKelimeler;
import javaapplication1.MachineLearning.Hesaplama;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *  @author MehmetCan
 */
public class Kumeleme {

    private Gson gson;

    public static void main(String[] args) {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeSpecialFloatingPointValues();

        Kumeleme kMeans = new Kumeleme();
        kMeans.gson = gsonBuilder.create();

       
        List<KullanicilarVeKelimeler> userWithWordBagList = new ArrayList<KullanicilarVeKelimeler>();

        String dosyaYolu = "C://Users//MehmetCan//Documents//NetBeansProjects//JavaApplication2//kelimeler";
        BufferedReader userBufferedReader = null;

        try {
            userBufferedReader = new BufferedReader(new FileReader(dosyaYolu));

            String line;
            
            userBufferedReader.readLine();
            while ((line = userBufferedReader.readLine()) != null) {
                KullanicilarVeKelimeler userWithWordBag = kMeans.gson.fromJson(line, KullanicilarVeKelimeler.class);
                userWithWordBagList.add(userWithWordBag);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (userBufferedReader != null) {
                try {
                    userBufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
      

        kMeans.kMeans(userWithWordBagList, 15);

    }

    public void kMeans(List<KullanicilarVeKelimeler> users, int k) {
       
       // AraKatman ara=new AraKatman();
       
        List<Kullanici> userVectors = kullanicilariGetir(users);
       

        List<Kullanici> meanVectors = new ArrayList<Kullanici>(k);
        int size = userVectors.size();

        Random random = new Random();
        
        for (int i = 0; i < k; i++) {
            meanVectors.add(userVectors.get(random.nextInt(size)));
        }
//  System.out.println(meanVectors);
        int dongu = 1;

        boolean isChanged = true;
        while (isChanged) {

           System.out.println("sayac" + (dongu++) + "--");


            if (dongu == 4000) {
                System.out.println("Kullanici islemi tamamlandi");
                break;
            }
  
            isChanged = false;

            
            for (Kullanici user : userVectors) {
                int label = getClassLabel(user, meanVectors);
                user.etiketiDuzenle(label);
            }

           
            for (int i = 0; i < k; i++) {
                float[] total = new float[26];
                for (Kullanici user : userVectors) {
                    if (user.etiketiAl() == i) {
                        total = Hesaplama.vektorEkle(total, user.getVector());
                    }
                }
                float[] mean = Hesaplama.vectorMean(total);
                boolean equals = Hesaplama.vektorEsitle(mean, meanVectors.get(i).getVector());

                if (!equals) {
                    
                    meanVectors.get(i).setVector(mean);
                    isChanged = true;
                }
            }
        }

      
        String labelPath ="C://Users//MehmetCan//Documents//NetBeansProjects//JavaApplication2//etiketleme";
        System.out.println(labelPath);

        File etiketlemeDosyasi = new File(labelPath);
        if (!etiketlemeDosyasi.exists()) {
            try {
                etiketlemeDosyasi.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedWriter userLabelWriter = null;

        try {
            userLabelWriter = new BufferedWriter(new FileWriter(etiketlemeDosyasi));

            for (Kullanici userVector : userVectors) {
                String id = userVector.getId();
                int label = userVector.etiketiAl();

                userLabelWriter.write(gson.toJson(userVector) + "\n");
             //   ara.list=(List<UserVector>) userVector;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (userLabelWriter != null) {
                try {
                    userLabelWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

   
    private int getClassLabel(Kullanici user, List<Kullanici> meanVectors) {

        float minUzaklik = Float.MAX_VALUE;
        int label = 0;

        for (int i = 0; i < meanVectors.size(); i++) {
            Kullanici userVector = meanVectors.get(i);
            float uzaklik = Hesaplama.dist(user, userVector);
            if (uzaklik < minUzaklik) {
                minUzaklik = uzaklik;
                label = i;
            }
        }
        return label;
    }

   
    private List<Kullanici> kullanicilariGetir(List<KullanicilarVeKelimeler> users) {

        List<Kullanici> kullaniciVektor = new ArrayList<Kullanici>(users.size());

        for (KullanicilarVeKelimeler user : users) {

            Kullanici userVector = new Kullanici();

            String id = user.getId();
            userVector.setId(id);

            Map<String, Float> map = user.getMap();

            float[] vector = userVector.getVector();

            for (Map.Entry<String, Float> entry : map.entrySet()) {
                String word = entry.getKey();
                Float weight = entry.getValue();

                
                
                
                float[] wordVector = Hesaplama.getir(word);

                for (int i = 0; i < wordVector.length; i++) {
                    vector[i] += wordVector[i] * weight;
                }
            }

            kullaniciVektor.add(userVector);
        }

        return kullaniciVektor;
    }
}
