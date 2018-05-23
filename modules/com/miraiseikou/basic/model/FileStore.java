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
 * @author jvlima
 */
public class FileStore extends Component {
    private int Id;
    private long Total;
    private long Available;
    private Timestamp Momentum;

    public FileStore(String route) {
        super(route);
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
        Available = Collector.getInstance().getHDAvailable();
        Total = Collector.getInstance().getHDTotal();
        Momentum = new Timestamp(System.currentTimeMillis());
    }
}
