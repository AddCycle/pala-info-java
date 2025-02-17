package com.addcycle.palainfo.presentation.rest;

import com.addcycle.palainfo.Main;
import com.addcycle.palainfo.utils.RequestsUtil;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import jakarta.ws.rs.core.Response;

public class StatusResource {
    public static RequestsUtil requestsUtil = new RequestsUtil();
    public static void getServerStatus() throws UnirestException {
        String url = "https://api.paladium.games/v1/status";
        JsonNode json = requestsUtil.sendPost(url);
        JsonNode jsonResponse = requestsUtil.sendGet(url);
        System.err.println(jsonResponse.getObject().get("type").toString());
        System.err.println(jsonResponse.getObject().get("message").toString());
        String response = jsonResponse.getObject().toString();
        System.out.println(response);
    }
}
