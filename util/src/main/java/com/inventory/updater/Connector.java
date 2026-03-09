/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventory.updater;

import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.util.Properties;

/**
 *
 * @author jordan
 */
public class Connector {

    
    private String propertiesFile;
    protected Properties props;
    protected String url;
    
    protected HttpClient client;

    public Connector(String propertiesFile) {
        setPropertiesFile(propertiesFile);
        initProperties();
        client = HttpClient.newHttpClient();
        setUrl(this.props.getProperty("url"));
    }

    private void initProperties() {
        this.props = new Properties();
        try (InputStream fin = getClass().getResourceAsStream(propertiesFile)) {
            props.load(fin);
        } catch (IOException ex) {
            System.getLogger(ShopifyConnector.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    private void setPropertiesFile(String fileName) {
        this.propertiesFile = fileName;
        System.out.println("Set properties file " + propertiesFile);
    }

    private void setUrl(String url) {
        this.url = url;
        System.out.println("Set url " + this.url);
    }
        
}
