package com.addcycle.palainfo.presentation.model;

public class ServerStatus {
    private boolean isRunning;
    private String status;
    public ServerStatus() {
        this.isRunning = false;
    }

    public boolean init(String status) {
        return isRunning;
    }
}
