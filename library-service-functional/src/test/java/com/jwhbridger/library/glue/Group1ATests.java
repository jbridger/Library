package com.jwhbridger.library.glue;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}
        ,features = "src/test/resources/features/library/private_endpoints.feature"
        , tags = {"@group1"}
)
public class Group1ATests {
}
