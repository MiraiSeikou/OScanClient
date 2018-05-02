/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic.component;

import com.miraiseikou.basic.model.Memoria;
import com.miraiseikou.core.Component;
import java.sql.Timestamp;
import oshi.SystemInfo;

/**
 *
 * @author jvlima
 */
public class MemoriaComponent extends Component {
    private SystemInfo si = new SystemInfo();
    
    public MemoriaComponent(int time) {
        super(time, "api/Memorias");
    }

    @Override
    protected Object collect() {
        Memoria m = new Memoria();
        m.setTotal(si.getHardware().getMemory().getTotal());
        m.setAvailable(si.getHardware().getMemory().getAvailable());
        m.setSwapTotal(si.getHardware().getMemory().getSwapTotal());
        m.setSwapAvailable(si.getHardware().getMemory().getSwapUsed());
        m.setMomentum(new Timestamp(System.currentTimeMillis()));
        return m;
    }
    
}
