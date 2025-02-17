package com.addcycle.palainfo.utils;

import com.addcycle.palainfo.Main;
import com.addcycle.palainfo.utils.errors.ErrorHandler;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RequestsUtil {
    public JsonNode sendPost(String url) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.post(url).header("Authorization", "Bearer " + Main.key).asJson();
        ErrorHandler handler = new ErrorHandler();
        handler.handle(response);
        return response.getBody();
    }

    public JsonNode sendGet(String url) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest.get(url).header("Authorization", "Bearer " + Main.key).asJson();
        ErrorHandler handler = new ErrorHandler();
        handler.handle(response);
        return response.getBody();
    }
}
