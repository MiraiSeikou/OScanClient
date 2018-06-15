/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.advanced;

import com.miraiseikou.model.FileStore;
import com.miraiseikou.model.Memoria;
import com.miraiseikou.model.Processador;
import com.miraiseikou.core.Component;
import com.miraiseikou.core.Module;
import com.miraiseikou.core.Monitor;
import java.util.ArrayList;

/**
 *
 * @author jvlima
 */
public class AdvancedModule extends Module {
    /**
     * Implementação do método loadMonitor.
     * É carregada com a lista de componentes que será monitorada neste módulo
     * @return Monitor - Representa uma intância de monitor.
     */
    @Override
    public Monitor loadMonitor() {
        Monitor monitor = new Monitor();
        ArrayList<Component> components = new ArrayList<>();
        components.add(new Processador("api/Processadors"));
        components.add(new Memoria("api/Memorias"));
        components.add(new FileStore("api/FileStores"));
        monitor.setComponents(components);
        return monitor;
    }
}