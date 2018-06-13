/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core.view;

import com.miraiseikou.core.controller.TrayController;
import com.miraiseikou.core.model.Usuario;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvlima
 */
public class TrayView {
    private TrayIcon trayIcon;
    TrayController controller;
    public TrayView(Usuario usuario) {
        controller = new TrayController(usuario);
    }
    
    public void init() {
        trayIcon = new TrayIcon(createImage("/images/Design_3.png"), "OScan");
        trayIcon.setImageAutoSize(true);
        PopupMenu menu = new PopupMenu();
        MenuItem start = new MenuItem("Iniciar");
        MenuItem stop = new MenuItem("Parar");
        MenuItem restart = new MenuItem("Reiniciar");
        MenuItem settings = new MenuItem("Configurações");
        MenuItem exit = new MenuItem("Sair");
        
        start.addActionListener((e) -> {
            controller.start();
            trayIcon.setImage(createImage("/images/Design_1.png"));
        });
        stop.addActionListener((e) -> {
            controller.stop();
            trayIcon.setImage(createImage("/images/Design_2.png"));
        });
        restart.addActionListener((e) -> {
            trayIcon.setImage(createImage("/images/Design_2.png"));
            controller.restart();
            trayIcon.setImage(createImage("/images/Design_1.png"));
        });
        settings.addActionListener((e) ->{
            SettingsView settingsView = new SettingsView();
            settingsView.setVisible(true);
        });
        exit.addActionListener((e) -> {
            System.exit(0);
        });
        menu.add(start);
        menu.add(stop);
        menu.add(restart);
        menu.add(settings);
        menu.add(exit);
        trayIcon.setPopupMenu(menu);
        SystemTray tray = SystemTray.getSystemTray();
        try {
            tray.add(trayIcon);
        } catch (AWTException ex) {
            Logger.getLogger(TrayView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Image createImage(String path) {
        URL resource = this.getClass().getResource(path);
        return Toolkit.getDefaultToolkit().createImage(resource);
    }
    
}
