/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core;

import javax.swing.Timer;

/**
 *
 * @author jvlima
 */
public abstract class Module {
    private Monitor monitor;
    private Timer timer;
    
    public Module() {
        init();
    }
    
    private void init() {
        this.monitor = loadMonitor();
        timer = new Timer(1000, (e) -> {
            monitor.run();
        });
    }
    
    public abstract Monitor loadMonitor();
    
    public final void start() {
        timer.start();
    }
    
    public final void stop() {
        timer.stop();
    }
    
    public final void restart() {
        timer.restart();
    }

    public Monitor getMonitor() {
        return monitor;
    }
    
    
}
