/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.updater;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author jordan
 */
class ShopifyConnector extends Connector {

    public ShopifyConnector() {
        super("/shopify.properties");
    }

    protected String getToken() throws URISyntaxException, IOException, InterruptedException, HttpRequestException {
        String formData = "grant_type=client_credentials"
                + "&client_id=" + props.getProperty("id")
                + "&client_secret=" + props.getProperty("secret");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https", this.url, "/admin/oauth/access_token", null))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(formData)).build();
        HttpResponse<String> response
                = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() > 299 || response.statusCode() < 200) {
            throw new HttpRequestException(response.statusCode(), response.body());
        }
        return response.body();
    }

}
