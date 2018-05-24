/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.controller;

import com.miraiseikou.core.dto.UsuarioDTO;
import com.miraiseikou.core.model.Usuario;
import com.miraiseikou.core.view.TrayView;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jvlima
 */
public class LoginController {
    /**
     * Rerência da janela que está chamando o controlador
     */
    private JFrame window;
    /**
     * Instancia do objeto usuário - será utilizado na autenticação
     */
    private Usuario usuario = new Usuario();

    /**
     * Construtor da classe LoginController
     * @param window - recebe a janela que está chamando o controlador
     */
    public LoginController(JFrame window) {
        this.window = window;
    }
    
    /**
     * Método que representa a ação de login utilizada pelo botão
     */
    public void login() {
        /**
         * Verifica se algum dos campos estão em brancos
         * se estiveram, envia uma mensagem de erro.
         */
        if (usuario.getNomeUsuario().equals("") ||
            usuario.getSenha().equals("")) {
            JOptionPane.showMessageDialog(
                window, 
                "Credenciais não preenchidas", 
                "Falha de login", 
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            /**
             * Objeto de transferência de dados de usuario
             */
            UsuarioDTO dto = new UsuarioDTO(usuario);
            
            //Faz requisição na API REST
            usuario = dto.read();
            
            /**
             * Valida o código retornado na requisição
             * Se voltar o código 200(OK), iniciliaza o icone na área
             * Se não manda mensagem de erro
             */
            if (dto.getStatus() == 200) {
                TrayView tray = new TrayView(usuario);
                tray.init();
                window.dispose();
            } else {
                JOptionPane.showMessageDialog(
                    window, 
                    "Credenciais Incorretas", 
                    "Falha de login", 
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
    //Métodos auxiliares
    public void setTxtUsuario(String txtUsuario) {
        usuario.setNomeUsuario(txtUsuario);
    }
    
    public void setTxtSenha(String txtSenha) {
        usuario.setSenha(txtSenha);
    }
    
}
