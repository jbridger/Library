package com.jwhbridger.library.glue;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}
        ,features = "src/test/resources/features/library/private_endpoints_2.feature"
        , tags = {"@group1"}
)
public class Group1BTests {
}
