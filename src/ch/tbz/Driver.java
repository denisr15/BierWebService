package ch.tbz;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Driver {

    public static void main(String[] args) throws IOException {
        BeerAdmin admin = new BeerAdmin();
        Scanner sc = new Scanner(System.in);

        boolean end = false;

        admin.loadBeerStyles();

        while (!end){
            System.out.println("-----------------------------------------");
            System.out.println("|1| Alle Styles ausgeben                 |");
            System.out.println("|2| Nach einem Style suchen              |");
            System.out.println("|3| Alle Biere von einem Style ausgeben  |");
            System.out.println("|4| Alle geladenen Biere ausgeben        |");
            System.out.println("|5| Beenden                              |");
            System.out.println("-----------------------------------------");

            String input = sc.next();

            if(input.equals("1")){
                admin.printBeerStyles();
            } else if(input.equals("2")){
                System.out.println("Geben sie ein Suchwort ein: ");
                String search = sc.next();
                admin.printBeerStyles(search);
            } else if(input.equals("3")){
                System.out.println("Geben sie eine Style ID ein: ");
                String id = sc.next();

                admin.getBeerListForStyle(Integer.parseInt(id));
                admin.printBeerList();

            } else if(input.equals("4")){
                admin.printBeerList();
            } else if(input.equals("5")){
                end = true;
            } else {
                System.out.println("Ungültige Eingabe");
            }
        }

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
