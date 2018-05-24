/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic;

import com.miraiseikou.basic.model.FileStore;
import com.miraiseikou.basic.model.Memoria;
import com.miraiseikou.basic.model.Processador;
import com.miraiseikou.core.Component;
import com.miraiseikou.core.Module;
import com.miraiseikou.core.Monitor;
import java.util.ArrayList;

/**
 * Módulo básico do projeto
 * Herda da classe abstrata Module e representa a assinatura básica no projeto,
 * monitorando Processador, Memoria e HD.
 * @author TheHeftier
 */
public class BasicModule extends Module {
    
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
