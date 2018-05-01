/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jvlima
 */
public abstract class Module {
    private final List<Component> components;

    public Module() {
        this.components = new ArrayList<>();
    }
    
    public void addComponent(Component component) {
        components.add(component);
    }
    
    public void addComponent(int index, Component component) {
        components.add(index, component);
    }
    
    public void removeComponent(Component component) {
        components.remove(component);
    }
    
    public void removeComponent(int index) {
        components.remove(index);
    }
    
    public int size() {
        return components.size();
    }
    
    public void clear() {
        components.clear();
    }
    
    public Component get(int index) {
        return components.get(index);
    }
    
    public boolean contains(Component component) {
        return components.contains(component);
    }
    
    public List<Component> getComponents() {
        return components;
    }
    
}
