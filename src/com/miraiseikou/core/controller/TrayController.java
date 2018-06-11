package com.miraiseikou.core.controller;

import com.miraiseikou.core.Module;
import com.miraiseikou.core.dto.AssinaturaDTO;
import com.miraiseikou.core.dto.MaquinaDTO;
import com.miraiseikou.core.model.Assinatura;
import com.miraiseikou.core.model.Maquina;
import com.miraiseikou.core.model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TheHeftier
 */
public class TrayController {
    /**
     * Classe do tipo Module que receberá uma subclasse do mesmo tipo
     * de acordo com a assinatura do usuário
     */
    private Module module;
    
    /**
     * Construtor da classe
     * Faz uma chamada ao método privado init()
     * @param usuario - Referêcia ao usuário que foi autenticado.
     */
    public TrayController(Usuario usuario) {
        init(usuario);
    }
    
    /**
     * Método é chamado junto com o construtor para evitar chamada problemática
     * @param usuario - recebe a referência a partir do construtor
     */
    private void init(Usuario usuario) {
        Maquina maquina = new Maquina();
        maquina.setIdUsuario(usuario.getId());
        MaquinaDTO mdto = new MaquinaDTO(maquina);
        
        if (mdto.getStatus() != 200) {
            mdto.create();
            maquina = mdto.read();
        } else {
            maquina = mdto.read();
        }
        
        try {
            /**
             * Define a assinatura da máquina
             */
            Assinatura assinatura = new Assinatura();
            assinatura.setId(maquina.getIdAssinatura());
            AssinaturaDTO adto = new AssinaturaDTO(assinatura);
            /**
             * Selecionando o pacote em que está localizado a classe da assinatura 
             * do usuário. É utilizado o conceito de reflexão para definir esta em
             * tempo de execução.
             */
            module = (Module)Class.forName(adto.read().getPacote()).newInstance();
            module.getMonitor().setMaquina(maquina);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(TrayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Representa a ação do botão Iniciar do menu
     */
    public void start() {
        module.start();
    }
    
    /**
     * Representa a ação do botão Parar do menu
     */
    public void stop() {
        module.stop();
    }
    
    /**
     * Representa a ação do botão Reiniciar do menu
     */
    public void restart() {
        module.restart();
    }
    
}
