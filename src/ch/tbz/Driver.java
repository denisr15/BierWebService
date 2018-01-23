package ch.tbz;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Driver {


    public static void main(String[] args) throws IOException {

        JSONParser parser = new JSONParser();

        try {
            URL oracle = new URL("http://api.brewerydb.com/v2/styles?key=1511d0db4a1d6841481c672455358cff"); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONParser jsonParser = new JSONParser();
                Object obj  = jsonParser.parse(inputLine);
                JSONArray array = new JSONArray();
                array.add(obj);
                // Loop through each item
                for (Object o : array) {
                    JSONObject tutorials = (JSONObject) o;

                    Long id = (Long) tutorials.get("id");
                    System.out.println("ID : " + id);

                    String name = (String) tutorials.get("name");
                    System.out.println("Name: " + name);

                    System.out.println("\n");
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
