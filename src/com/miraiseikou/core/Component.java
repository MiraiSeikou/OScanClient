/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core;

import com.miraiseikou.util.RestManager;
import javax.swing.Timer;

/**
 *
 * @author jvlima
 */
public abstract class Component {
    
    private final int time;
    private final String route;
    private Timer timer;

    public Component(int time, String route) {
        this.time = time;
        this.route = route;
        run();
    }
    
    private void run() {
        timer = new Timer(this.time, (e) -> {
            collect();
            send();
        });
    }
    
    public final void start() {
        if (timer.isRunning()) {
            return;
        }
        timer.start();
    }
    
    public final void stop() {
        if (!timer.isRunning()) {
            return;
        }
        timer.stop();
    }
    
    public final void restart() {
        timer.restart();
    }
    
    protected abstract Object collect();
    
    private void send(){
        Object obj = collect();
        RestManager manager = new RestManager(route);
        manager.postRequest(obj);
    }
    
    public void setTime(int time) {
        timer.setDelay(time);
        restart();
    }
    
    public int getTime() {
        return time;
    }
    
}
