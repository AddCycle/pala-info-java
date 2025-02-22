package com.addcycle.palainfo.utils;

import com.addcycle.palainfo.Main;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RequestUtil {
    public HttpResponse<JsonNode> getRequest(String url) throws UnirestException {
        return Unirest.get(url).header("Authorization", "Bearer " +  Main.key).asJson();
    }

    public HttpResponse<JsonNode> postRequest(String url) throws UnirestException {
        return Unirest.post(url).header("Authorization", "Bearer " +  Main.key).asJson();
    }
}
