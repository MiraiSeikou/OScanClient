/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.model;

/**
 * Classe que representa a assinatura da maquina
 * @author jvlima
 */
public class Assinatura {
    private int Id;
    private String Nome;
    private String Pacote;

    /**
     * @return the id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.Id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.Nome = nome;
    }

    /**
     * @return the pacote
     */
    public String getPacote() {
        return Pacote;
    }

    /**
     * @param pacote the pacote to set
     */
    public void setPacote(String pacote) {
        this.Pacote = pacote;
    }
}
