/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.model;

import oshi.SystemInfo;

/**
 *
 * @author TheHeftier
 */
public class Maquina {
    private int Id;
    private String Nome;
    private String OSName;
    private String Serial;
    private String MacAddr;
    private int IdUsuario;

    public Maquina() {
        Nome = new SystemInfo().getOperatingSystem().getNetworkParams().getHostName();
        OSName = new SystemInfo().getOperatingSystem().getFamily();
        Serial = new SystemInfo().getHardware().getComputerSystem().getSerialNumber();
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
        return Nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.Nome = nome;
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

    /**
     * @return the macAddr
     */
    public String getMacAddr() {
        return MacAddr;
    }

    /**
     * @param macAddr the macAddr to set
     */
    public void setMacAddr(String macAddr) {
        this.MacAddr = macAddr;
    }
}
