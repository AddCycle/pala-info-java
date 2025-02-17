package com.addcycle.palainfo.utils.errors;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class ErrorHandler {
    public ErrorHandler() {
    }

    public void handle(HttpResponse<JsonNode> response) {
        switch (response.getBody().getObject().get("type").toString()) {
            case "API_ERROR" -> System.out.println("[API] " + response.getBody().getObject().get("message").toString());
            case "INVALID_REQUEST_ERROR" -> System.out.println("[INVALID_REQUEST] " + response.getBody().getObject().get("message").toString());
            case "AUTHORIZATION_ERROR" -> System.out.println("[AUTHORIZATION] " + response.getBody().getObject().get("message").toString());
            default -> System.out.println("[ERROR] " + response.getBody().getObject().get("message").toString());
        }
    }
}
