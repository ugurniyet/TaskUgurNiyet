package com.netsparker.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    /*
    In this runner class, we determine the following;
        - plugin for report directory
        - record the failed test to use in re-run
        - tags to run
     */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},

        features = "src/test/resources/features",
        glue = "com/netsparker/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class TestRunner {
}