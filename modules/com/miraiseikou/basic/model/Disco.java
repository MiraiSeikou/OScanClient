/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic.model;

import com.miraiseikou.core.Component;

/**
 *
 * @author jvlima
 */
public class Disco extends Component {

    public Disco(int time, String route) {
        super(time, route);
    }

    @Override
    protected Object collect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
