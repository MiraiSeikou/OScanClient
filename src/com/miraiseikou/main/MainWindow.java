/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.main;

import com.miraiseikou.basic.BasicModule;
import com.miraiseikou.util.RestManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author jvlima
 */
public class MainWindow extends JFrame implements ActionListener{
    JLabel l1, l2, l3;
    JTextField tf1;
    JButton btn1;
    JPasswordField p1;

    public MainWindow(){
        init();
    }

    private void init() {
        l1 = new JLabel("OScan");
        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Usuário: ");
        l3 = new JLabel("Senha: ");
        tf1 = new JTextField();
        p1 = new JPasswordField();
        btn1 = new JButton("Login");

        l1.setBounds(20, 30, 400, 30);
        l2.setBounds(20, 70, 200, 30);
        l3.setBounds(20, 110, 200, 30);
        tf1.setBounds(90, 70, 200, 30);
        p1.setBounds(90, 110, 200, 30);
        btn1.setBounds(20, 160, 270, 30);
        
        btn1.addActionListener(this);

        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(p1);
        add(btn1);
        
        setSize(330, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        String name = tf1.getText();
        String pass = String.copyValueOf(p1.getPassword());
        
        if (name.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(this, "Campos não preenchidos",
                        "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append("api/Usuarios/").append(name).append("/").append(pass);
            RestManager manager = new RestManager(builder.toString());
            try {
                String url = builder.toString();
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                // optional default is GET
                con.setRequestMethod("GET");

                if (con.getResponseCode() == 200) {
                    MainTray mainTray = new MainTray(new BasicModule());
                    mainTray.init();
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Usuário e/ou senha incorretos",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    
}
