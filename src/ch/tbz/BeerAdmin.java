package ch.tbz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.HashMap;

public class BeerAdmin {

    public static final String BEER_STYLES_URL = "http://api.brewerydb.com/v2/styles?key=1511d0db4a1d6841481c672455358cff";

    private HashMap<Long, String> styles = new HashMap<>();

    private HashMap<Long, String> beers = new HashMap<>();

    public HashMap<Long, String> getStyles() {
        return styles;
    }

    public HashMap<Long, String> getBeers() {
        return beers;
    }

    public void loadBeerStyles(){
        JSONArray jsonArray = Driver.getJSON(BEER_STYLES_URL);
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

    public void printBeerList(String search){
        for(Long key : beers.keySet()){
            if(beers.get(key).toLowerCase().contains(search.toLowerCase())){
                System.out.println("ID: " + key);
                System.out.println("Beer: " + beers.get(key));
                System.out.println("------------------------");
            }
        }
    }

    public void printBeer(String id){
        for (Long key: beers.keySet()){
            if(beers.get(key).toLowerCase().contains(id.toLowerCase())){
                System.out.println("ID: " + key);
                System.out.println("Beer: " + styles.get(key));
                System.out.println("------------------------");
                break;
            }
        }
    }


    public void getBeerListForStyle(int styleId) {
        for (Object style : Driver.getJSON(BEER_STYLES_URL + "&styleid=" + styleId)) {
            JSONObject styleJSON = (JSONObject) style;
            long id = (long) styleJSON.get("id");
            String name = (String) styleJSON.get("name");

            beers.put(id, name);
        }
    }
}
