package ch.tbz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class BeerAdmin {
    private String apiKey = "";
    private String urlString = "";

    URL url = new URL("http://api.brewerydb.com/v2/styles?key=1511d0db4a1d6841481c672455358cff");
    URLConnection yc = url.openConnection();

    //test and show result as String:
    BufferedReader in = new BufferedReader
        (new InputStreamReader(yc.getInputStream()));
    String inputLine;

    public BeerAdmin() throws IOException {
        while ((inputLine = in.readLine()) != null)
        System.out.println(inputLine);
        in.close();
    }


}
