package com.jwhbridger.library.glue;

import cucumber.api.java8.En;
import cucumber.runtime.java.guice.ScenarioScoped;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

@ScenarioScoped
@Slf4j
public class PrivataResourceSteps implements En {

    @Getter
    private String blah ="";

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
            try {
                log.info("Waiting..." + Thread.currentThread().getId());
                Thread.sleep(10000);
                log.info("Response: " + libraryServiceClient.getResponse().getStatus());
            } catch (InterruptedException e) {
                e.printStackTrace();
                log.error("Errored..." + Thread.currentThread().getId());
            }

        });
    }
}
