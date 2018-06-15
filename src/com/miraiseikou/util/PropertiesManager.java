/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvlima
 */
public class PropertiesManager {
    private Properties prop = new Properties();
    
    public PropertiesManager() {
        try {
            FileInputStream file = new FileInputStream("res/props/propriedades.properties");
            prop.load(file);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

    public void setProperty(String key, String value) {
        prop.setProperty(key, value);
    }
    
    
}
