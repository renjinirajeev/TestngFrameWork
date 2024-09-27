package com.automation.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = "com.automation.steps",
        plugin = {"json:target/cucumber.json"}
)



public class TestRunner {
}
