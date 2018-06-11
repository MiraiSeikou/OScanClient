 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic.model;

import com.miraiseikou.core.Component;
import com.miraiseikou.slack.Payload;
import com.miraiseikou.slack.SlackIntegration;
import com.miraiseikou.util.Collector;
import java.sql.Time;
import java.sql.Timestamp;

/**
 *
 * @author jvlima
 */
public class Processador extends Component {
    private int Id;
    private long VendorFreq;
    private String Name;
    private int LogicalProcessorCount;
    private int PhysicalProcessorCount;
    private Time SystemUptime;
    private double SystemCpuLoad;
    private Timestamp Momentum;

    public Processador(String route) {
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

    /**
     * @return the VendorFreq
     */
    public long getVendorFreq() {
        return VendorFreq;
    }

    /**
     * @param VendorFreq the VendorFreq to set
     */
    public void setVendorFreq(long VendorFreq) {
        this.VendorFreq = VendorFreq;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the LogicalProcessorCount
     */
    public int getLogicalProcessorCount() {
        return LogicalProcessorCount;
    }

    /**
     * @param LogicalProcessorCount the LogicalProcessorCount to set
     */
    public void setLogicalProcessorCount(int LogicalProcessorCount) {
        this.LogicalProcessorCount = LogicalProcessorCount;
    }

    /**
     * @return the PhysicalProcessorCount
     */
    public int getPhysicalProcessorCount() {
        return PhysicalProcessorCount;
    }

    /**
     * @param PhysicalProcessorCount the PhysicalProcessorCount to set
     */
    public void setPhysicalProcessorCount(int PhysicalProcessorCount) {
        this.PhysicalProcessorCount = PhysicalProcessorCount;
    }

    /**
     * @return the SystemUptime
     */
    public Time getSystemUptime() {
        return SystemUptime;
    }

    /**
     * @param SystemUptime the SystemUptime to set
     */
    public void setSystemUptime(Time SystemUptime) {
        this.SystemUptime = SystemUptime;
    }

    /**
     * @return the SystemCpuLoad
     */
    public double getSystemCpuLoad() {
        return SystemCpuLoad;
    }

    /**
     * @param SystemCpuLoad the SystemCpuLoad to set
     */
    public void setSystemCpuLoad(double SystemCpuLoad) {
        this.SystemCpuLoad = SystemCpuLoad;
    }

    @Override
    public void collect() {
        VendorFreq = Collector.getInstance().getVendorFreq();
        Name = Collector.getInstance().getName();
        LogicalProcessorCount = Collector.getInstance().getLogicalProcessorCount();
        PhysicalProcessorCount = Collector.getInstance().getPhysicalProcessorCount();
        SystemCpuLoad = Collector.getInstance().getCpuLoad();
        setMomentum(new Timestamp(System.currentTimeMillis()));
    }
}
