/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core;

/**
 *
 * @author jvlima
 */
public abstract class Component {
    private int idMaquina;
    private final String route;

    public Component(String route) {
        this.route = route;
    }
    
    /**
     * @return the idMaquina
     */
    public int getIdMaquina() {
        return idMaquina;
    }

    /**
     * @param idMaquina the idMaquina to set
     */
    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getRoute() {
        return route;
    }
    
}
