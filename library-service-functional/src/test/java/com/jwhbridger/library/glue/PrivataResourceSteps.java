package com.jwhbridger.library.glue;

import cucumber.api.java8.En;
import cucumber.runtime.java.guice.ScenarioScoped;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

@ScenarioScoped
public class PrivataResourceSteps implements En {

    @Inject
    public PrivataResourceSteps(AppController appController,
                                LibraryServiceClient libraryServiceClient) {
        Given("^I intend to get readiness status of the library service$", () -> {
            // Nothing to do
        });

        When("^I get the readiness status of the library service$", () -> {
            libraryServiceClient.getRequest("http://localhost:" + appController.getApp().getLocalPort(),
                    "private/ready",
                    MediaType.APPLICATION_JSON_TYPE);
        });
        Then("^I get a successful response$", () -> {
            System.out.println("Response: " + libraryServiceClient.getResponse().getStatus());
        });
    }
}
