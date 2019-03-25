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


//You can also read JUST the header information instead of everything from the HTML
//Using subclass HTTPUrlConnection
public class Main4 {

    public static void main(String[] args) {

        try {
            URL url = new URL("http://example.org/somepage.html");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET"); //The default method is GET, but you still want to put it in
            //Other Request Methods are POST, PUT, HEAD, OPTIONS, DELETE, TRACE
            //NOTE:
            //Each HttpURLConnection can only be used to make one request
            //However, the underlying connection may actually persist across
            //connection objects
            connection.setReadTimeout(30000);
            connection.setRequestProperty("User-Agent", "Chrome");
            //Remember if you want to write anything, for example, if
            //you wanted to POST, you have to turn .setDoOutput() to true.
            //And speaking more about post,
            //you have to call the connection.getOutputStream method
            //instead of the getInputStream method

            //The following implicitly calls the .connect() method
            //which is why it's absent from this code
            //In fact, the HttpURLConnection.getInputStream method
            //also implicitly connects
            //So actually, all calls to connect are actually
            //Unnecessary
            //Now, if you include the connect method
            //there's no performance hit because it won't run
            //if there's also a connection made
            int responseCode = connection.getResponseCode();
            System.out.println("Response code: " + connection.getResponseMessage());

            if(responseCode != 200) {
                System.out.println("Error reading webpage");
                System.out.println(connection.getResponseCode());
                return;
                //The above return exits the try block
                //and the code will not go to the catches
                //below
            }

            BufferedReader inputReader = new BufferedReader(
                  new InputStreamReader(connection.getInputStream()));


            String line;
            //This while loop is kind of special
            //notice that we actually set a value to line within
            //the condition and THEN ask whether if it is null or
            //not
            while ((line = inputReader.readLine()) != null) {
                System.out.println(line);
                System.out.println(line);
            }
            inputReader.close();

            //There are also JarURLConnection instances
            //You use it when you want to read or write
            //to a Jar file

//           URLConnection urlConnection = url.openConnection();
//           urlConnection.setDoOutput(true);
//            urlConnection.connect();
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream()));
//
//            //You can also read JUST the header information instead of everything from the HTML
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("------key = " + key);
//                for(String string: value) {
//                    System.out.println("Value = " + value);
//                }
//            }

//            String line = "";
//            while (line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();




        }    catch(MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }



}
