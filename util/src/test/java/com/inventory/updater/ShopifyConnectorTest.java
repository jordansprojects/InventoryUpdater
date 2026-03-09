/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jordan
 */

package com.inventory.updater;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopifyConnectorTest {
    
    @Test
    void testGetToken() throws URISyntaxException, IOException, InterruptedException, HttpRequestException{
        ShopifyConnector con = new ShopifyConnector();
        String token = con.getToken();
        Assertions.assertNotNull(token);
    }
    
    
}
