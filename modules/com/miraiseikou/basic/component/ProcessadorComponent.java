/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic.component;

import com.miraiseikou.core.Component;

/**
 *
 * @author jvlima
 */
public class ProcessadorComponent extends Component {

    public ProcessadorComponent(int time, String route) {
        super(time, route);
    }

    @Override
    protected Object collect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
