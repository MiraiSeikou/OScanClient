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
    private int id;
    private String nome;
    private String os;
    private String serial;
    private String macAddr;
    private int idUsuario;

    public Maquina() {
        nome = new SystemInfo().getOperatingSystem().getNetworkParams().getHostName();
        os = new SystemInfo().getOperatingSystem().getFamily();
        serial = new SystemInfo().getHardware().getComputerSystem().getSerialNumber();
    }

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
     * @return the os
     */
    public String getOs() {
        return os;
    }

    /**
     * @param os the os to set
     */
    public void setOs(String os) {
        this.os = os;
    }

    /**
     * @return the serial
     */
    public String getSerial() {
        return serial;
    }

    /**
     * @param serial the serial to set
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the macAddr
     */
    public String getMacAddr() {
        return macAddr;
    }

    /**
     * @param macAddr the macAddr to set
     */
    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr;
    }
}
