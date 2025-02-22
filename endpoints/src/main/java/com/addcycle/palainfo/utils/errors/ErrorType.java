package com.addcycle.palainfo.utils.errors;

public enum ErrorType {
    API_ERROR,
    INVALID_REQUEST_ERROR,
    AUTHORIZATION_ERROR;

    public ErrorType lookup(String error) {
        return switch (error) {
            case "API_ERROR" -> API_ERROR;
            case "INVALID_REQUEST_ERROR" -> INVALID_REQUEST_ERROR;
            case "AUTHORIZATION_ERROR" -> AUTHORIZATION_ERROR;
            default -> null;
        };
    }
}
