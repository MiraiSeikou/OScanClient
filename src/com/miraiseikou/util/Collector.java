/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miraiseikou.util;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.NetworkIF;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

/**
 *
 * @author jvlima
 */
public class Collector {
    private final SystemInfo si = new SystemInfo();
    private final OperatingSystem os = si.getOperatingSystem();
    private final HardwareAbstractionLayer hal = si.getHardware();
    
    private static Collector instance;
    private Collector() {}
    
    public static Collector getInstance() {
        if (instance == null) {
            instance = new Collector();
        }
        return instance;
    }
    
    public String getMacAddres() {
        String ma = "";
        for (NetworkIF networkIF : hal.getNetworkIFs()) {
            ma = networkIF.getMacaddr();
        }
        return ma;
    }
    
    public long getAvailableMemory() {
        return hal.getMemory().getAvailable();
    }
    
    public long getTotalMemory() {
        return hal.getMemory().getTotal();
    }
    
    public long getSwapUsed() {
        return hal.getMemory().getSwapUsed();
    }
    
    public long getSwapTotal() {
        return hal.getMemory().getSwapTotal();
    }
    
    public int getHDCount() {
        return os.getFileSystem().getFileStores().length;
    }
    
    public long getHDTotal(int i) {
        return os.getFileSystem().getFileStores()[i].getTotalSpace();
    }
    
    public long getHDTotal() {
        long total = 0;
        for (OSFileStore fileStore : os.getFileSystem().getFileStores()) {
            total += fileStore.getTotalSpace();
        }
        return total;
    }
    
    public long getHDAvailable(int i) {
        return os.getFileSystem().getFileStores()[i].getUsableSpace();
    }
    
    public long getHDAvailable() {
        long total = 0;
        for (OSFileStore fileStore : os.getFileSystem().getFileStores()) {
            total += fileStore.getUsableSpace();
        }
        return total;
    }
    
    public double getCpuLoad() {
        return hal.getProcessor().getSystemCpuLoad();
    }
    
    public String getOSName() {
        return os.getFamily() + " " + os.getVersion().getVersion();
    }
    
    public String getHostName() {
        return os.getNetworkParams().getHostName();
    }
    
}
