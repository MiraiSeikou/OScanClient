/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.dto;

import com.google.gson.Gson;
import com.miraiseikou.core.model.Maquina;
import com.miraiseikou.util.HttpManager;

/**
 *
 * @author TheHeftier
 */
public class MaquinaDTO {
    private final HttpManager manager = new HttpManager();
    private Maquina maquina = new Maquina();
    public MaquinaDTO(Maquina maquina) {
        this.maquina = maquina;
        init();
    }

    private void init() {
        manager.Read("api/Maquinas/" + maquina.getSerial());
    }
    
    public void create() {
        manager.Create("api/Maquinas/", maquina);
    }
    
    public Maquina read() {
        Gson g = new Gson();
        return g.fromJson(manager.getResponse(), Maquina.class);
    }
    
    public int getStatus() {
        return manager.getStatus();
    }
    
}
