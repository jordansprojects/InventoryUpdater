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

public class SupplierConnectorTest {
    
    @Test
    void testGetProductList() throws URISyntaxException, IOException, InterruptedException, HttpRequestException{
        SupplierConnector con = new SupplierConnector();
        con.getProductsList();
    }
    
    
}
