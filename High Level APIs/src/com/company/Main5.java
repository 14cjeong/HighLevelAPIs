package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;


//Using a more involved URL
//API
public class Main5 {

    public static void main(String[] args) {

        try {
            //The ? mark indicates that what comes after is a query
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cat");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); //The default method is GET, but you still want to put it in
            connection.setReadTimeout(30000);
            connection.setRequestProperty("User-Agent", "Chrome");
            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + connection.getResponseMessage());

            if(responseCode != 200) {
                System.out.println("Error reading webpage");
                System.out.println(connection.getResponseCode());
                return;
            }

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
                System.out.println(line);
            }
            inputReader.close();
        }    catch(MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
