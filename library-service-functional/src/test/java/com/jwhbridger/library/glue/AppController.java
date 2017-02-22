package com.jwhbridger.library.glue;

import com.jwhbridger.libraryservice.LibraryServiceApplication;
import com.jwhbridger.libraryservice.LibraryServiceConfiguration;
import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.DropwizardTestSupport;
import lombok.Getter;
import org.eclipse.jetty.http.HttpStatus;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Singleton
public class AppController {

    @Getter
    private DropwizardTestSupport<LibraryServiceConfiguration> app;

    private Client client;

    @Inject
    public AppController(Client client) {
        this.client = client;
        app = new DropwizardTestSupport<>(LibraryServiceApplication.class,
                "../library-service/config.yml",
                ConfigOverride.config("server.applicationConnectors[0].port", "0"),
                ConfigOverride.config("server.adminConnectors[0].port", "0")
        );
    }

    void startAndWait() {
        app.before();

        await().atMost(5, TimeUnit.SECONDS).until(() -> {
            Response response = client.target(
                    String.format("http://localhost:%d/private/ready", app.getLocalPort()))
                    .request()
                    .get();

            // TODO: Change to 200
            return response.getStatus() == HttpStatus.NOT_FOUND_404;
        });
    }

    public void stop() {
        app.after();
    }
}
