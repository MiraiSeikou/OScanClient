/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.basic.component;

import com.miraiseikou.basic.model.Disco;
import com.miraiseikou.core.Component;
import com.miraiseikou.core.model.Padrao;
import com.miraiseikou.util.Collector;
import java.sql.Timestamp;

/**
 *
 * @author jvlima
 */
public class DiscoComponent extends Component {

    public DiscoComponent(int time) {
        super(time, "api/Discoes");
    }
    
    @Override
    protected Padrao collect() {
        Disco disco = new Disco();
        disco.setAvailable(Collector.getInstance().getHDAvailable());
        disco.setTotal(Collector.getInstance().getHDTotal());
        disco.setMomentum(new Timestamp(System.currentTimeMillis()));
        return disco;
    }
    
}
