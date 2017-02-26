package com.jwhbridger.library.glue;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import cucumber.api.guice.CucumberModules;
import cucumber.runtime.java.guice.InjectorSource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LibraryServiceModuleInjectorSource implements InjectorSource {
    @Override
    public Injector getInjector() {
        log.info("Creating injector");
        return Guice.createInjector(Stage.PRODUCTION, CucumberModules.SCENARIO, new LibraryServiceModule());
    }
}
