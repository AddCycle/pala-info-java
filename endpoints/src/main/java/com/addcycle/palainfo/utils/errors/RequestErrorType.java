package com.addcycle.palainfo.utils.errors;

public enum RequestErrorType {
    SUCCESS,
    CLIENT_ERROR,
    SERVER_ERROR,
    UNKNOWN_ERROR;

    public static RequestErrorType lookup(int error) {
        return switch (error / 100) {
            case 2 -> SUCCESS;
            case 4 -> CLIENT_ERROR;
            case 5 -> SERVER_ERROR;
            default -> UNKNOWN_ERROR;
        };
    }
}
