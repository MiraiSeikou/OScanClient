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
 * Objeto de transferência de dados.
 * Classe intermediária com as principais definições para a transferência
 * a partir da REST API
 * @author TheHeftier
 */
public class MaquinaDTO {
    private final HttpManager manager = new HttpManager();
    private Maquina maquina = new Maquina();
    
    public MaquinaDTO(Maquina maquina) {
        this.maquina = maquina;
        init();
    }

    public MaquinaDTO(int id) {
        manager.Read("api/Maquinas/id/"+id);
    }

    private void init() {
        manager.Read("api/Maquinas/serial/" + maquina.getSerial() + "/" + maquina.getIdUsuario());
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
