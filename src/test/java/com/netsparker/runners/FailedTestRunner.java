package com.netsparker.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    /*
    This class is used to re-run the failed classes
     */
@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/failed-html-report"},
        features = "@target/rerun.txt",
        glue = "com/netsparker/step_definitions"
)

public class FailedTestRunner {

}
