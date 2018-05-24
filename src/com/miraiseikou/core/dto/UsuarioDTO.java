/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.dto;

import com.google.gson.Gson;
import com.miraiseikou.core.model.Usuario;
import com.miraiseikou.util.HttpManager;

/**
 * Objeto de transferência de dados.
 * Classe intermediária com as principais definições para a transferência
 * a partir da REST API
 * @author TheHeftier
 */
public class UsuarioDTO {
    private HttpManager manager = new HttpManager();

    public UsuarioDTO(Usuario usuario) {
        init(usuario);
    }

    private void init(Usuario usuario) {
        StringBuilder builder = new StringBuilder();
        builder.append("api/Usuarios/")
               .append(usuario.getNomeUsuario())
               .append("/")
               .append(usuario.getSenha());
        manager.Read(builder.toString());
    }
    
    public Usuario read() {
        Gson g = new Gson();
        return g.fromJson(manager.getResponse(), Usuario.class);
    }

    public int getStatus() {
        return manager.getStatus();
    }
}
