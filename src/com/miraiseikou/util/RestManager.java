/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author jvlima
 */
public class RestManager {
    private final String host = "http://oscanwebapi.azurewebsites.net/";
    private String route;
    private int statusCode;
    private String body;
    private GsonBuilder gbuilder;
    private Gson gson;
    
    public RestManager() {
        this.statusCode = 0;
        this.body = "";
        gbuilder = new GsonBuilder();
        gbuilder.setLenient();
        gson = gbuilder.create();
    }
    
    public RestManager(String route) {
        this.route = route;
        this.statusCode = 0;
        this.body = "";
        gbuilder = new GsonBuilder();
        gbuilder.setLenient();
        gson = gbuilder.create();
    }
    
    public void postRequest(Object pojo) {
        String path = host+getRoute();
        try (CloseableHttpClient client = HttpClients.createDefault()){
            HttpPost postRequest = new HttpPost(path);
            StringEntity input = new StringEntity(gson.toJson(pojo));
            input.setContentType("application/json");
            postRequest.setEntity(input);
            CloseableHttpResponse response = client.execute(postRequest);
            
            statusCode = response.getStatusLine().getStatusCode();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            String output;
            while ((output = br.readLine()) != null) {
                body += (output);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } 
    }
    
    public void getRequest() {
        String path = host+getRoute();
        try(CloseableHttpClient client = HttpClients.createDefault()){
            HttpGet getRequest = new HttpGet(path);
            getRequest.addHeader("accept", "application/json");
            CloseableHttpResponse response = client.execute(getRequest);
            statusCode = response.getStatusLine().getStatusCode();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            String output;
            while ((output = br.readLine()) != null) {
                body += (output);
            }
            EntityUtils.consume(response.getEntity());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public <T> T converter(Type typeOfT) {
        return (T) gson.fromJson(body, typeOfT);
    }
    
    public <T> T converter(Class<T> classOfT) {
        return (T) gson.fromJson(body, classOfT);
    }

    /**
     * @return the route
     */
    public String getRoute() {
        return route;
    }

    /**
     * @param route the route to set
     */
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }
    
}
