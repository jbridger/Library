package com.jwhbridger.libraryservice;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class LibraryServiceApplication extends Application<LibraryServiceConfiguration> {
    @Override
    public void initialize(Bootstrap<LibraryServiceConfiguration> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );

        bootstrap.addBundle(GuiceBundle.<LibraryServiceConfiguration>builder()
                .enableAutoConfig("com.jwhbridger")
                .searchCommands()
                .build()
        );
    }

    public void run(LibraryServiceConfiguration configuration, Environment environment) throws Exception {

    }

    public static void main(final String[] args) throws Exception {
        new LibraryServiceApplication().run(args);
    }
}
