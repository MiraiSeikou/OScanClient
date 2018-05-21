/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core;

import javax.swing.Timer;

/**
 * 
 * @author TheHeftier
 */
public abstract class Module {
    private Monitor monitor;
    private Timer timer;
    
    /**
     * Classe
     */
    public Module() {
        init();
    }
    
    /**
     * Método é chamado junto como construtor para evitar chamada problemática
     */
    private void init() {
        this.monitor = loadMonitor();
        timer = new Timer(1000, (e) -> {
            loadMonitor();
            monitor.send();
        });
    }
    
    /**
     * Método abstratato deve ser definido pelo usuário da classe e deve
     * retornar o monitor que será utilizado pelo módulo
     * @return retorna uma classe do tipo Monitor
     */
    public abstract Monitor loadMonitor();
    
    /**
     * Inicializa o timer que vai rodar atividades agendadas em background
     */
    public final void start() {
        timer.start();
    }
    
    /**
     * Para o o timer que vai rodar atividades agendadas em background
     */
    public final void stop() {
        timer.stop();
    }
    
    /**
     * Reinicia o o timer que vai rodar atividades agendadas em background
     */
    public final void restart() {
        timer.restart();
    }

    /**
     * 
     * @return o tipo monitor definido para o módulo
     */
    public Monitor getMonitor() {
        return monitor;
    }
    
    
}
