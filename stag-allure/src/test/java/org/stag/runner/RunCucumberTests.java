package org.stag.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        plugin = {"pretty", "html:target/cucumber", "rerun:target/rerun.txt"},
        glue = {"org.stag.steps", "org.stag.runner"}
)

public class RunCucumberTests {
    @BeforeClass
    public static void startDebugCukesTest() {
        System.out.println(">> Starting run all cucumber test suite");
    }

    @AfterClass
    public static void endDebugCukesTest() {
        System.out.println(">> Finished run all cucumber test suite");
    }
}
