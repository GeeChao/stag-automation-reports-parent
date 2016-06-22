package org.stag.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.stag.utils.ExtentManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        plugin = {"pretty", "html:target/cucumber", "rerun:target/rerun.txt", "org.stag.steps.Hooks"},
        glue = {"org.stag.steps", "org.stag.runner"}
)

public class RunCucumberTests {
    @BeforeClass
    public static void startDebugCukesTest() {
        System.out.println(">> Starting run all cucumber test suite");
        ExtentManager.getReporter(System.getProperty("user.dir") + "\\target\\extentreportcucumber.html");
    }

    @AfterClass
    public static void endDebugCukesTest() {
        System.out.println(">> Finished run all cucumber test suite");
        ExtentManager.closeReporter();
    }
}
