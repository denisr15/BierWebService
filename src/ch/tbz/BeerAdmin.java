package ch.tbz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BeerAdmin {

    private static final String API_KEY = "?key=1511d0db4a1d6841481c672455358cff";

    private static final String BASE_URL = "http://api.brewerydb.com/v2";
    private static final String STYLES_URL = BASE_URL + "/styles" + API_KEY;
    private static final String BEERS_URL = BASE_URL + "/beers" + API_KEY + "&styleId=";

    private HashMap<Long, String> styles = new HashMap<>();

    private List<Beer> beers = new ArrayList<>();

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
        for(Beer beer : beers){
            System.out.println("ID: " + beer.getId());
            System.out.println("Beer: " + beer.getName());
            System.out.println("------------------------");
        }
    }

    public void printBeer(String id){
        for (Beer beer: beers){
            if(beer.equals(id)){
                System.out.println("ID: " + beer.getId());
                System.out.println("Beer: " + beer.getName());
                System.out.println("Description: " + beer.getDescription());
                break;
            }
        }
    }

    public void getBeerListForStyle(int styleId) {
        for (Object style : Driver.getJSON(BEERS_URL + styleId)) {
            JSONObject styleJSON = (JSONObject) style;

            String id = (String) styleJSON.get("id");

            String name = (String) styleJSON.get("name");
            String description = (String) styleJSON.get("description");
            Long idstyle = (Long) styleJSON.get("styleId");

            Beer beer = new Beer(id, name, description, idstyle);
            beers.add(beer);
        }
    }
}
