package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


//Just another way of doing Main2
//Except there is more things you can do, like writing data
//between lines 20 and line 26
public class Main3 {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.org");
            URLConnection urlConnection = url.openConnection();    // Step 1 that I mentioned in Main2
            urlConnection.setDoOutput(true);
            //It's important to note that we should
            //do an configuration such as reading (default)
            //or writing BEFORE we do the connect method
            //Otherwise, there will be an error
            urlConnection.connect();                                //Step 2 that I  mentioned in Main 2

            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));


            String line = "";
            while (line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();

        }    catch(MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }



}
