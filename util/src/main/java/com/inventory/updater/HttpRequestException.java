/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.updater;

/**
 *
 * @author jordan
 */
public class HttpRequestException extends Exception {
    private final int statusCode;
    private final String responseBody;

    public HttpRequestException(int statusCode, String responseBody) {
        super("HTTP request failed with status " + statusCode);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}