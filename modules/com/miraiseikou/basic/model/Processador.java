 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic.model;

import com.miraiseikou.core.model.Padrao;
import java.sql.Timestamp;

/**
 *
 * @author jvlima
 */
public class Processador extends Padrao {
    private int Id;
    private double Usage;
    private Timestamp Momentum; 

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
     * @return the Usage
     */
    public double getUsage() {
        return Usage;
    }

    /**
     * @param Usage the Usage to set
     */
    public void setUsage(double Usage) {
        this.Usage = Usage;
    }

    /**
     * @return the Momentum
     */
    public Timestamp getMomentum() {
        return Momentum;
    }

    /**
     * @param Momentum the Momentum to set
     */
    public void setMomentum(Timestamp Momentum) {
        this.Momentum = Momentum;
    }
}
