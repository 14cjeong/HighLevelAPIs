package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main2 {

    public static void main(String[] args) {

    try {
        URL url = new URL("http://example.org");

        BufferedReader inputStream = new BufferedReader(
           //This opens a connection to the URL
           //And underneath the covers, it will do
           //all of the low level API stuff
           //like creating a socket
           //Thank God for High Level APIs. We can
           //abstract away from doing all of that now
           //So, the method actually returns an input stream
           //That we will read in the while loop (line 28)
            new InputStreamReader(url.openStream()));
            //openstream is also performing two steps:
            //1) open connection to url
            //2) then use url.openConnection method
            //which returns a URLConnection
            //then you get an inputStream from the URLconnection

        String line = "";
        while(line !=null) {
            line = inputStream.readLine();
            System.out.println(line);
        }
        inputStream.close();

    } catch(IOException e) {
        System.out.println("IOException: " + e.getMessage());
    }








    }
}
