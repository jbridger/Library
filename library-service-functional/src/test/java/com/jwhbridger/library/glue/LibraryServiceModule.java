package com.jwhbridger.library.glue;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;


public class LibraryServiceModule extends AbstractModule {


    @Override
    protected void configure() {
    }

    @Singleton
    @Provides
    public Client client() {
        return ClientBuilder.newClient();
    }
}
