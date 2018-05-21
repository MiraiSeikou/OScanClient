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
 *
 * @author jvlima
 */
public final class Monitor {
    private List<Component> components;
    private Maquina maquina;
    
    private void send() {
        getComponents().forEach((component) -> {
            component.setIdMaquina(maquina.getId());
            ComponentDTO dto = new ComponentDTO();
            dto.create(component.getRoute(), component);
        });
    }
    
    public final void run() {
        send();
    }

    /**
     * @return the components
     */
    public List<Component> getComponents() {
        return components;
    }

    /**
     * @param components the components to set
     */
    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }
}
