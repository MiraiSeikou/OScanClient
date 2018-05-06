/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic;

import com.miraiseikou.basic.component.DiscoComponent;
import com.miraiseikou.basic.component.MemoriaComponent;
import com.miraiseikou.basic.component.ProcessadorComponent;
import com.miraiseikou.core.Component;
import com.miraiseikou.core.Module;

/**
 *
 * @author jvlima
 */
public class BasicModule extends Module {

    public BasicModule() {
        init();
    }

    private void init() {
        addComponent(new MemoriaComponent(1000));
        addComponent(new DiscoComponent(1000));
        addComponent(new ProcessadorComponent(1000));
    }
}
