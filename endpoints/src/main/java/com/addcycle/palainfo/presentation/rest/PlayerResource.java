package com.addcycle.palainfo.presentation.rest;

import com.addcycle.palainfo.utils.RequestsUtil;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

public class PlayerResource {
    public static void getPlayerStatus() throws UnirestException {
        RequestsUtil requtil = new RequestsUtil();
        String url = "https://api.paladium.games/v1/paladium/player/profile/DarkWraith004";
        JsonNode json = requtil.sendGet(url);
    }
}
