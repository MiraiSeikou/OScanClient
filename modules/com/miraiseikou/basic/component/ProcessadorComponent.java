/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic.component;

import com.miraiseikou.basic.model.Processador;
import com.miraiseikou.core.Component;
import com.miraiseikou.core.model.Padrao;
import com.miraiseikou.util.Collector;
import java.sql.Timestamp;

/**
 *
 * @author jvlima
 */
public class ProcessadorComponent extends Component {

    public ProcessadorComponent(int time) {
        super(time, "api/Processadors");
    }

    @Override
    protected Padrao collect() {
        Processador processador = new Processador();
        processador.setUsage(Collector.getInstance().getCpuLoad());
        processador.setMomentum(new Timestamp(System.currentTimeMillis()));
        processador.setIdMaquina(1);
        return processador;
    }
    
}
