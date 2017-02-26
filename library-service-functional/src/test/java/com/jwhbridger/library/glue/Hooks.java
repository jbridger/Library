package com.jwhbridger.library.glue;

import com.google.inject.Inject;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;
import lombok.extern.slf4j.Slf4j;

@ScenarioScoped
@Slf4j
public class Hooks {

    private AppController appController;

    @Inject
    public Hooks(AppController appController) {
        this.appController = appController;
    }

    @Before
    public void setUp() {
        log.info("Setup Thread ID {}, Hooks {}", Thread.currentThread().getId(), this);
        appController.startAndWait();
    }

    @After
    public void tearDown() {
//        appController.stop();
//        Runtime.getRuntime().addShutdownHook(new Thread() {
//
//        });
    }


}
