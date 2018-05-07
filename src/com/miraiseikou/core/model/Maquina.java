/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.model;

import com.miraiseikou.util.Collector;

/**
 *
 * @author jvlima
 */
public class Maquina {
    private static Maquina instance;
    private int Id;
    private String Nome;
    private String OSName;
    private String MacAddr;
    private int IdUsuario;
    
    private Maquina() {
        Nome = Collector.getInstance().getHostName();
        OSName = Collector.getInstance().getOSName();
        MacAddr = Collector.getInstance().getMacAddres();
    }
    
    public static Maquina getInstance() {
        if (instance == null) {
            instance = new Maquina();
        }
        return instance;
    }

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
     * @return the OSName
     */
    public String getOSName() {
        return OSName;
    }

    /**
     * @param OSName the OSName to set
     */
    public void setOSName(String OSName) {
        this.OSName = OSName;
    }

    /**
     * @return the MacAddr
     */
    public String getMacAddr() {
        return MacAddr;
    }

    /**
     * @param MacAddr the MacAddr to set
     */
    public void setMacAddr(String MacAddr) {
        this.MacAddr = MacAddr;
    }

    /**
     * @return the IdUsuario
     */
    public int getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param IdUsuario the IdUsuario to set
     */
    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

}
