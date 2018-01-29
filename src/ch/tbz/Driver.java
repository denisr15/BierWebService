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
    }

    public static JSONArray getJSON(String link){
        JSONParser parser = new JSONParser();
        JSONArray data = null;
        try {
            URL oracle = new URL(link); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            JSONParser jsonParser = new JSONParser();

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                Object obj = jsonParser.parse(inputLine);
                JSONObject tutorials = (JSONObject) obj;

                 data = (JSONArray) tutorials.get("data");
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }
}
