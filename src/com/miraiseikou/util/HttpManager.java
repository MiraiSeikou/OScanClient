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
 * Classe Gerenciadora de HTTP 
 * Responsável por fazer as requisições HTTP na REST API
 * @author TheHeftier
 */
public class HttpManager {
    /**
     * Link base do REST API
     */
    private final String baseAddress = "https://oscanwebapi.azurewebsites.net/";
    /**
     * Referência do código de status retornado pela requisição
     */
    private int status;
    /**
     * Referência do corpo retornado pela requisição
     */
    private String response;
    
    /**
     * Método responsável por efetuar POST na REST API
     * @param route - Rota que será utilizada na API
     * @param pojo - Objeto que deve ser serializado e enviado para a REST API
     */
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
    /**
     * Método responsável por efetuar GET na REST API
     * @param route - Rota que será utilizada na API
     */
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
     * @return retorna o status da requisição
     */
    public int getStatus() {
        return status;
    }

    /**
     * @return retorna response - o corpo da requisição
     */
    public String getResponse() {
        return response;
    }
    
}
