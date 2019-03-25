package com.company;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            //A URI with an absolute path
           // URI uri = new URI("http://username:password@myserver.com:5000/catalogue/phones?os=android#samsung");

          //  URI baseUri = new URI("http://username:password@myserver.com:5000");
           // URI uri = new URI("/catalogue/phones?os=android#samsung");
            //resolve just attaches the two URIs together
          //  URI resolvedUri = baseUri.resolve(uri);
            //Converting URI to URL
         //   URL url = resolvedUri.toURL();
         //   System.out.println("URL = " + url);
            //note: the URI only has to be valid when being converted
            //to a URL (Which has an absolute location)

          /*  System.out.println("Scheme = " + uri.getScheme());
            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
            System.out.println("User info = " + uri.getUserInfo());
            System.out.println("Host = " + uri.getHost());
            System.out.println("Port = " + uri.getPort());
            System.out.println("Path = " + uri.getPath());
            System.out.println("Query = " + uri.getQuery());
            System.out.println("Fragment = " + uri.getFragment());*/

            //In a real world application, you want
            // do public static final String
            //and use a Constant for your baseURI
            //look at how long that statement is....
            URI baseUri = new URI("http://username:password@myserver.com:5000");
            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
            URI uri2 = new URI("/catalogue/tvs?manufacturer=samsung");
            URI uri3 = new URI("/stores/locations?zip=12345");

            URI resolvedUri1 = baseUri.resolve(uri1);
            URI resolvedUri2 = baseUri.resolve(uri2);
            URI resolvedUri3 = baseUri.resolve(uri3);

            URL url1 = resolvedUri1.toURL();
            System.out.println("URL 1 = " + url1);
            URL url2 = resolvedUri2.toURL();
            System.out.println("URL 2 = " + url2);
            URL url3 = resolvedUri3.toURL();
            System.out.println("URL 3 = " + url3);

            //You can also receive information
            //about your relative URI using
            //relativize();
            URI relativizedURI = baseUri.relativize(resolvedUri2);
            System.out.println("Relative URI = " + relativizedURI);

        } catch(URISyntaxException e) {
            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch(MalformedURLException e) {
            System.out.println("URL Malformed: " + e.getMessage());
        }



    }
}
//URI vs. URL
//URI is an identifier that might not provide enough information
//to access the resource it identifies
//URL is an identifer that includes information about how to access
//the resource it identifies
//URI can specify a relative path
//URL has to be an absolute path
//Easy to convert between them
//The recommended practice is to use a URI until
//you actually want to access a resource and then convert
//to URL
//Sometimes,you'll just start off with a URL right off the bat
//Personally, this sounds way better to me

//with low level APIs, we used the following classes:
//Socket, ServerSocket, and DatagramSocket

//When working with high-level API
//we'll use the following classes: URI, URL, URLConnection, and HttpURLConnection

//On URIs. They have nine components:
//1. Scheme
//2. Scheme-specific part
//3. authority
//4.user-info
//5. host
//6. port
//7. path
//8. query
//9. fragment
//URIs that specify a scheme are called absolute URIs
//Otherwise, it's a relative URI
