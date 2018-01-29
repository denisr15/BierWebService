package ch.tbz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.HashMap;

public class BeerAdmin {

    private static final String API_KEY = "?key=1511d0db4a1d6841481c672455358cff";

    private static final String BASE_URL = "http://api.brewerydb.com/v2";
    private static final String STYLES_URL = BASE_URL + "/styles" + API_KEY;
    private static final String BEERS_URL = BASE_URL + "/beers" + API_KEY + "&styleId=";

    private HashMap<Long, String> styles = new HashMap<>();

    private HashMap<String, String> beers = new HashMap<>();

    public HashMap<Long, String> getStyles() {
        return styles;
    }

    /*public HashMap<Long, String> getBeers() {
        return beers;
    }*/

    public void loadBeerStyles(){
        JSONArray jsonArray = Driver.getJSON(STYLES_URL);
        for (Object style : jsonArray) {
            JSONObject styleJSON = (JSONObject) style;

            long id = (long) styleJSON.get("id");
            String name = (String) styleJSON.get("name");

            styles.put(id, name);
        }
    }

    public void printBeerStyles(){

        for(Long key : styles.keySet()){
            System.out.println("ID: " + key);
            System.out.println("Style: " + styles.get(key));
            System.out.println("------------------------");
        }
    }

    public void printBeerStyles(String search){

        for(Long key : styles.keySet()){
            if(styles.get(key).toLowerCase().contains(search.toLowerCase())){
                System.out.println("ID: " + key);
                System.out.println("Style: " + styles.get(key));
                System.out.println("------------------------");
            }
        }
    }

    public void printBeerList(){
        for(String key : beers.keySet()){
                System.out.println("ID: " + key);
                System.out.println("Beer: " + beers.get(key));
                System.out.println("------------------------");
        }
    }

    public void printBeer(String id){
        for (String key: beers.keySet()){
            if(beers.get(key).equals(id)){
                System.out.println("ID: " + key);
                System.out.println("Beer: " + beers.get(key));
                System.out.println("------------------------");
                break;
            }
        }
    }

    public void getBeerListForStyle(int styleId) {
        for (Object style : Driver.getJSON(BEERS_URL + styleId)) {
            JSONObject styleJSON = (JSONObject) style;
            String id = (String) styleJSON.get("id");
            String name = (String) styleJSON.get("name");

            beers.put(id, name);
        }
    }
}
