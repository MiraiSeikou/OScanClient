/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic;

import com.miraiseikou.basic.model.Disco;
import com.miraiseikou.basic.model.Memoria;
import com.miraiseikou.basic.model.Processador;
import com.miraiseikou.core.Component;
import com.miraiseikou.core.Module;
import com.miraiseikou.core.Monitor;
import java.util.ArrayList;

/**
 *
 * @author jvlima
 */
public class BasicModule extends Module {

    @Override
    public Monitor loadMonitor() {
        Monitor monitor = new Monitor();
        ArrayList<Component> components = new ArrayList<>();
        components.add(new Processador("api/Processadors"));
        components.add(new Memoria("api/Memorias"));
        components.add(new Disco("api/Discoes"));
        monitor.setComponents(components);
        return monitor;
    }
}
