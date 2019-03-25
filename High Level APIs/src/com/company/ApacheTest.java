package com.company;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BufferedHeader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApacheTest {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://example.org");
        request.addHeader("User-Agent", "Chrome");

        CloseableHttpResponse response = httpClient.execute(request);
        
        try {
            System.out.println("Response Code = " + response.getStatusLine().getStatusCode());
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()) );

            String line;
            while((line = inputReader.readLine()) !=null) {
                System.out.println(line);
            }

            inputReader.close();
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        } finally {
            response.close();

        }
    }
}

//Now, we configure the request object, not the HTTPClient
//Line 21 sends off the request
//Now, when using the CloseableHttpResponse
//it is HIGHLY recommended that you close it, as it is seen
//in line 36 in the finally block
//Otherwise, system resources may not be released correctly
