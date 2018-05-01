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
public abstract class Component {
    
    private final int time;
    private Timer timer;

    public Component(int time) {
        this.time = time;
        run();
    }
    
    private void run() {
        timer = new Timer(this.time, (e) -> {
            collect();
            send();
        });
    }
    
    public void start() {
        timer.start();
    }
    
    public void stop() {
        timer.stop();
    }
    
    public void restart() {
        timer.restart();
    }
    
    protected abstract void collect();
    protected abstract void send();
    
}
