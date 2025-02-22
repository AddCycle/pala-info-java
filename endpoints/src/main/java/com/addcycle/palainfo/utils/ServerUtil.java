package com.addcycle.palainfo.utils;

import com.addcycle.palainfo.utils.errors.ErrorUtil;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class ServerUtil {
    private JsonNode server_status;
    String url = "https://api.paladium.games/v1/status";
    public boolean getRunningStatus() throws UnirestException {
        RequestUtil util = new RequestUtil();
        ErrorUtil errorUtil = new ErrorUtil();
        HttpResponse<JsonNode> response = util.getRequest(url);
        JSONObject json = response.getBody().getObject();
        if (response.getBody().getObject().has("type")) {
            errorUtil.displayError(json.getString("type"), json.getString("message"), response.getStatus());
            return false;
        }
        return true;
    }

    public JsonNode getServerStatus() throws UnirestException {
        RequestUtil util = new RequestUtil();
        this.server_status = util.getRequest(url).getBody();
        return server_status;
    }

    public String getJavaStatus() throws UnirestException {
        JSONObject obj = getServerStatus().getObject().getJSONObject("java").getJSONObject("global");
        return obj.getString("status") + ", " + obj.get("players") + " players.";
    }

    public JSONObject getFactionStatus() throws UnirestException {
        return getServerStatus().getObject().getJSONObject("java").getJSONObject("factions");
    }

    public String getLauncherStatus() throws UnirestException {
        JSONObject obj = getServerStatus().getObject().getJSONObject("launcher");
        return "Launcher: " + obj.get("status");
    }

    public String getAnarchyStatus() throws UnirestException {
        JSONObject obj = getServerStatus().getObject().getJSONObject("anarchy");
        return "Anarchy: " + obj.get("status") + ", " + obj.get("players") + " players.";
    }
}
