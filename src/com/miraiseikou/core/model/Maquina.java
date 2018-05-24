/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.model;

import com.miraiseikou.util.Collector;

/**
 * Classe que representa a maquina monitora
 * @author TheHeftier
 */
public class Maquina {
    private int Id;
    private String Name;
    private String OSName;
    private String Serial;
    private int IdAssinatura;
    private int IdUsuario;

    public Maquina() {
        Name = Collector.getInstance().getHostName();
        OSName = Collector.getInstance().getFamily();
        Serial = Collector.getInstance().getSerial();
    }

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
        return Name;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.Name = nome;
    }

    /**
     * @return the os
     */
    public String getOSName() {
        return OSName;
    }

    /**
     * @param OSName the os to set
     */
    public void setOSName(String OSName) {
        this.OSName = OSName;
    }

    /**
     * @return the serial
     */
    public String getSerial() {
        return Serial;
    }

    /**
     * @param serial the serial to set
     */
    public void setSerial(String serial) {
        this.Serial = serial;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.IdUsuario = idUsuario;
    }

    public int getIdAssinatura() {
        return IdAssinatura;
    }

    /**
     * @param IdAssinatura the IdAssinatura to set
     */
    public void setIdAssinatura(int IdAssinatura) {
        this.IdAssinatura = IdAssinatura;
    }
}
