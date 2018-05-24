/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.dto;

import com.google.gson.Gson;
import com.miraiseikou.core.model.Assinatura;
import com.miraiseikou.util.HttpManager;

/**
 * Objeto de transferência de dados.
 * Classe intermediária com as principais definições para a transferência
 * a partir da REST API
 * @author TheHeftier
 */
public class AssinaturaDTO {
    private final HttpManager manager = new HttpManager();
    private Assinatura assinatura = new Assinatura();    

    public AssinaturaDTO(Assinatura assinatura) {
        this.assinatura = assinatura;
        init();
    }
    
    private void init() {
        manager.Read("api/Assinaturas/" + this.assinatura.getId());
    }
    
    public Assinatura read() {
        Gson g = new Gson();
        return g.fromJson(manager.getResponse(), Assinatura.class);
    }
}
