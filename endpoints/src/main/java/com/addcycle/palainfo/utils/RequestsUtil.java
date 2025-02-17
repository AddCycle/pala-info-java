package com.addcycle.palainfo.utils;

import com.addcycle.palainfo.Main;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import jakarta.ws.rs.core.Response;

public class RequestsUtil {
    public JsonNode sendPost(String url) throws UnirestException {
        return Unirest.post(url).asJson().getBody();
    }

    public JsonNode sendGet(String url) throws UnirestException {
        return Unirest.get(url).header("Authorization", "Bearer " + Main.key).asJson().getBody();
    }
}
