package com.addcycle.palainfo.utils.errors;

public class ErrorUtil {
    public void displayError(String error, String message, int code) {
        System.err.println("[" + error + "] " + message + " (" + code + ": " + RequestErrorType.lookup(code) + ")");
    }
}
