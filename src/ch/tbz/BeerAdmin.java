package ch.tbz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class BeerAdmin {

    private HashMap<Long, String> beerStyles = null;

    public static final String BEER_STYLES_URL = "http://api.brewerydb.com/v2/styles?key=1511d0db4a1d6841481c672455358cff";

    public HashMap<Long, String> loadBeerStyles(){

        JSONArray jsonArray = Driver.getJSON(BEER_STYLES_URL);
        for (Object style : jsonArray) {
            JSONObject styleJSON = (JSONObject) style;

            long id = (long) styleJSON.get("id");
            String name = (String) styleJSON.get("name");

            beerStyles.put(id, name);
        }
        return beerStyles;
    }

    public void printBeerStyles(){
        HashMap<Long, String> beerStyles = loadBeerStyles();

        for(Long key : beerStyles.keySet()){
            System.out.println("ID: " + key);
            System.out.println("Style: " + beerStyles.get(key));
            System.out.println("------------------------");
        }
    }

    public void printBeerStyles(String search){
        HashMap<Long, String> beerStyles = loadBeerStyles();

        for(Long key : beerStyles.keySet()){
            if(beerStyles.get(key).toLowerCase().contains(search.toLowerCase())){
                System.out.println("ID: " + key);
                System.out.println("Style: " + beerStyles.get(key));
                System.out.println("------------------------");
            }
        }
    }

    public void getBeerListForStyle(int idStyle){
        JSONArray array = Driver.getJSON(BEER_STYLES_URL + "&styleId=" + idStyle);

        // TODO: add to hashmap

    }

    public static void printBeerList(){
        // TODO: url to static variable
        for (Object style : Driver.getJSON(BEER_STYLES_URL)) {
            JSONObject styleJSON = (JSONObject) style;

            long id = (long) styleJSON.get("id");
            System.out.println("ID : " + id);

            String name = (String) styleJSON.get("name");
            System.out.println("Name: " + name);
        }

        System.out.println("\n");
    }


}
