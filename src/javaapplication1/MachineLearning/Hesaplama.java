package javaapplication1.MachineLearning;

import javaapplication1.MachineLearning.Kullanici;

/**
 * @author MehmetCan
 */
public class Hesaplama {

    // Hesaplanan mesafe
    public static float dist(Kullanici user1, Kullanici user2) {

        float[] kullaniciOne = user1.getVector();
        float[] kullaniciTwo = user2.getVector();

        float one = 0;
        float two = 0;
        float sum = 0;

        for (int i = 0; i < kullaniciOne.length; i++) {
            sum += kullaniciOne[i] * kullaniciTwo[i];
            one += kullaniciOne[i] * kullaniciOne[i];
            two += kullaniciTwo[i] * kullaniciTwo[i];
        }
        float dist = (float) (sum / Math.sqrt(one * two));
        
        return dist;
    }

    // Kelime vekt�r� al
    public static float[] getir(String word) {

        float[] vector = new float[26];

        for (char c : word.toLowerCase().toCharArray()) {
            if (c - 'a' < 0 || c - 'a' >= 26) {
                continue;
            }
            vector[c - 'a'] = 1;
        }
        return vector;
    }

    
    public static float[] vectorMean(float[] total) {
        float sum = 0;
        for (float v : total) {
            sum += v;
        }
        for (int i = 0; i < total.length; i++) {
            total[i] /= sum;
        }
        return total;
    }

    
    public static float[] vektorEkle(float[] total, float[] vector) {
        for (int i = 0; i < total.length; i++) {
            total[i] = total[i] + vector[i];
        }
        return total;
    }

    
    public static boolean vektorEsitle(float[] mean, float[] vector) {
        for (int i = 0; i < mean.length; i++) {
            if (mean[i] != vector[i])
                return false;
        }
        return true;
    }
}
