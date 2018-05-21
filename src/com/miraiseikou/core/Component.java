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
    
    /**
     * 
     * @param route define a rota em que o component será lançado
     */
    public Component(String route) {
        this.route = route;
    }
    
    /**
     * @return the idMaquina retorna o id da maquina
     */
    public int getIdMaquina() {
        return idMaquina;
    }

    /**
     * @param idMaquina define o id da maqua
     */
    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }
    
    /**
     * 
     * @return retorna a rota do component definida no construtor
     */
    public String getRoute() {
        return route;
    }
    
}
