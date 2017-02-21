package com.jwhbridger.libraryservice.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/library")
@Produces(MediaType.APPLICATION_JSON)
public class LibraryResource {

    @GET
    @Timed
    public Response getAllBooks() {
        return Response.ok("blah").build();
    }
}
