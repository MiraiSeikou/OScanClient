/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author jvlima
 */
public class RestManager {
    private final String host = "http://oscanapi.azurewebsites.net/";
    private URL path;
    public RestManager(String route) {
        init(route);
    }

    private void init(String route) {
        try {
            path = new URL(host+route);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RestManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void postConnection(Object pojo) {
        StringBuilder sb = new StringBuilder();
        JSONObject obj = new JSONObject(pojo);
        try {
            HttpURLConnection urlConnection = (HttpURLConnection) path.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("Content-Type","application/json");
            try (OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream())) {
                out.write(obj.toString());
            }
            
            int HttpResult = urlConnection.getResponseCode();  
            if(HttpResult == HttpURLConnection.HTTP_OK){  
                try (BufferedReader br = new BufferedReader(new InputStreamReader(  
                        urlConnection.getInputStream(),"utf-8"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                }
                System.out.println(sb.toString());
            }else{  
                System.out.println(urlConnection.getResponseMessage());  
            }
        } catch (IOException ex) {
            Logger.getLogger(RestManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public HttpURLConnection getConnection() {
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) path.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(10000);
            urlConnection.setRequestProperty("Content-Type","application/json");
        } catch (IOException ex) {
            Logger.getLogger(RestManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return urlConnection;
    }
    
}
