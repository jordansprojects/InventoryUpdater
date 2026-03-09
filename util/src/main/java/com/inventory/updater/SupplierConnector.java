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
import java.nio.file.Paths;
import java.nio.file.Path;
/**
 *
 * @author jordan
 */
public class SupplierConnector extends Connector {

    public SupplierConnector() {
        super("/supplier.properties");
    }

    // TODO: possibly move some of this code into Connector class
    protected void getProductsList() throws URISyntaxException, IOException, InterruptedException, HttpRequestException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https", this.url, "/json", null)) //TODO: make file type configurable
                .header("Content-Type", "application/x-www-form-urlencoded")
                .GET().build();
        HttpResponse<Path> response
                = client.send(request, HttpResponse.BodyHandlers.ofFile(Paths.get(System.getProperty("user.home"), "Downloads/test-products.json")));

        if (response.statusCode() > 299 || response.statusCode() < 200) {
            throw new HttpRequestException(response.statusCode());
        }
        System.out.println("File downloaded to: " + response.body());
        
    }
}
