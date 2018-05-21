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
public class Usuario {
    private int Id;
    private String NomeUsuario;
    private String Senha;
    private String Nome;
    private int IdAssinatura;

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
     * @return the nomeUsuario
     */
    public String getNomeUsuario() {
        return NomeUsuario;
    }

    /**
     * @param nomeUsuario the nomeUsuario to set
     */
    public void setNomeUsuario(String nomeUsuario) {
        this.NomeUsuario = nomeUsuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return Senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.Senha = senha;
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
     * @return the idAssinatura
     */
    public int getIdAssinatura() {
        return IdAssinatura;
    }

    /**
     * @param idAssinatura the idAssinatura to set
     */
    public void setIdAssinatura(int idAssinatura) {
        this.IdAssinatura = idAssinatura;
    }
}
