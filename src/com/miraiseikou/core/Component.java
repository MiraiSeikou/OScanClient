/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core;

/**
 * Classe que representa um componente a ser monitorado.
 * Todos os componentes que precisam ser monitorados herdam dessa classe
 * @author TheHeftier
 */
public abstract class Component {
    /**
     * Atributo que representa uma referência ao campo IdMaquina do banco de dados
     */
    private int IdMaquina;
    /**
     * Atributo que representa a rota do componente na API REST
     * ex: api/Processadores/
     */
    private final String route;
    
    /**
     * Método abstrato que tem o papel de fazer a coleta dos dados
     * deve ser implementado pelo usuário da classe
     */
    public abstract void collect();
    /**
     * Construtor da classe Component
     * @param route representa a rota que será utilizada na API REST
     */
    public Component(String route) {
        this.route = route;
    }
    
    /**
     * @return IdMaquina retorna o id da maquina
     */
    public int getIdMaquina() {
        return IdMaquina;
    }

    /**
     * @param idMaquina define o id da maqua
     */
    public void setIdMaquina(int idMaquina) {
        this.IdMaquina = idMaquina;
    }
    
    /**
     * 
     * @return retorna a rota do componente que foi definida no construtor
     */
    public String getRoute() {
        return route;
    }
    
}
