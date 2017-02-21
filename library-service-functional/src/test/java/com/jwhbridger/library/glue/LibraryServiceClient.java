package com.jwhbridger.library.glue;


import lombok.Getter;

import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class LibraryServiceClient {

    private Client client;

    @Getter
    private Response response;

    @Inject
    public LibraryServiceClient(Client client) {
        this.client = client;
    }

    public void getRequest(String target, String resource, MediaType acceptType) {
        response = client.target(target)
                .path(resource)
                .request()
                .accept(acceptType)
                .get();
    }
}
