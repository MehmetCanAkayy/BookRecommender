package javaapplication1.MachineLearning;

/**
 *  @author MehmetCan
 */
public class Kullanici {

    private String id;
    private float[] vector = new float[26];

    private int label = -1;

    public int etiketiAl() {
        return label;
    }

    public void etiketiDuzenle(int label) {
        this.label = label;
    }

    public Kullanici() {
        for (float c : vector) {
            c = 0;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float[] getVector() {
        return vector;
    }

    public void setVector(float[] vector) {
        this.vector = vector;
    }
    
}
