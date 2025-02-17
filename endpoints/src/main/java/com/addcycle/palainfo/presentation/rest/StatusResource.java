package com.addcycle.palainfo.presentation.rest;

import com.addcycle.palainfo.Main;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

public class StatusResource {
    public static void status() throws UnirestException {
        String url = "https://api.paladium.games/v1/status";
        HttpResponse<JsonNode> jsonResponse = Unirest.get(url).header("Authorization", "Bearer " + Main.key).asJson();
        System.err.println(jsonResponse.getBody().getObject().get("type").toString());
        String response = jsonResponse.getBody().toString();
        System.out.println(response);
    }
}
