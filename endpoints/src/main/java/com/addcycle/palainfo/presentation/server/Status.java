package com.addcycle.palainfo.presentation.server;

import com.addcycle.palainfo.utils.ServerUtil;
import com.addcycle.palainfo.utils.errors.ErrorUtil;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class Status {
    private String java_status;
    private JSONObject faction_status;
    private String launcher_status;
    private String anarchy_status;
    private boolean is_running;

    public Status() throws UnirestException {
        ServerUtil util = new ServerUtil();
        this.is_running = util.getRunningStatus();
        if (this.is_running) {
            this.java_status = util.getJavaStatus();
            this.faction_status = util.getFactionStatus();
            this.launcher_status = util.getLauncherStatus();
            this.anarchy_status = util.getAnarchyStatus();
        }
    }

    public boolean isRunning() {
        return is_running;
    }

    public void printJavaStatus() {
        System.out.println(is_running ? "Java: " + this.java_status : "Serveur Global : Tjrs en maintenace je presume");
    }

    public void printFactionStatus() {
        if (this.faction_status == null) {
            System.err.println("Le server faction est en maintenance : revenez plus tard");
            return;
        }
        for (String faction : this.faction_status.keySet()) {
            System.err.println(faction + " => " + this.faction_status.get(faction));
        }
    }

    public void printLauncherStatus() {
        if (this.launcher_status == null) {
            System.err.println("Le launcher est en maintenace je presume");
            return;
        }
        System.out.println(this.launcher_status);
    }

    public void printAnarchyStatus() {
        if (this.anarchy_status == null) {
            System.err.println("Le serveur anarchy n'est pas accessible je presume");
            return;
        }
        System.out.println(this.anarchy_status);
    }
}
