package javaapplication1.MachineLearning;

import java.util.HashMap;
import java.util.Map;

/**
 *  @author MehmetCan.
 */
public class KullanicilarVeKelimeler {

    
    private String id;

    
    private Map<String, Float> map = new HashMap<String, Float>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, Float> getMap() {
        return map;
    }

    public void setMap(Map<String, Float> map) {
        this.map = map;
    }
}
