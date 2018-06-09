/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.slack;

import com.google.gson.Gson;
import com.miraiseikou.core.dto.UsuarioDTO;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvlima
 */
public class SlackIntegration {
    
    public void Create(Object pojo) {
        try {
            URL url = new URL("https://hooks.slack.com/services/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");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            Gson gson = new Gson();
            try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()))) {
                out.write(gson.toJson(pojo));
            }
            con.getResponseCode();
            con.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(UsuarioDTO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
