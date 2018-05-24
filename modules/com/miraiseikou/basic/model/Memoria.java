/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic.model;

import com.miraiseikou.core.Component;
import com.miraiseikou.util.Collector;
import java.sql.Timestamp;

/**
 *
 * @author TheHeftier
 */
public class Memoria extends Component {
    private int Id;
    private long Total;
    private long Available;
    private long SwapTotal;
    private long SwapAvailable;
    private Timestamp Momentum;

    public Memoria(String route) {
        super(route);
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

    @Override
    public void collect() {
        Available = Collector.getInstance().getAvailableMemory();
        Total = Collector.getInstance().getTotalMemory();
        SwapAvailable = Collector.getInstance().getSwapUsed();
        SwapTotal = Collector.getInstance().getSwapTotal();
        Momentum = new Timestamp(System.currentTimeMillis());
    }
}
