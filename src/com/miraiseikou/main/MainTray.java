/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.main;

import com.miraiseikou.core.Module;
import com.miraiseikou.core.Monitor;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jvlima
 */
public class MainTray {

    private TrayIcon trayIcon = null;
    private final Monitor monitor;

    public MainTray(Module module) {
        this.monitor = new Monitor(module);
    }

    public void init() {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().getImage("res/images/Design_3.png");

        PopupMenu popup = new PopupMenu();
        
        MenuItem startItem = new MenuItem("Iniciar");
        MenuItem stopItem = new MenuItem("Parar");
        MenuItem restartItem = new MenuItem("Reiniciar");
        MenuItem settingsItem = new MenuItem("Configurações");
        MenuItem exitItem = new MenuItem("Exit");
        
        startItem.addActionListener((e) -> {
            trayIcon.setImage(Toolkit.getDefaultToolkit().getImage("res/images/Design_1.png"));
        });
        stopItem.addActionListener((e) -> {
            trayIcon.setImage(Toolkit.getDefaultToolkit().getImage("res/images/Design_2.png"));
        });
        restartItem.addActionListener((e) -> {
            trayIcon.setImage(Toolkit.getDefaultToolkit().getImage("res/images/Design_2.png"));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainTray.class.getName()).log(Level.SEVERE, null, ex);
            }
            trayIcon.setImage(Toolkit.getDefaultToolkit().getImage("res/images/Design_1.png"));
        });
        settingsItem.addActionListener((e) -> {
            SettingsWindow settings = new SettingsWindow();
            settings.setVisible(true);
        });
        exitItem.addActionListener((e) -> {
            System.exit(0);
        });
        
        popup.add(startItem);
        popup.add(stopItem);
        popup.add(restartItem);
        popup.add(settingsItem);
        popup.add(exitItem);

        trayIcon = new TrayIcon(image, "OScanTray", popup);

        trayIcon.setImageAutoSize(true);

        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.err.println("TrayIcon could not be added.");
        }
    }
    
}
