package com.jwhbridger.library.glue;

import com.google.inject.Inject;
import cucumber.api.java.Before;
import cucumber.runtime.java.guice.ScenarioScoped;

@ScenarioScoped
public class Hooks {

    private AppController appController;

    @Inject
    public Hooks(AppController appController) {
        this.appController = appController;
    }

    @Before
    public void setUp() {
        appController.startAndWait();
    }
//
//    @BeforeClass
//    public void beforeClass() {
//        System.out.println("Starting");
//        libraryServiceTestSupport.before();
//    }
//
//    @AfterClass
//    public void afterClass() {
//        libraryServiceTestSupport.after();
//    }
}
