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
    private JFrame window;
    private Usuario usuario = new Usuario();

    public LoginController(JFrame window) {
        this.window = window;
    }
    
    public void login() {
        if (usuario.getNomeUsuario().equals("") ||
            usuario.getSenha().equals("")) {
            JOptionPane.showMessageDialog(
                window, 
                "Credenciais não preenchidas", 
                "Falha de login", 
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            UsuarioDTO dto = new UsuarioDTO(usuario);
            
            usuario = dto.read();
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
    
    
    public void setTxtUsuario(String txtUsuario) {
        usuario.setNomeUsuario(txtUsuario);
    }
    
    public void setTxtSenha(String txtSenha) {
        usuario.setSenha(txtSenha);
    }
    
}
