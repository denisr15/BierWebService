package ch.tbz;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

public class BeerAdmin {

    public HashMap<Long, String> loadBeerStyles(){
        HashMap<Long, String> beerStyles = new HashMap<>();
        JSONArray jsonArray = Driver.getJSON("http://api.brewerydb.com/v2/styles?key=1511d0db4a1d6841481c672455358cff");
        for (Object style : jsonArray) {
            JSONObject styleJSON = (JSONObject) style;

            long id = (long) styleJSON.get("id");
            String name = (String) styleJSON.get("name");

            beerStyles.put(id, name);
        }
        return beerStyles;
    }

    public void getBeerListForStyle(int idStyle){
        JSONArray array = Driver.getJSON("http://api.brewerydb.com/v2/beers/?key=1511d0db4a1d6841481c672455358cff&styleId=" + idStyle);

        // TODO: add to hashmap

    }

    public static void printBeerList(){
        // TODO: url to static variable
        for (Object style : Driver.getJSON("http://api.brewerydb.com/v2/styles?key=1511d0db4a1d6841481c672455358cff")) {
            JSONObject styleJSON = (JSONObject) style;

            long id = (long) styleJSON.get("id");
            System.out.println("ID : " + id);

            String name = (String) styleJSON.get("name");
            System.out.println("Name: " + name);
        }

        System.out.println("\n");
    }


}
