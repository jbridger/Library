package com.jwhbridger.library.glue;

import cucumber.api.java8.En;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class LibrarySteps implements En {
    public LibrarySteps() {
        Given("^I intend to get all books$", () -> {
            // Nothing to do
        });
    }
}
