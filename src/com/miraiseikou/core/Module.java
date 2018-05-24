package com.miraiseikou.core;

import javax.swing.Timer;

/**
 * Classe do projeto que representa um módulo do projeto.
 * Toda nova assinatura que for criada deve ter uma subclasse de Module
 * para representá-la.
 * 
 * @author TheHeftier
 */
public abstract class Module {
    private Monitor monitor;
    private Timer timer;
    
    /**
     * Construtor do Módulo faz uma chamada para o métod privado init().
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
