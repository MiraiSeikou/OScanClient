/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.controller;

import com.miraiseikou.core.Module;
import com.miraiseikou.core.dto.MaquinaDTO;
import com.miraiseikou.core.model.Assinatura;
import com.miraiseikou.core.model.Maquina;
import com.miraiseikou.core.model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvlima
 */
public class TrayController {
    private Module module;
    
    public TrayController(Usuario usuario) {
        init(usuario);
    }

    private void init(Usuario usuario) {
        Assinatura assinatura = new Assinatura();
        Maquina maquina = new Maquina();
        maquina.setIdUsuario(usuario.getId());
        MaquinaDTO mdto = new MaquinaDTO(maquina);
        
        if (mdto.getStatus() == 200) {
            maquina = mdto.read();
        } else {
            mdto.create();
        }
        
        try {
            module = (Module)Class.forName(assinatura.getPacote()).newInstance();
            module.getMonitor().setMaquina(maquina);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TrayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void start() {
        module.start();
    }

    public void stop() {
        module.stop();
    }

    public void restart() {
        module.restart();
    }
    
}
