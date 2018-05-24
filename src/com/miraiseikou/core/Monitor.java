/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core;

import com.miraiseikou.core.dto.ComponentDTO;
import com.miraiseikou.core.model.Maquina;
import java.util.List;

/**
 * Classe que centraliza o monitoramento dos componentes
 * Possui uma lista de componentes que serão monitorados
 * 
 * @author TheHeftier
 */
public final class Monitor {
    /**
     * Lista de componentes a ser monitorados
     */
    private List<Component> components;
    /**
     * Referência da maquina que está sendo monitorada.
     */
    private Maquina maquina;
    
    public final void send() {
        getComponents().forEach((component) -> {
            component.setIdMaquina(maquina.getId());
            component.collect();
            ComponentDTO dto = new ComponentDTO();
            dto.create(component.getRoute(), component);
        });
    }

    /**
     * @return components - a lista de componentes que está definida 
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * @param components define components - lista de componentes que serão monitorados
     */
    public void setComponents(List<Component> components) {
        this.components = components;
    }
    
    /**
     * 
     * @return retorna maquina - Referência da maquina que está sendo monitorada.
     */
    public Maquina getMaquina() {
        return maquina;
    }
    
    /**
     * 
     * @param maquina - Define a referência da maquina que está sendo monitorada.
     */
    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }
}
