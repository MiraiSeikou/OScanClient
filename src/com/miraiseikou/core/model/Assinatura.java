/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.model;

/**
 *
 * @author jvlima
 */
public class Assinatura {
    private int id;
    private String nome;
    private String pacote;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the pacote
     */
    public String getPacote() {
        return pacote;
    }

    /**
     * @param pacote the pacote to set
     */
    public void setPacote(String pacote) {
        this.pacote = pacote;
    }
}
