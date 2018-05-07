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
    private int Id;
    private String Nome;
    private String Pacote;

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Pacote
     */
    public String getPacote() {
        return Pacote;
    }

    /**
     * @param Pacote the Pacote to set
     */
    public void setPacote(String Pacote) {
        this.Pacote = Pacote;
    }
}
