/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.dto;

import com.miraiseikou.core.Component;
import com.miraiseikou.util.HttpManager;

/**
 *
 * @author jvlima
 */
public class ComponentDTO {
    private HttpManager manager = new HttpManager();
    
    public void create(String route, Component component) {
        manager.Create(route, component);
    }
}
