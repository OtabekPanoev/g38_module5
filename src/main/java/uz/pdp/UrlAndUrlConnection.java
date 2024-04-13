package uz.pdp;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlAndUrlConnection {
    public static void main(String[] args) throws IOException {


        URL url = new URL("https://kun.uz");
        URLConnection urlConnection = url.openConnection();

//        urlConnection.se


    }
}
