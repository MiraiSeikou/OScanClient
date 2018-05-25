package com.miraiseikou.core.model;

/**
 * Classe que representa um usuário do sistema
 * @author TheHeftier
 */
public class Usuario {
    private int Id;
    private String Email;
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
    public String getEmail() {
        return Email;
    }

    /**
     * @param email the nomeUsuario to set
     */
    public void setEmail(String email) {
        this.Email = email;
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
