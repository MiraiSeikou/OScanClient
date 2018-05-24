/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.util;

import com.google.gson.Gson;
import com.miraiseikou.core.dto.UsuarioDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TheHeftier
 */
public class HttpManager {
    private final String baseAddress = "https://oscanwebapi.azurewebsites.net/";
    private int status;
    private String response;
    
    public void Create(String route, Object pojo) {
        try {
            URL url = new URL(baseAddress + route);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            Gson gson = new Gson();
            try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()))) {
                out.write(gson.toJson(pojo));
            }
            status = con.getResponseCode();
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                response = content.toString();
            }
            con.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(UsuarioDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Read(String route) {
        try {
            URL url = new URL(baseAddress + route);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            status = con.getResponseCode();
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                response = content.toString();
            }
            con.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(UsuarioDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }
    
}
