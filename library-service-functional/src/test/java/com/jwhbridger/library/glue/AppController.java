package com.jwhbridger.library.glue;

import com.jwhbridger.libraryservice.LibraryServiceApplication;
import com.jwhbridger.libraryservice.LibraryServiceConfiguration;
import io.dropwizard.testing.ConfigOverride;
import io.dropwizard.testing.DropwizardTestSupport;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.http.HttpStatus;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;

@Singleton
@Slf4j
public class AppController {

    @Getter
    private DropwizardTestSupport<LibraryServiceConfiguration> app;

    private Client client;

    @Getter
    private AtomicBoolean isAppRunning = new AtomicBoolean();

    @Inject
    public AppController(Client client) {
        this.client = client;

    }

    void startAndWait() {
        if (isAppRunning.compareAndSet(false, true)) {
            log.info("Starting - Thread ID {}, AppControlller {}", Thread.currentThread().getId(), this);

            app = new DropwizardTestSupport<>(LibraryServiceApplication.class,
                    "../library-service/config.yml",
                    ConfigOverride.config("server.applicationConnectors[0].port", "0"),
                    ConfigOverride.config("server.adminConnectors[0].port", "0")
            );

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

    }

    void stop() {
        if (isAppRunning.compareAndSet(true, false)) {
            if (app != null) {
                app.after();
            }
        }
    }
}
