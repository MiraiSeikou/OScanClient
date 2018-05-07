/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic.component;

import com.miraiseikou.basic.model.Memoria;
import com.miraiseikou.core.Component;
import com.miraiseikou.core.model.Padrao;
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
    protected Padrao collect() {
        Memoria memoria = new Memoria();
        memoria.setTotal(si.getHardware().getMemory().getTotal());
        memoria.setAvailable(si.getHardware().getMemory().getAvailable());
        memoria.setSwapTotal(si.getHardware().getMemory().getSwapTotal());
        memoria.setSwapAvailable(si.getHardware().getMemory().getSwapUsed());
        memoria.setMomentum(new Timestamp(System.currentTimeMillis()));
        memoria.setIdMaquina(1);
        return memoria;
    }
    
}
