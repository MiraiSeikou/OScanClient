/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core;

/**
 *
 * @author jvlima
 */
public class Monitor {
    private final Module module;
    public Monitor(Module module) {
        this.module = module;
    }
    
    public void start() {
        module.getComponents().forEach((component) -> {
            component.start();
        });
    }
    
    public void stop() {
        module.getComponents().forEach((component) -> {
            component.stop();
        });
    }
    
    public void restart() {
        module.getComponents().forEach((component) -> {
            component.restart();
        });
    }
    
}
