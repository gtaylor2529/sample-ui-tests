package com.sample.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    glue = {"com.sample.stepdefs"},
    features = {"src/test/resources/features/"},
    format = {"pretty", "json:target/cucumber-json/cucumber.json"},
    tags = {"@WIP"}
)

public class WIPTestRunner {

}
