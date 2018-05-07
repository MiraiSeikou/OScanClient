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
public class Memoria extends Padrao {
    private int Id;
    private long Total;
    private long Available;
    private long SwapTotal;
    private long SwapAvailable;
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
     * @return the Total
     */
    public long getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(long Total) {
        this.Total = Total;
    }

    /**
     * @return the Available
     */
    public long getAvailable() {
        return Available;
    }

    /**
     * @param Available the Available to set
     */
    public void setAvailable(long Available) {
        this.Available = Available;
    }

    /**
     * @return the SwapTotal
     */
    public long getSwapTotal() {
        return SwapTotal;
    }

    /**
     * @param SwapTotal the SwapTotal to set
     */
    public void setSwapTotal(long SwapTotal) {
        this.SwapTotal = SwapTotal;
    }

    /**
     * @return the SwapAvailable
     */
    public long getSwapAvailable() {
        return SwapAvailable;
    }

    /**
     * @param SwapAvailable the SwapAvailable to set
     */
    public void setSwapAvailable(long SwapAvailable) {
        this.SwapAvailable = SwapAvailable;
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
